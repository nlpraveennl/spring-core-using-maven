package com.pvn;

import com.pvn.dao.CircleDao;

import com.pvn.factory.MyFactory;
import com.pvn.model.Circle;

public class JdbcDemo
{

	public static void main(String[] args)
	{
		CircleDao circleDao = MyFactory.getCircleImpl();
		Circle circle = circleDao.getCircle(1);
		System.out.println(circle.getName());
	}
}
