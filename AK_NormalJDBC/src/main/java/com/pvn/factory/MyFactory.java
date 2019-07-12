package com.pvn.factory;

import com.pvn.dao.CircleDao;
import com.pvn.dao.jdbc.impl.CircleDaoJDBCImpl;

public class MyFactory 
{
	private static String implementationType=ImplementationType.JDBC_IMPL;
	
	
	public static CircleDao getCircleImpl()
	{
		switch (implementationType) {
		case ImplementationType.JDBC_IMPL:
			return new CircleDaoJDBCImpl();
		case ImplementationType.Hibernate_IMPL:
			return null;
		default:
			return null;
		}
	}
}
