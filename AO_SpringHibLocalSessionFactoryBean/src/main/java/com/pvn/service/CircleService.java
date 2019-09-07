package com.pvn.service;

import java.util.List;

import com.pvn.model.Circle;

public interface CircleService
{

	public Circle getCircle(int circleId);
	public List<Circle> getAllCircle();
	public void executeJDBCTemplateMethods();
}
