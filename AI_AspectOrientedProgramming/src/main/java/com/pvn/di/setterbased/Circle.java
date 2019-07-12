package com.pvn.di.setterbased;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationContextAware, BeanNameAware
{

	@Autowired
	@Qualifier("centerQualifier")
	private Point				center;
	private String				msg;
	private String				beanName;

	private ApplicationContext	context;

	public Point getCenter()
	{
		return center;
	}

	public void setCenter(Point center)
	{
		this.center = center;
	}

	@Override
	public void draw()
	{
		System.out.println("Drawn circle: " + msg);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context = context;
		this.msg = this.context.getMessage("circle", new Object[] { center.getPointX(), center.getPointY() }, "drawingMessages", null);
	}

	@Override
	public void fill()
	{
		System.out.println("Colour filled for circle: " + msg);
	}

	@Override
	public String getMessage()
	{
		return this.msg;
	}

	@Override
	public void setBeanName(String name)
	{
		this.beanName = name;
	}
	
	@Override
	public String getBeanName()
	{
		return this.beanName;
	}
	
	public String setFullName(String fn,String ln) 
	{
		if(fn.equalsIgnoreCase(ln))
			throw new RuntimeException();
		System.out.println("setFullName executed");
		return fn+" "+ln;
	}
}
