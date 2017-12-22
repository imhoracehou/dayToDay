package com.horace.issues.forSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandle extends DefaultHandler {

	/**
	 * 标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("----解析开始----");
	}

	/**
	 * 标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("----解析结束----");
	}

	/*
	 * 解析XML元素
	 */
	@Override
	public void startElement(String arg0, String arg1, String name, Attributes attributes) throws SAXException {
		super.startElement(arg0, arg1, name, attributes);
		if (name.equals("doc")) {
			System.out.println("----遍历开始----");
		} else if (!name.equals("doc")) {
			System.out.println("子节点：" + name);
		}
	}

	@Override
	public void endElement(String arg0, String arg1, String name) throws SAXException {
		super.endElement(arg0, arg1, name);
		if (name.equals("doc")) {
			System.out.println("----遍历结束----");
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String nodeValue = new String(ch, start, length);
		if (!nodeValue.trim().equals("")) {
			System.out.println("值：" + nodeValue);
		} else {
			System.out.println("值：null");
		}
	}
}
