package com.pvn.di.setterbased;

import org.springframework.beans.factory.BeanNameAware;

public class Point implements BeanNameAware
{

	private int		pointX;
	private int		pointY;
	private String	name;

	public int getPointX()
	{
		return pointX;
	}
	public void setPointX(int pointX)
	{
		this.pointX = pointX;
	}
	public int getPointY()
	{
		return pointY;
	}
	public void setPointY(int pointY)
	{
		this.pointY = pointY;
	}
	public String getBeanName()
	{
		return this.name;
	}
	@Override
	public void setBeanName(String name)
	{
		this.name = name;
	}
}
