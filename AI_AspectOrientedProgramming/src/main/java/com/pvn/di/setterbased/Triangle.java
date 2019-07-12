package com.pvn.di.setterbased;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape, ApplicationContextAware, BeanNameAware
{

	@Autowired
	private Point				pointA;
	@Resource
	private Point				pointB;
	@Autowired
	private Point				pointC;

	private ApplicationContext	context;
	private String				msg;
	private String				beanName;

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
		System.out.println("Drawn Triangle: " + this.msg);
	}

	@Override
	public void fill()
	{
		System.out.println("Colour filled for triangle: " + this.msg);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context = context;
		this.msg = this.context.getMessage("triangle",
				new Object[] { pointA.getPointX(), pointA.getPointY(), pointA.getPointX(), pointB.getPointY(), pointB.getPointX(), pointB.getPointY() }, "drawingMessages", null);
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

}
