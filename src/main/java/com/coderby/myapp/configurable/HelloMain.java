package com.coderby.myapp.configurable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("----------");
		HelloController helloController = context.getBean(HelloController.class);
		helloController.hello("홍길동");
		System.out.println("----------");
		
		context.close();
	}

}
