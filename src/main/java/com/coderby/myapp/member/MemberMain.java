package com.coderby.myapp.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		
		System.out.println("----------");
		
		MemberController controller = context.getBean(MemberController.class);
		controller.printInfo();
		
		System.out.println("----------");
		
		context.close();
	}

}
