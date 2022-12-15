package com.coderby.myapp.configurable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@Configurable
@ComponentScan(basePackages= {"com.myspring.myapp"})
@ImportResource(value= {"classpath:application-config.xml"})
public class AppConfig {
//	@Bean
//	IHelloService helloService() {
//		//method name will be bean name
//		return new HelloService();
//	}
	
	@Autowired
	IHelloService helloService;
	
	@Bean
	HelloController helloController() {
		HelloController helloController = new HelloController(helloService);
		return helloController;
	}
}