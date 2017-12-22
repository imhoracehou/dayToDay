package com.horace.issues.forDom4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ForXinhua {
	public static void main(String[] args) throws Exception {

		// 加载文件返回文件的输入流
		File folder = new File("E:\\a");
		File allFiles[] = folder.listFiles();
		for (int i = 0; i < allFiles.length; i++) {
			StringBuffer one = new StringBuffer();

			// 读取并增加根节点
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(allFiles[i]), "GBk"));
			String readLine = null;
			StringBuffer readTxt = new StringBuffer("<root>");
			while ((readLine = br.readLine()) != null) {
				if (readLine.contains("&")) {
					// XML不支持“&”，需要转义
					readLine = readLine.replace("&", "&amp;");
				}
				readTxt.append(readLine);
			}
			readTxt.append("</root>");
			br.close();

			// 创建SAXReader对象
			SAXReader reader = new SAXReader();
			// 读取文件 转换成Document
			InputStream is = new ByteArrayInputStream(readTxt.toString().getBytes());
			Document document = reader.read(is);
			// 获取根节点元素对象
			Element root = document.getRootElement();
			// 获取所有的doc
			List<Element> docs = root.elements();
			for (Element doc : docs) {
				List<Element> nodes = doc.elements();
				for (int index = 0; index < nodes.size(); index++) {
					Element node = nodes.get(index);
					// String name = node.getName();// 获取当前元素名
					String text = node.getText();// 获取当前元素值
					if (text == null || "".equals(text.trim())) {
						text = "null";
					}
					if (index != 3) {
						one.append(text).append("|");
					} else {
						one.append(text);
					}
				}
				one.append("\r\n");
			}
			is.close();

			// 最后，写文件
			FileWriter fw = new FileWriter("E:\\b\\format_" + allFiles[i].getName());
			fw.write(one.toString());
			fw.close();

			// 强制垃圾回收，注意编译系统不会立刻垃圾回收，由自己的算法来决定何时执行垃圾回收
			System.gc();
		}
	}
}
