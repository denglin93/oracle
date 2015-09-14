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
		// ����xml
		// 1.����TransformerFactory����
		SAXTransformerFactory ttf = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		//
		try {
			// 2.ͨ��SAXTransformerFactory����һ��TransformerHandler����
			TransformerHandler handler = ttf.newTransformerHandler();

			// 3.ͨ��handler���󴴽�һ��Transformer����
			Transformer tf = handler.getTransformer();
			// 4.ͨ��Transformer��������ɵ�xml�ļ��������ã����룬�Ƿ���
			tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			// 5.����һ��Result����
			File file = new File("src/books.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			// 6.����result���� ʹ����handler�������
			Result result = new StreamResult(new FileOutputStream(file));
			handler.setResult(result);
			// 7.����handler�������xml���ݱ�д
			// ���ĵ�

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
					// year�ڵ�
					handler.startElement("", "", "year", attr);
					handler.characters(books.getYear().toCharArray(), 0, books
							.getYear().length());
					handler.endElement("", "", "year");
				}
				if (books.getAuthor() != null
						&& !books.getAuthor().trim().equals("")) {
					attr.clear();
					// author�ڵ�
					handler.startElement("", "", "author", attr);
					handler.characters(books.getAuthor().toCharArray(), 0,
							books.getAuthor().length());
					handler.endElement("", "", "author");
				}
				if (books.getLanguage() != null
						&& !books.getLanguage().trim().equals("")) {
					attr.clear();
					// language�ڵ�
					handler.startElement("", "", "language", attr);
					handler.characters(books.getLanguage().toCharArray(), 0,
							books.getLanguage().length());
					handler.endElement("", "", "language");

				}

				handler.endElement("", "", "book");
			}

			handler.endElement("", "", "bookStore");
			// �ر��ĵ�
			handler.endDocument();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Book> parseXML() {
		// ͨ��SAXParserFactory.newInstance()���SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		SAXParserHandler handler = null;
		try {
			// ͨ��factory.newSAXParser()�õ�SAXParserl���͵�parser
			parser = factory.newSAXParser();
			// ��Ҫͨ��sax����xml���봫��һ���̳�DefaultHandler����SAXParserHandler
			handler = new SAXParserHandler();
			// ͨ��parser.parse("book.xml", handler)ȥ����xml�ļ�
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
