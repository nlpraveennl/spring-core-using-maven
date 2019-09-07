package com.pvn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvn.dao.CircleDao;
import com.pvn.model.Circle;
import com.pvn.service.CircleService;

@Service
public class CircleServiceImpl implements CircleService
{
	@Autowired
	private CircleDao circleDao;
	
	@Override
	public Circle getCircle(int circleId)
	{
		return circleDao.getCircle(circleId);
	}

	@Override
	public List<Circle> getAllCircle()
	{
		return circleDao.getAllCircle();
	}

	@Override
	public void executeJDBCTemplateMethods()
	{
		circleDao.executeJDBCTemplateMethods();
	}

}
