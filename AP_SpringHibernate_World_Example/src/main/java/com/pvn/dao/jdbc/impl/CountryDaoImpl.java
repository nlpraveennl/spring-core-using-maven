package com.pvn.dao.jdbc.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pvn.dao.CountryDao;
import com.pvn.model.City;
import com.pvn.model.Country;
import com.pvn.model.Language;

@Component
public class CountryDaoImpl implements CountryDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final int MAX = 1000;

	@Override
	public List<Country> getAllCountries()
	{
		Session session = sessionFactory.openSession();
		return (List<Country>) session.createQuery("FROM Country").setMaxResults(MAX).list();
	}

	@Override
	public List<City> getAllCities()
	{
		Session session = sessionFactory.openSession();
		return (List<City>) session.createQuery("FROM City").setMaxResults(MAX).list();
	}

	@Override
	public List<Language> getAllLanguages()
	{
		Session session = sessionFactory.openSession();
		return (List<Language>) session.createQuery("FROM Language").setMaxResults(MAX).list();
	}

}
