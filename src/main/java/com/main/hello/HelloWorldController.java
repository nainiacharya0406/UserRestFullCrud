package com.main.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	// returning string
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		
		return "hello world";
	}
	
	//creating and returning bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello-world-bean");
	}
	
	//passing parameter.
	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloWorldName(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello-world, %s", name));
	}
	
//	@GetMapping(path = "/hello-world-internationalised")
//	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
//		
//		return messageSource.getMessage("good.morning.message",null, locale);
//	}
}
