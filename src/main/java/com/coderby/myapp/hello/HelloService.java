package com.coderby.myapp.hello;

public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		String message = "Hello~~~" + name;
		return message;
	}

	@Override
	public String sayGoodBye(String name) {
		String message = "GoodBye~~~" + name;
		return message;
	}

}
