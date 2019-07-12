package com.pvn.di.setterbased;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationContextAware
{
	@Autowired
	@Qualifier("centerQualifier")
	private Point center;
	
	private ApplicationContext context;

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
		String msg = context.getMessage("circle", new Object[]{center.getPointX(),center.getPointY()}, "drawingMessages", null);
		System.out.println(msg);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context = context;
	}
}
