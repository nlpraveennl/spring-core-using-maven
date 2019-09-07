package com.pvn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvn.dao.CountryDao;
import com.pvn.model.City;
import com.pvn.model.Country;
import com.pvn.model.Language;
import com.pvn.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService
{

	@Autowired
	private CountryDao countryDao;

	@Override
	public List<Country> getAllCountries()
	{
		return countryDao.getAllCountries();
	}

	@Override
	public List<City> getAllCities()
	{
		return countryDao.getAllCities();
	}

	@Override
	public List<Language> getAllLanguages()
	{
		return countryDao.getAllLanguages();
	}
}
