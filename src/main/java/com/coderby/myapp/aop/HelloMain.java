package com.coderby.myapp.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config-aop.xml");
		HelloController controller = context.getBean(HelloController.class);
		System.out.println("====================");
		controller.hello("SMY");
		System.out.println();
		controller.goodbye("my");
		System.out.println("====================");
		context.close();
	}

}
