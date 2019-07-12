package com.pvn.di.setterbased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape
{
	@Autowired
	@Qualifier("centerQualifier")
	private Point center;

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
		System.out.println("Drawing circle with center: ("+ this.center.getPointX()+","+this.getCenter().getPointY()+")");
	}
}
