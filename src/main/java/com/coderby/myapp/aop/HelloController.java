package com.coderby.myapp.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	@Autowired
	IHelloService helloService;
	
	public void hello(String name) {
		System.out.println("HelloController.hello() : " + helloService.sayHello(name));
	}
	public void goodbye(String name) {
		System.out.println("HelloController.goodbye() : " + helloService.sayGoodBye(name));
	}
}
