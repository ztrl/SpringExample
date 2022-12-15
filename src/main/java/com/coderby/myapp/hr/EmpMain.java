package com.coderby.myapp.hr;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		System.out.println("----------");
		EmpController controller = context.getBean(EmpController.class);
		controller.printInfo();
		System.out.println("----------");
		context.close();
	}
}
