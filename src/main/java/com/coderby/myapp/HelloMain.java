package com.coderby.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		HelloController controller = context.getBean(HelloController.class);
		System.out.println("----------");
		controller.hello("홍길동");
		System.out.println("----------");
		context.close();
	}

}
