package com.serinz.activos.app.services.cities;

import java.util.List;


import com.serinz.activos.app.entitys.City;

public interface ICityService {

	public List<City> getCities();
	public City addCity(City city);
	public City updateCity(City city);
	
	
}
