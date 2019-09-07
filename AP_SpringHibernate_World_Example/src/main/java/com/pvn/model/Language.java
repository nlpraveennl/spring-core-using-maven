package com.pvn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countrylanguage")
public class Language
{

	@Id
	@Column(name = "CountryCode")
	private String	countryCode;

	@Column(name = "Language")
	private String	language;

	@Column(name = "IsOfficial")
	private String	isOfficial;

	@Column(name = "Percentage")
	private Double	percentage;

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getIsOfficial()
	{
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial)
	{
		this.isOfficial = isOfficial;
	}

	public Double getPercentage()
	{
		return percentage;
	}

	public void setPercentage(Double percentage)
	{
		this.percentage = percentage;
	}

	@Override
	public String toString()
	{
		return String.format("Language [countryCode=%-5s, language=%-20s, percentage=%5s]", countryCode, language, percentage);
	}
	
	

}
