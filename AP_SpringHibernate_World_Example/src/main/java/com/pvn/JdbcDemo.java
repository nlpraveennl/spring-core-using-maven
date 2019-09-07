package com.pvn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.model.City;
import com.pvn.model.Country;
import com.pvn.model.Language;
import com.pvn.service.CountryService;

public class JdbcDemo
{

	private static final Logger OUT = LoggerFactory.getLogger(JdbcDemo.class);

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		CountryService countryService = (CountryService) context.getBean("countryServiceImpl");

		List<Country> countries = countryService.getAllCountries();
		countries.forEach(country -> 
		{
			OUT.info("{}", country);
		});
		
		OUT.info("***************************************************");
		
		List<City> cities = countryService.getAllCities();
		cities.forEach(city -> 
		{
			OUT.info("{}", city);
		});
		
		List<Language> langs = countryService.getAllLanguages();
		langs.forEach(lang -> 
		{
			OUT.info("{}", lang);
		});
		
		context.close();
	}
}
