package com.oracle.wdp.xml.jdom;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.oracle.wdp.xml.jdom.entity.Book;

public class JDOMTest {
	private static List<Book> booksList = new ArrayList<Book>();
	public static void main(String[] args) {
		// ��books.xml����JDOM����
		// ����һ��SAXBuilder����new SAXBuilder()��
		SAXBuilder saxBuilder = new SAXBuilder();
		// ����һ�������� ��xml�ļ����ص���������
		try {
			InputStream in = new FileInputStream("book.xml");
			// ͨ��saxBuilder��build�����������������ص�saxBuilder��Document����document����
			Document document = saxBuilder.build(in);
			// ͨ��document�����document.getRootElement()��ȡElement rootElement
			Element rootElement = document.getRootElement();
			// rootElement.getChildren()��ȡ���ڵ��µ��ӽڵ�ļ���
			List<Element> bookList = rootElement.getChildren();

			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("===========��ʼ������" + (bookList.indexOf(book)+1)
						+ "��=========");
				
				//����book�����Լ���book.getAttributes()���õ�List<Attribute>����attrList
				List<Attribute> attrList = book.getAttributes();
				
				//֪����������ȡֵ
				String idValue = book.getAttributeValue("id");
	
				//����for (Attribute attr : attrList)
				for (Attribute attr : attrList) {
				String attrName=attr.getName();
				String attrValue = attr.getValue();
				System.out.println("��������"+attrName+"----����ֵ:"+attrValue);
					if("id".equals(attrName)){
						bookEntity.setId(attrValue);
					}	
				}
				//ͨ��book.getChildren()����ȡ���еĽڵ㼯��List<Element> bookChilds
				List<Element> bookChilds =book.getChildren();
				for (Element child : bookChilds) {
					System.out.println("�ڵ�����"+child.getName()+"---�ڵ�ֵ:"+child.getValue());
				if("name".equals(child.getName())){
						bookEntity.setName(child.getValue());
				}else if("author".equals(child.getName())){
					bookEntity.setAuthor(child.getValue());
				}else if("year".equals(child.getName())){
					bookEntity.setYear(child.getValue());
				}else if("price".equals(child.getName())){
					bookEntity.setPrice(child.getValue());
				}else if("Language".equals(child.getName())){
					bookEntity.setLanguage(child.getValue());
				}
					
				System.out.println("===========����������" + (bookList.indexOf(book)+1)
						+ "��=========");
				booksList.add(bookEntity);
				bookEntity = null;
			}
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
