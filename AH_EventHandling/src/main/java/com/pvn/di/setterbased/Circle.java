package com.pvn.di.setterbased;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.pvn.event.ColourFillingEvent;
import com.pvn.event.DrawingEvent;

@Component
public class Circle implements Shape, ApplicationContextAware
{

	@Autowired
	@Qualifier("centerQualifier")
	private Point	center;
	private String	msg;

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
		ApplicationEvent event = new DrawingEvent(this);
		this.context.publishEvent(event);

		System.out.println("Drawn circle");
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context = context;
		this.msg = context.getMessage("circle", new Object[] { center.getPointX(), center.getPointY() }, "drawingMessages", null);
	}

	@Override
	public void fill()
	{
		ApplicationEvent event = new ColourFillingEvent(this);
		this.context.publishEvent(event);

		System.out.println("Colour filled for circle");
	}
	
	@Override
	public String getMessage()
	{
		return this.msg;
	}
}
