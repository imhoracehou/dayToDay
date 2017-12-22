package io;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReplaceGlassfishPathForInstaller {
	public static void main(String[] args) throws IOException {
		String url = Class.class.getClass().getResource("/").getPath();
		if (url.startsWith("/") || url.startsWith("\\")) {
			url = url.substring(1, url.length());
		}
		File file = new File(url + "domains\\domain1\\bin\\kontek_glassfishService.xml");
		FileReader in = new FileReader(file);
		BufferedReader bufIn = new BufferedReader(in);
		CharArrayWriter tempStream = new CharArrayWriter();
		String line = null;
		while ((line = bufIn.readLine()) != null) {
			line = line.replace("[RealGlassfishPath]", url);
			tempStream.write(line);
			tempStream.append(System.getProperty("line.separator"));
		}
		bufIn.close();
		in.close();
		FileWriter out = new FileWriter(file);
		tempStream.writeTo(out);
		out.close();
	}
}
