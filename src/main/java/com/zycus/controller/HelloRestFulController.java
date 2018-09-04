package com.zycus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestFulController {

	@RequestMapping(value = "/helloAgain",method = RequestMethod.GET,produces="text/plain")
	public String hello(){
		return "Welcome To Spring MVC"; //model
	}
}
