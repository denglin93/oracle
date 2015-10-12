package com.oracle;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestFreeMark {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("templates"));
		Map root = new HashMap();
		root.put("username", "����");
		root.put("radom", new Random().nextInt(7));
	
		List list=new ArrayList();
		list.add(new Address("�й�","����"));

		list.add(new Address("�й�","�人"));

		list.add(new Address("����","ŦԼ"));
		root.put("lst", list);

		
		
		
		
		
		
		
		
		Template t1 = cfg.getTemplate("a.ftl");
		Writer out = new OutputStreamWriter(System.out);
		t1.process(root, out);
		out.flush();
		out.close();

	}

}
