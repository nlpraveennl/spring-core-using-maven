package com.pvn.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "country")
public class Country
{

	@Id
	@Column(name = "Code")
	private String			code;

	@Column(name = "Code2")
	private String			code2;

	@Column(name = "Name")
	private String			name;

	@Column(name = "Continent")
	private String			continent;

	@Column(name = "Region")
	private String			region;

	@Column(name = "SurfaceArea")
	private Double			surfaceArea;

	@Column(name = "IndepYear")
	private Integer			indepYear;

	@Column(name = "Population")
	private Integer			population;

	@Column(name = "LifeExpectancy")
	private Double			lifeExpectancy;

	@Column(name = "GNP")
	private Double			gnp;

	@Column(name = "GNPOld")
	private Double			gnpOld;

	@Column(name = "LocalName")
	private String			localName;

	@Column(name = "GovernmentForm")
	private String			governmentForm;

	@Column(name = "HeadOfState")
	private String			headOfState;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "countryCode")
	@Lazy
	private List<City>		cityList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "countryCode")
	@Lazy
	private List<Language>	languageList;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode2()
	{
		return code2;
	}

	public void setCode2(String code2)
	{
		this.code2 = code2;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContinent()
	{
		return continent;
	}

	public void setContinent(String continent)
	{
		this.continent = continent;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public Double getSurfaceArea()
	{
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea)
	{
		this.surfaceArea = surfaceArea;
	}

	public Integer getIndepYear()
	{
		return indepYear;
	}

	public void setIndepYear(Integer indepYear)
	{
		this.indepYear = indepYear;
	}

	public Integer getPopulation()
	{
		return population;
	}

	public void setPopulation(Integer population)
	{
		this.population = population;
	}

	public Double getLifeExpectancy()
	{
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Double lifeExpectancy)
	{
		this.lifeExpectancy = lifeExpectancy;
	}

	public Double getGnp()
	{
		return gnp;
	}

	public void setGnp(Double gnp)
	{
		this.gnp = gnp;
	}

	public Double getGnpOld()
	{
		return gnpOld;
	}

	public void setGnpOld(Double gnpOld)
	{
		this.gnpOld = gnpOld;
	}

	public String getLocalName()
	{
		return localName;
	}

	public void setLocalName(String localName)
	{
		this.localName = localName;
	}

	public String getGovernmentForm()
	{
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm)
	{
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState()
	{
		return headOfState;
	}

	public void setHeadOfState(String headOfState)
	{
		this.headOfState = headOfState;
	}

	public Integer getCapital()
	{
		return capital;
	}

	public void setCapital(Integer capital)
	{
		this.capital = capital;
	}

	public List<City> getCityList()
	{
		return cityList;
	}

	public void setCityList(List<City> cityList)
	{
		this.cityList = cityList;
	}

	public List<Language> getLanguageList()
	{
		return languageList;
	}

	public void setLanguageList(List<Language> languageList)
	{
		this.languageList = languageList;
	}

	@Column(name = "Capital")
	private Integer capital;

	@Override
	public String toString()
	{
		StringBuilder cities = new StringBuilder();
		cityList.forEach(city -> cities.append(city.getName()).append(","));
		
		StringBuilder langs = new StringBuilder();
		languageList.forEach(lang -> cities.append(lang.getLanguage()).append(","));
		
//		return String.format("Country [code=%-5s, name=%-40s, continent=%-20s, population=%15s, lifeExpectancy=%5s, cities=%s]",
//				code, name, continent, population, lifeExpectancy, cities.toString());
		
		return String.format("Country [code=%-5s, name=%-40s, lanuages=%-90s cities=%s]",
				code, name, continent, population, lifeExpectancy, langs, cities);
		
	}

}
