package com.horace.issues.forSAX;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ForXinhua {

	/**
	 * sax解析一个文件夹下所有的XML文件，并且保存为【url|id|title|content】格式
	 */
	public static void main(String[] args) throws Exception {
		// 加载文件返回文件的输入流
		File folder = new File("E:\\t");
		File allFiles[] = folder.listFiles();
		System.out.println(allFiles.length);
		for (int i = 0; i < allFiles.length; i++) {

			File tempFile = allFiles[i];
			FileReader fileReader = new FileReader(tempFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String readLine = null;
			StringBuffer readTxt = new StringBuffer("<root>");
			while ((readLine = reader.readLine()) != null) {
				readTxt.append(readLine);
			}
			readTxt.append("/<root>");
			reader.close();
			
			InputStream is = new ByteArrayInputStream(readTxt.toString().getBytes());
			// 1. 得到SAX解析工厂
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			// 2. 让工厂生产一个sax解析器
			SAXParser newSAXParser = saxParserFactory.newSAXParser();
			SAXParserHandle dh = new SAXParserHandle();
			newSAXParser.parse(is, dh);
			is.close();
		}
	}
}
