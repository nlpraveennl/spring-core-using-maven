package com.pvn.di.setterbased;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.pvn.event.ColourFillingEvent;
import com.pvn.event.DrawingEvent;

@Component
public class Triangle implements Shape, ApplicationContextAware
{

	@Autowired
	private Point				pointA;
	@Resource
	private Point				pointB;
	@Autowired
	private Point				pointC;

	private ApplicationContext	context;
	private String				msg;

	public Point getPointA()
	{
		return pointA;
	}
	public void setPointA(Point pointA)
	{
		this.pointA = pointA;
	}
	public Point getPointB()
	{
		return pointB;
	}
	public void setPointB(Point pointB)
	{
		this.pointB = pointB;
	}
	public Point getPointC()
	{
		return pointC;
	}
	public void setPointC(Point pointC)
	{
		this.pointC = pointC;
	}

	@Override
	public void draw()
	{
		ApplicationEvent event = new DrawingEvent(this);
		this.context.publishEvent(event);
		
		System.out.println("Drawn Triangle");
	}

	@Override
	public void fill()
	{
		ApplicationEvent event = new ColourFillingEvent(this);
		this.context.publishEvent(event);
		
		System.out.println("Colour filled for triangle");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context = context;
		this.msg = context.getMessage("triangle", new Object[] { pointA.getPointX(), pointA.getPointY(), pointA.getPointX(), pointB.getPointY(), pointB.getPointX(), pointB.getPointY() }, "drawingMessages", null);
	}
	
	@Override
	public String getMessage()
	{
		return this.msg;
	}

}
