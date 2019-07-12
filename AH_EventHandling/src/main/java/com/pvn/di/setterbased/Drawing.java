package com.pvn.di.setterbased;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing
{
	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Shape shape = (Shape) context.getBean("triangle");
		shape.draw();
		shape.fill();
		System.out.println("-----------------");
		Shape shape2 = (Shape) context.getBean("circle");
		shape2.draw();
		shape2.fill();
		
		context.registerShutdownHook();
	}
}
