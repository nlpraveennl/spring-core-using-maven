package com.pvn.di.setterbased;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Point implements BeanNameAware, InitializingBean, DisposableBean
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
	
	
	public void initializePoint()
	{
		System.out.println("init-method of "+this.getBeanName());
	}
	
	public void destroyPoint()
	{
		System.out.println("@PreDestroy of "+this.getBeanName());
	}
	
	@PostConstruct
	public void postConstruct()
	{
		System.out.println("@PostConstruct of "+this.getBeanName());
	}
	
	@PreDestroy
	public void preDestroy()
	{
		System.out.println("destroy-method of "+this.getBeanName());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("afterPropertiesSet method of InitializingBean interface: "+this.getBeanName());
	}
	
	@Override
	public void destroy() throws Exception
	{
		System.out.println("destroy method of DisposableBean interface: "+this.getBeanName());
	}
}
