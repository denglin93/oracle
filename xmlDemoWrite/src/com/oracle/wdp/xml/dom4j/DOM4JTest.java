package com.oracle.wdp.xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.oracle.wdp.xml.dom4j.entity.copy.Book;

public class DOM4JTest {
	private static List<Book> list = new ArrayList<Book>();

	public void parseXML() {
		// �õ�SAXReader reader ����
		SAXReader reader = new SAXReader();
		try {// ͨ��reader�����reader��������book.xml�ļ�����ȡdocument����reader.read(new
				// File("book.xml"))
			Document document = reader.read(new File("book.xml"));
			// ͨ��document�����ȡ���ڵ�document.getRootElement()����ȡElement bookStore
			Element bookStore = document.getRootElement();
			// ͨ����ȡ������bookStore.elementIterator()���õ�Iterator it
			Iterator it = bookStore.elementIterator();
			// ��������������ȡ���ڵ����Ϣwhile (it.hasNext())
			while (it.hasNext()) {
				System.out.println("===============��ʼ����ĳһ����================");
				Book bookEntity = new Book();
				// ͨ����������ȡElement book
				Element book = (Element) it.next();
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("��������" + attr.getName() + "--����ֵ��"
							+ attr.getValue());
					if ("id".equals(attr.getName())) {
						bookEntity.setId(attr.getValue());
					}
				}
				// ͨ��book.elementIterator()���õ�Iterator itt
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

	public void createXML() {
		// 1.����document���󣬴�������xml�ĵ�
		Document document = DocumentHelper.createDocument();
		// 2.�������ڵ�rss
		Element rss = document.addElement("rss");
		// 3.��rss�����version����
		rss.addAttribute("version", "2.0");
		// 4.�����ӽڵ��Լ�����
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("������������");
		//5.��������xml�ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//6.����xml�ļ�
		File file = new File("rssnews.xml");
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
			//�����Ƿ�ת��
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOM4JTest d = new DOM4JTest();
		d.createXML();
	}

}
