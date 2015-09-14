package com.oracle.wdp.xml.dom4j;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.oracle.wdp.xml.dom4j.entity.copy.Book;

public class DOM4JTest {
	private static List<Book> list = new ArrayList<Book>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�õ�SAXReader reader ����
		SAXReader reader = new SAXReader();
		try {// ͨ��reader�����reader��������book.xml�ļ�����ȡdocument����reader.read(new File("book.xml"))
			Document document = reader.read(new File("book.xml"));
			// ͨ��document�����ȡ���ڵ�document.getRootElement()����ȡElement bookStore
			Element bookStore = document.getRootElement();
			// ͨ����ȡ������bookStore.elementIterator()���õ�Iterator it
			Iterator it = bookStore.elementIterator();
			// ��������������ȡ���ڵ����Ϣwhile (it.hasNext())
			while (it.hasNext()) {
				System.out.println("===============��ʼ����ĳһ����================");
				Book bookEntity = new Book();
				//ͨ����������ȡElement book
				Element book = (Element) it.next();
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("��������" + attr.getName() + "--����ֵ��"
							+ attr.getValue());
					if ("id".equals(attr.getName())) {
						bookEntity.setId(attr.getValue());
					}
				}
				//ͨ��book.elementIterator()���õ�Iterator itt
				Iterator itt = book.elementIterator();

				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					System.out.println("�ڵ�����" + bookChild.getName() + "---�ڵ�ֵ:"
							+ bookChild.getStringValue());
					if ("name".equals(bookChild.getName())) {
						bookEntity.setName(bookChild.getStringValue());
					} else if ("author".equals(bookChild.getName())) {
						bookEntity.setAuthor(bookChild.getStringValue());
					} else if ("year".equals(bookChild.getName())) {
						bookEntity.setYear(bookChild.getStringValue());
					} else if ("price".equals(bookChild.getName())) {
						bookEntity.setPrice(bookChild.getStringValue());
					} else if ("Language".equals(bookChild.getName())) {
						bookEntity.setLanguage(bookChild.getStringValue());
					}
				}
				list.add(bookEntity);
				bookEntity = null;
				System.out
						.println("===================����ıһ����ı���================");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
