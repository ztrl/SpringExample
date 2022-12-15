package com.coderby.myapp.configurable;

public class HomeController {
	IHelloService helloService;
	
	public HomeController(IHelloService helloService) {
		this.helloService = helloService;
	}
}
