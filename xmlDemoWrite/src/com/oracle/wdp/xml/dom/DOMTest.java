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
		// 创建DocumentBuilder对象
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
		//创建根节点
		Element bookStore = document.createElement("bookStore");
		//创建book节点
		Element book = document.createElement("book");
		book.setAttribute("id", "1");
		Element name = document.createElement("name");
		name.setTextContent("小王子");
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
		//讲book节点向根节点中添加子节点
		bookStore.appendChild(book);
		//将bookstore节点添加到dom树中
		document.appendChild(bookStore);
		
		//创建TransformerFactory对象
		TransformerFactory tff = TransformerFactory.newInstance();
		try {//创建Transformer对象
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document),new StreamResult(new File("books.xml")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void xmlParser() {

		try {// 通过DocumentBuilder加载xml文档得到document对象
			Document document = getDocumentBuilder().parse("book.xml");
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
					// 通过遍历attrs.item()方法获取某一个属性Node类型的node
					// ，从而根据node.getNodeName()和node.getNodeValue()来获取节点名称和值
					Node node = attrs.item(j);

					System.out.println("属性名：" + node.getNodeName());
					System.out.println("属性值:" + node.getNodeValue());

				}
				System.out.println("==============下面结束遍历第" + (i + 1)
						+ "本书:==============");
				// 通过book.getChildNodes()来获取所有的子节点返回NodeList类型的childNodes
				NodeList childNodes = book.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						// 获取了element类型的节点
						// 仅仅是获取该节点下的第一个子节点的value
						// System.out.println(childNodes.item(j).getNodeName()+":"+childNodes.item(j).getFirstChild().getNodeValue());
						// 获取该节点下的所有的所有子节点的内容
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
		// 获取DocumentBuilderFacotry 对象
		DOMTest dt = new DOMTest();
		//dt.xmlParser();
		dt.createXML();

	}

}
