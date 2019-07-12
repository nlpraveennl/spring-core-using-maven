package com.pvn.di.setterbased;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.service.ShapeService;

public class AopMain
{
	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		ShapeService shape = context.getBean("shapeService",ShapeService.class);
		shape.getTriangle().draw();
		System.out.println("-------------------");
		shape.getTriangle().fill();
		System.out.println("==============================");
		shape.getCircle().draw();
		System.out.println("-------------------");
		shape.getCircle().fill();
		shape.getCircle().setFullName("Praveen", "Praveen");
		
		context.registerShutdownHook();
		context.close();
	}
}
