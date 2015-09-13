package com.oracle.wdp.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {

	public static void main(String[] args) {
		// 获取DocumentBuilderFacotry 对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// 创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			//通过DocumentBuilder加载xml文档得到document对象
			Document document = db.parse("book.xml");
			// 通过document.getElementsByTagName()来获取多个节点NodeList bookList
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("一共有" + bookList.getLength() + "本书");
			for (int i = 0; i < bookList.getLength(); i++) {
				// 通过bookList.item(i)遍历获取每一个book节点,得到Node类型的book
				Node book = bookList.item(i);
				System.out.println("==============下面开始遍历第" + (i + 1)
						+ "本书，书的内容是:==============");
				// 通过book.getAttributes()来获取一个节点的所有属性集合得到NamedNodeMap类型attrs
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过遍历attrs.item()方法获取某一个属性Node类型的node ，从而根据node.getNodeName()和node.getNodeValue()来获取节点名称和值
					Node node = attrs.item(j);
			
					System.out.println("属性名：" + node.getNodeName());
					System.out.println("属性值:" + node.getNodeValue());
					
				}
				System.out.println("==============下面结束遍历第" + (i + 1)
						+ "本书:==============");
				//通过book.getChildNodes()来获取所有的子节点返回NodeList类型的childNodes
				NodeList childNodes = book.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						//获取了element类型的节点
						//仅仅是获取该节点下的第一个子节点的value
						//System.out.println(childNodes.item(j).getNodeName()+":"+childNodes.item(j).getFirstChild().getNodeValue());
					//获取该节点下的所有的所有子节点的内容
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
