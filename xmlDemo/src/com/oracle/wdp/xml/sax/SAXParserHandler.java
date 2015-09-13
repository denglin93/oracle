package com.oracle.wdp.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.oracle.wdp.xml.sax.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	// 遍历xml的开始标签
	String value = null;
	Book book = null;
	private List<Book> list = new ArrayList<Book>();
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 调用父类的default
		super.startElement(uri, localName, qName, attributes);
		if ("book".equals(qName)) {
			// 如果传过来的参数与所要解析的节点名称一样则开始解析创建一个book对象
			book = new Book();
			System.out.println("================一本书解析开始=================");
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("book元素的第" + (i + 1) + "属性名是："
						+ attributes.getQName(i));
				System.out.println("----属性值是："
						+ attributes.getValue(attributes.getQName(i)));
				if ("id".equals(attributes.getQName(i))) {
					book.setId(attributes.getValue(attributes.getQName(i)));
				}
			}
		} else if (!"book".equals(qName) && !"bookstore".equals(qName)) {
			System.out.print("节点名是：" + qName + "--");
		}
	}

	// 遍历xml的结束标签
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if ("book".equals(qName)) {
			list.add(book);
			book = null;
			System.out.println("=================一本书解析完毕================");
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
			System.out.println("节点值是:" + value);
		}
	}

	// 用来表示解析开始
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("=============解析开始=============");
	}

	// 用来表示解析结束
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("===============解析结束============");
	}

	public List<Book> getList() {
		return list;
	}
	
}
