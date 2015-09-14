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
		// 得到SAXReader reader 对象
		SAXReader reader = new SAXReader();
		try {// 通过reader对象的reader方法加载book.xml文件，获取document对象reader.read(new
				// File("book.xml"))
			Document document = reader.read(new File("book.xml"));
			// 通过document对象获取跟节点document.getRootElement()来获取Element bookStore
			Element bookStore = document.getRootElement();
			// 通过获取迭代器bookStore.elementIterator()来得到Iterator it
			Iterator it = bookStore.elementIterator();
			// 遍历迭代器，获取根节点的信息while (it.hasNext())
			while (it.hasNext()) {
				System.out.println("===============开始遍历某一本书================");
				Book bookEntity = new Book();
				// 通过迭代来获取Element book
				Element book = (Element) it.next();
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("属性名：" + attr.getName() + "--属性值："
							+ attr.getValue());
					if ("id".equals(attr.getName())) {
						bookEntity.setId(attr.getValue());
					}
				}
				// 通过book.elementIterator()来得到Iterator itt
				Iterator itt = book.elementIterator();

				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					System.out.println("节点名：" + bookChild.getName() + "---节点值:"
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
						.println("===================结束谋一本书的遍历================");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createXML() {
		// 1.创建document对象，代表整个xml文档
		Document document = DocumentHelper.createDocument();
		// 2.创建根节点rss
		Element rss = document.addElement("rss");
		// 3.向rss中添加version属性
		rss.addAttribute("version", "2.0");
		// 4.生成子节点以及内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("国内最新新闻");
		//5.设置生车xml的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//6.生成xml文件
		File file = new File("rssnews.xml");
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
			//设置是否转义
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
