package com.zycus.test;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestShopping {
	
	@Test
	public void addProduct(){
	
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
	}

}
