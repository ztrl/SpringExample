package com.coderby.myapp.aop;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() executed");
		return "Hello~~~ " + name;
	}

	@Override
	public String sayGoodBye(String name) {
		System.out.println("HelloService.sayGoodBye() executed");
		if (Math.random() < 0.5) {
			throw new RuntimeException("GoodBye Exeception occur");
		}
		return "GoodBye~~~ " + name;
	}

}
