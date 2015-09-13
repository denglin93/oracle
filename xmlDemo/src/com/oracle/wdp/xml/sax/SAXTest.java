package com.oracle.wdp.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.oracle.wdp.xml.sax.entity.Book;

public class SAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//通过SAXParserFactory.newInstance()获得SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			//通过factory.newSAXParser()得到SAXParserl类型的parser
			SAXParser parser = factory.newSAXParser();
			//想要通过sax解析xml必须传入一个继承DefaultHandler的类SAXParserHandler
			SAXParserHandler handler = new SAXParserHandler();
			//通过parser.parse("book.xml", handler)去解析xml文件
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
