package com.pvn;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.model.Circle;
import com.pvn.service.CircleService;

public class JdbcDemo
{

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		CircleService service = (CircleService) context.getBean("circleServiceImpl");
		Circle circle = service.getCircle(1);
		System.out.println(circle.getName());
		context.close();
	}
}
