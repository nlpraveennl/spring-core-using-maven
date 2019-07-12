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
		shape.getTriangle().fill();
		System.out.println("==============================");
		shape.getCircle().draw();
		shape.getCircle().fill();
		
		shape.getCircle().setCenter(context.getBean("pointA", Point.class));
		shape.getCircle().draw();
		shape.getCircle().fill();
		
		shape.getCircle().setFullName("Praveen", "Lalasangi");
		
		context.registerShutdownHook();
		context.close();
	}
}
