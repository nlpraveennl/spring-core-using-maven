package com.pvn.di.setterbased;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape
{

	@Autowired
	private Point	pointA;
	@Resource
	private Point	pointB;
	@Autowired
	private Point	pointC;

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
		System.out.println("Point A = (" + getPointA().getPointX() + "," + getPointA().getPointY() + ")");
		System.out.println("Point B = (" + getPointB().getPointX() + "," + getPointB().getPointY() + ")");
		System.out.println("Point C = (" + getPointC().getPointX() + "," + getPointC().getPointY() + ")");
	}

	
}
