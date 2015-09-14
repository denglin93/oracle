package com.oracle.wdp.xml.jdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.oracle.wdp.xml.jdom.entity.Book;

public class JDOMTest {
	private static List<Book> booksList = new ArrayList<Book>();

	public void parseXML() {
		// 对books.xml进行JDOM解析
		// 创建一个SAXBuilder对象new SAXBuilder()；
		SAXBuilder saxBuilder = new SAXBuilder();
		// 创建一个输入流 将xml文件加载到输入流中
		try {
			InputStream in = new FileInputStream("book.xml");
			// 通过saxBuilder的build方法，将输入流加载到saxBuilder中Document类型document对象
			Document document = saxBuilder.build(in);
			// 通过document对象的document.getRootElement()获取Element rootElement
			Element rootElement = document.getRootElement();
			// rootElement.getChildren()获取根节点下的子节点的集合
			List<Element> bookList = rootElement.getChildren();

			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("===========开始解析第"
						+ (bookList.indexOf(book) + 1) + "书=========");

				// 解析book的属性集合book.getAttributes()来得到List<Attribute>类型attrList
				List<Attribute> attrList = book.getAttributes();

				// 知道属性名获取值
				String idValue = book.getAttributeValue("id");

				// 遍历for (Attribute attr : attrList)
				for (Attribute attr : attrList) {
					String attrName = attr.getName();
					String attrValue = attr.getValue();
					System.out.println("属性名：" + attrName + "----属性值:"
							+ attrValue);
					if ("id".equals(attrName)) {
						bookEntity.setId(attrValue);
					}
				}
				// 通过book.getChildren()来获取所有的节点集合List<Element> bookChilds
				List<Element> bookChilds = book.getChildren();
				for (Element child : bookChilds) {
					System.out.println("节点名：" + child.getName() + "---节点值:"
							+ child.getValue());
					if ("name".equals(child.getName())) {
						bookEntity.setName(child.getValue());
					} else if ("author".equals(child.getName())) {
						bookEntity.setAuthor(child.getValue());
					} else if ("year".equals(child.getName())) {
						bookEntity.setYear(child.getValue());
					} else if ("price".equals(child.getName())) {
						bookEntity.setPrice(child.getValue());
					} else if ("Language".equals(child.getName())) {
						bookEntity.setLanguage(child.getValue());
					}

					System.out.println("===========结束解析第"
							+ (bookList.indexOf(book) + 1) + "书=========");
					booksList.add(bookEntity);
					bookEntity = null;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createXML(){
		//1.生成一个根节点
		Element rss= new Element("rss");
		//2.添加属性
		rss.setAttribute("version", "2.0");
		//3.生成一个document对象
		Document document = new Document(rss);
		
		Element channel = new Element("channle");
		rss.addContent(channel);
		Element title = new Element("title");
		title.setText("<>国际新闻");
		channel.addContent(title);
		
		Format format = Format.getPrettyFormat();
		format.setIndent("");
		format.setEncoding("utf-8");
		
		//4.创建XMLOutputter 对象
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			outputer.output(document, new FileOutputStream(new File("rssnews1.xml")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//
		
	}
	public static void main(String[] args) {
JDOMTest j = new JDOMTest();
j.createXML();
	}

}
