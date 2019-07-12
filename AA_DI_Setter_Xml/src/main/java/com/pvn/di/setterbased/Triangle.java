package com.pvn.di.setterbased;

public class Triangle 
{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw()
	{
		System.out.println("Point A = ("+getPointA().getPointX()+","+getPointA().getPointY()+")");
		System.out.println("Point B = ("+getPointB().getPointX()+","+getPointB().getPointY()+")");
		System.out.println("Point C = ("+getPointC().getPointX()+","+getPointC().getPointY()+")");
	}
}
