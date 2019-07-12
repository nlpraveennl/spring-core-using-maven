package com.pvn.di.constructorbased;

public class Triangle 
{
	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Triangle(Point pointA, Point pointB, Point pointC)
	{
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	
	public Point getPointA() {
		return pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	
	public void draw()
	{
		System.out.println("Point A = ("+getPointA().getPointX()+","+getPointA().getPointY()+")");
		System.out.println("Point B = ("+getPointB().getPointX()+","+getPointB().getPointY()+")");
		System.out.println("Point C = ("+getPointC().getPointX()+","+getPointC().getPointY()+")");
	}
}
