package com.oracle.wdp.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {
	public DocumentBuilder getDocumentBuilder() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����DocumentBuilder����
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}

	public void createXML() {
		DocumentBuilder db = getDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		//�������ڵ�
		Element bookStore = document.createElement("bookStore");
		//����book�ڵ�
		Element book = document.createElement("book");
		book.setAttribute("id", "1");
		Element name = document.createElement("name");
		name.setTextContent("С����");
		Element author = document.createElement("author");
		author.setTextContent("D02");
		Element year = document.createElement("year");
		year.setTextContent("2018");
		Element price = document.createElement("price");
		price.setTextContent("89");
		book.appendChild(year);
		book.appendChild(price);
		book.appendChild(author);
		book.appendChild(name);
		//��book�ڵ�����ڵ�������ӽڵ�
		bookStore.appendChild(book);
		//��bookstore�ڵ���ӵ�dom����
		document.appendChild(bookStore);
		
		//����TransformerFactory����
		TransformerFactory tff = TransformerFactory.newInstance();
		try {//����Transformer����
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document),new StreamResult(new File("books.xml")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void xmlParser() {

		try {// ͨ��DocumentBuilder����xml�ĵ��õ�document����
			Document document = getDocumentBuilder().parse("book.xml");
			// ͨ��document.getElementsByTagName()����ȡ����ڵ�NodeList bookList
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("һ����" + bookList.getLength() + "����");
			for (int i = 0; i < bookList.getLength(); i++) {
				// ͨ��bookList.item(i)������ȡÿһ��book�ڵ�,�õ�Node���͵�book
				Node book = bookList.item(i);
				System.out.println("==============���濪ʼ������" + (i + 1)
						+ "���飬���������:==============");
				// ͨ��book.getAttributes()����ȡһ���ڵ���������Լ��ϵõ�NamedNodeMap����attrs
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ������attrs.item()������ȡĳһ������Node���͵�node
					// ���Ӷ�����node.getNodeName()��node.getNodeValue()����ȡ�ڵ����ƺ�ֵ
					Node node = attrs.item(j);

					System.out.println("��������" + node.getNodeName());
					System.out.println("����ֵ:" + node.getNodeValue());

				}
				System.out.println("==============�������������" + (i + 1)
						+ "����:==============");
				// ͨ��book.getChildNodes()����ȡ���е��ӽڵ㷵��NodeList���͵�childNodes
				NodeList childNodes = book.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						// ��ȡ��element���͵Ľڵ�
						// �����ǻ�ȡ�ýڵ��µĵ�һ���ӽڵ��value
						// System.out.println(childNodes.item(j).getNodeName()+":"+childNodes.item(j).getFirstChild().getNodeValue());
						// ��ȡ�ýڵ��µ����е������ӽڵ������
						System.out.println(childNodes.item(j).getTextContent());
					}

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// ��ȡDocumentBuilderFacotry ����
		DOMTest dt = new DOMTest();
		//dt.xmlParser();
		dt.createXML();

	}

}
