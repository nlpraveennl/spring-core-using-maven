package com.pvn.dao.jdbc.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pvn.dao.CircleDao;
import com.pvn.model.Circle;

@Component
public class CircleDaoHibernateImpl implements CircleDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Circle getCircle(int circleId)
	{
		Session session = sessionFactory.openSession();
		Circle circle = (Circle) session.get(Circle.class, circleId);
		return circle;
	}
	
	@Override
	public List<Circle> getAllCircle()
	{
		Session session = sessionFactory.openSession();
		List<Circle> list = (List<Circle>)session.createQuery("FROM com.pvn.model.Circle").list();
		return list;
	}

	@Override
	public void executeJDBCTemplateMethods()
	{
		System.out.println("Execute JDBC Temaplate method");
	}
}
