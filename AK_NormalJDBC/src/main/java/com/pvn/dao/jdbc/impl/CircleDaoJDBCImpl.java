package com.pvn.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pvn.dao.CircleDao;
import com.pvn.model.Circle;

public class CircleDaoJDBCImpl implements CircleDao
{

	@Override
	public Circle getCircle(int circleId)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");
					PreparedStatement pstmt = con.prepareStatement("select * from circle where id= ?");)
			{
				pstmt.setInt(1, circleId);
				ResultSet rs = pstmt.executeQuery();
				Circle circle = null;
				if (rs.next())
				{
					circle = new Circle(circleId, rs.getString("name"));
				}
				return circle;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
