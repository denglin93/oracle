package com.oracle.wdp.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {

	public static void main(String[] args) {
		// ��ȡDocumentBuilderFacotry ����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����DocumentBuilder����
		try {
			// ����xml�ĵ�
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse("book.xml");
			// ��ȡ�ڵ�
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("һ����" + bookList.getLength() + "����");
			for (int i = 0; i < bookList.getLength(); i++) {
				// ��ȡһ��book�ڵ�
				Node book = bookList.item(i);
				System.out.println("==============���濪ʼ������" + (i + 1)
						+ "���飬���������:==============");
				// ��ȡbookһ���ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ��item������ȡĳһ������
					Node node = attrs.item(j);
			
					System.out.println("��������" + node.getNodeName());
					System.out.println("����ֵ:" + node.getNodeValue());
					
				}
				System.out.println("==============�������������" + (i + 1)
						+ "����:==============");
				NodeList childNodes = book.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						//��ȡ��element���͵Ľڵ�
						//�����ǻ�ȡ�ýڵ��µĵ�һ���ӽڵ��value
						//System.out.println(childNodes.item(j).getNodeName()+":"+childNodes.item(j).getFirstChild().getNodeValue());
					//��ȡ�ýڵ��µ����е������ӽڵ������
						System.out.println(childNodes.item(j).getTextContent());
					}

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
