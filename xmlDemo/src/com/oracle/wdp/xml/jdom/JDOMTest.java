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
		// 对books.xml进行JDOM解析
		// 创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		// 创建一个输入流 将xml文件加载到输入流中
		try {
			InputStream in = new FileInputStream("book.xml");
			// 通过saxBuilder的build方法，将输入流加载到saxBuilder中
			Document document = saxBuilder.build(in);
			// 通过document对象获取xml的文件的根节点
			Element rootElement = document.getRootElement();
			// 获取根节点下的子节点的集合
			List<Element> bookList = rootElement.getChildren();

			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("===========开始解析第" + (bookList.indexOf(book)+1)
						+ "书=========");
				
				//解析book的属性集合
				List<Attribute> attrList = book.getAttributes();
				
				//知道属性名获取值
				String idValue = book.getAttributeValue("id");
	
				//遍历
				for (Attribute attr : attrList) {
				String attrName=attr.getName();
				String attrValue = attr.getValue();
				System.out.println("属性名："+attrName+"----属性值:"+attrValue);
					if("id".equals(attrName)){
						bookEntity.setId(attrValue);
					}	
				}
				List<Element> bookChilds =book.getChildren();
				for (Element child : bookChilds) {
					System.out.println("节点名："+child.getName()+"---节点值:"+child.getValue());
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
					
				System.out.println("===========结束解析第" + (bookList.indexOf(book)+1)
						+ "书=========");
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
