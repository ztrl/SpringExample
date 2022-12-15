package com.coderby.myapp.configurable;

public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() 실행");
		return "Hello~ " + name;
	}

}
