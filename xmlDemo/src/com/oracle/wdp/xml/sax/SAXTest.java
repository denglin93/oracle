package com.oracle.wdp.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.oracle.wdp.xml.sax.entity.Book;

public class SAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获得SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//得到SAXParser
		try {
			SAXParser parser = factory.newSAXParser();
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("book.xml", handler);

			for (Book s : handler.getList()) {
				System.out.println(s.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
