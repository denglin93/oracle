package com.oracle.wdp.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.oracle.wdp.xml.sax.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	// ����xml�Ŀ�ʼ��ǩ
	String value = null;
	Book book = null;
	private List<Book> list = new ArrayList<Book>();
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// ���ø����default
		super.startElement(uri, localName, qName, attributes);
		if ("book".equals(qName)) {
			// ����������Ĳ�������Ҫ�����Ľڵ�����һ����ʼ��������һ��book����
			book = new Book();
			System.out.println("================һ���������ʼ=================");
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("bookԪ�صĵ�" + (i + 1) + "�������ǣ�"
						+ attributes.getQName(i));
				System.out.println("----����ֵ�ǣ�"
						+ attributes.getValue(attributes.getQName(i)));
				if ("id".equals(attributes.getQName(i))) {
					book.setId(attributes.getValue(attributes.getQName(i)));
				}
			}
		} else if (!"book".equals(qName) && !"bookstore".equals(qName)) {
			System.out.print("�ڵ����ǣ�" + qName + "--");
		}
	}

	// ����xml�Ľ�����ǩ
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if ("book".equals(qName)) {
			list.add(book);
			book = null;
			System.out.println("=================һ����������================");
		}else if("name".equals(qName)){
			book.setName(value);
		}else if("author".equals(qName)){
			book.setAuthor(value);
		}else if("year".equals(qName)){
			book.setYear(value);
		}else if("price".equals(qName)){
			book.setPrice(value);
		}else if("language".equals(qName)){
			book.setLanguage(value);
		}
		
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!value.trim().equals("")) {
			System.out.println("�ڵ�ֵ��:" + value);
		}
	}

	// ������ʾ������ʼ
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("=============������ʼ=============");
	}

	// ������ʾ��������
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("===============��������============");
	}

	public List<Book> getList() {
		return list;
	}
	
}
