package com.pvn.di.setterbased;

import java.util.Collection;

public class Triangle
{

	private Collection<Point> points;

	public Collection<Point> getPoints()
	{
		return points;
	}

	public void setPoints(Collection<Point> points)
	{
		this.points = points;
	}

	public void draw()
	{
		this.points.forEach(point -> 
		{
			System.out.println(point.getBeanName()+" = (" + point.getPointX() + "," + point.getPointY() + ")");
		});
	}
}
