package com.coderby.myapp;

public class HelloController {
	IHelloService helloService;
	
	public void setHelloSerivce(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		String result = helloService.sayHello(name);
		System.out.println(result);
	}
}
