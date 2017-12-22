package xmlStream;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

/**
 * 
 * StAX采用"拉(pull)"的方法来处理XML <br>
 * 通过一种基于事件迭代器(Iterator)的API让程序员去控制xml文档解析过程,程序遍历这个事件迭代器去处理每一个解析事件. <br>
 * 也就是程序促使解析器产生一个解析事件然后处理该事件，之后又促使解析器产生下一个解析事件，如此循环直到碰到文档结束符。
 */
public class XMLStreamTest {
	public static void main(String[] args) throws Exception {
		// create InputStream
		Path path = Paths.get("e:/test.xml");
		InputStream is = Files.newInputStream(path);
		//
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(is, StandardCharsets.UTF_8.name());
		while (xmlStreamReader.hasNext()) {
			int point = xmlStreamReader.next();
			switch (point) {
			case XMLStreamReader.START_ELEMENT: {
				String localName = xmlStreamReader.getLocalName();
				System.out.print(localName);
				int count = xmlStreamReader.getAttributeCount();
				for (int i = 0; i < count; i++) {
					String name = xmlStreamReader.getAttributeLocalName(i);
					String value = xmlStreamReader.getAttributeValue(i);
					System.out.println("\t" + name + ":" + value);
				}
				if (localName.contains("-")) {
					// 必须放在 getAttributeCount() 方法后面
					System.out.print(" : " + xmlStreamReader.getElementText());
				}
				System.out.println();
			}
			}

			xmlStreamReader.next();
		}
		System.out.println("end...");
		xmlStreamReader.close();
		is.close();
	}
}
