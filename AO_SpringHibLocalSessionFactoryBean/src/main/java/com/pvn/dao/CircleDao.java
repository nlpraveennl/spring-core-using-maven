package com.pvn.dao;

import java.util.List;

import com.pvn.model.Circle;

public interface CircleDao
{

	public Circle getCircle(int circleId);
	public List<Circle> getAllCircle();
	public void executeJDBCTemplateMethods();
}
