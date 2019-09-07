package com.pvn.service;

import java.util.List;

import com.pvn.model.City;
import com.pvn.model.Country;
import com.pvn.model.Language;

public interface CountryService
{
	public List<Country> getAllCountries();
	public List<City> getAllCities();
	public List<Language> getAllLanguages();

}
