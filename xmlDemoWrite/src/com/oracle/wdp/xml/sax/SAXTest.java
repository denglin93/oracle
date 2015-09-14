package com.oracle.wdp.xml.sax;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

import com.oracle.wdp.xml.sax.entity.Book;

public class SAXTest {
	public void createXML() {
		List<Book> bookList = parseXML();
		// 生成xml
		// 1.创建TransformerFactory对象
		SAXTransformerFactory ttf = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		//
		try {
			// 2.通过SAXTransformerFactory创建一个TransformerHandler对象
			TransformerHandler handler = ttf.newTransformerHandler();

			// 3.通过handler对象创建一个Transformer对象
			Transformer tf = handler.getTransformer();
			// 4.通过Transformer对象对生成的xml文件进行设置，编码，是否换行
			tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			// 5.创建一个Result对象
			File file = new File("src/books.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			// 6.创建result对象 使其与handler对象关联
			Result result = new StreamResult(new FileOutputStream(file));
			handler.setResult(result);
			// 7.利用handler对象进行xml内容编写
			// 打开文档

			handler.startDocument();
			//
			AttributesImpl attr = new AttributesImpl();

			handler.startElement("", "", "bookStore", attr);

			for (Book books : bookList) {
				attr.clear();
				attr.addAttribute("", "", "id", "", books.getId());
				handler.startElement("", "", "book", attr);
				if (books.getName() != null
						&& !books.getName().trim().equals("")) {
					attr.clear();
					handler.startElement("", "", "name", attr);
					handler.characters(books.getName().toCharArray(), 0, books
							.getName().length());
					handler.endElement("", "", "name");
				}
				if (books.getYear() != null
						&& !books.getYear().trim().equals("")) {
					attr.clear();
					// year节点
					handler.startElement("", "", "year", attr);
					handler.characters(books.getYear().toCharArray(), 0, books
							.getYear().length());
					handler.endElement("", "", "year");
				}
				if (books.getAuthor() != null
						&& !books.getAuthor().trim().equals("")) {
					attr.clear();
					// author节点
					handler.startElement("", "", "author", attr);
					handler.characters(books.getAuthor().toCharArray(), 0,
							books.getAuthor().length());
					handler.endElement("", "", "author");
				}
				if (books.getLanguage() != null
						&& !books.getLanguage().trim().equals("")) {
					attr.clear();
					// language节点
					handler.startElement("", "", "language", attr);
					handler.characters(books.getLanguage().toCharArray(), 0,
							books.getLanguage().length());
					handler.endElement("", "", "language");

				}

				handler.endElement("", "", "book");
			}

			handler.endElement("", "", "bookStore");
			// 关闭文档
			handler.endDocument();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Book> parseXML() {
		// 通过SAXParserFactory.newInstance()获得SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		SAXParserHandler handler = null;
		try {
			// 通过factory.newSAXParser()得到SAXParserl类型的parser
			parser = factory.newSAXParser();
			// 想要通过sax解析xml必须传入一个继承DefaultHandler的类SAXParserHandler
			handler = new SAXParserHandler();
			// 通过parser.parse("book.xml", handler)去解析xml文件
			parser.parse("book.xml", handler);

			/*
			 * for (Book s : handler.getList()) {
			 * System.out.println(s.getName()); }
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return handler.getList();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXTest st = new SAXTest();
		st.createXML();
	}

}
