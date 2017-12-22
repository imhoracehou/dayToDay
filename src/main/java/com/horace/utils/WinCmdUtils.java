package com.horace.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class WinCmdUtils {

	public static void main(String[] args) {
		String batFile = "C:\\Program Files\\Kontek\\Kontek Web\\glassfish\\bin\\asadmin.bat";
		String[] cmd1 = new String[] { batFile, "list-domains" };
		String status = WinCmdUtils.runWindowsCommand(cmd1);
		System.out.println(status);
		String[] cmd2 = new String[] { "chcp 437", batFile, "list-domains" };
		status = WinCmdUtils.runWindowsCommand(cmd2);
		System.out.println(status);
	}

	public static String runWindowsCommand(String[] cmdArray) {
		try {
			ProcessBuilder pb = new ProcessBuilder(cmdArray);
			pb.directory(new File("."));
			Process p = pb.start();
			p.waitFor();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String line;
			StringBuilder resultMessage = new StringBuilder();
			while ((line = r.readLine()) != null) {
				resultMessage.append(line);
			}
			r.close();

			resultMessage.append(System.getProperty("line.separator"));
			r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = r.readLine()) != null) {
				resultMessage.append(line);
			}
			r.close();

			p.destroy();
			return resultMessage.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String runWindowsCommandAndExitWithReturn(String[] cmdArray, String expectedReturnMessage) {
		try {
			ProcessBuilder pb = new ProcessBuilder(cmdArray);
			pb.directory(new File("."));
			Process p = pb.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			StringBuilder resultMessage = new StringBuilder();
			while ((line = r.readLine()) != null) {
				resultMessage.append(line);
				if (line.contains(expectedReturnMessage)) {
					break;
				}
			}

			resultMessage.append(System.getProperty("line.separator"));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = errorReader.readLine()) != null) {
				resultMessage.append(line);
				if (line.contains(expectedReturnMessage)) {
					break;
				}
			}

			p.waitFor();

			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
			p.destroy();
			return resultMessage.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
