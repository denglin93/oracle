package com.oracle.wdp.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.oracle.wdp.xml.sax.entity.Book;

public class SAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ͨ��SAXParserFactory.newInstance()���SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			//ͨ��factory.newSAXParser()�õ�SAXParserl���͵�parser
			SAXParser parser = factory.newSAXParser();
			//��Ҫͨ��sax����xml���봫��һ���̳�DefaultHandler����SAXParserHandler
			SAXParserHandler handler = new SAXParserHandler();
			//ͨ��parser.parse("book.xml", handler)ȥ����xml�ļ�
			parser.parse("book.xml", handler);

			/*for (Book s : handler.getList()) {
				System.out.println(s.getName());
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
