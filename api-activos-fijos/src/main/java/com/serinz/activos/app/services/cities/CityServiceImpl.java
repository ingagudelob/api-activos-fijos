package com.serinz.activos.app.services.cities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serinz.activos.app.dao.CityDAO;
import com.serinz.activos.app.entitys.City;

@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private CityDAO cityDAO;

	@Override
	public List<City> getCities() {
		// TODO Auto-generated method stub
		return cityDAO.findAll();
	}

	@Override
	public City addCity(City city) {
		
		return cityDAO.save(city);
	}

	@Override
	public City updateCity(City city) {
		return cityDAO.save(city);
	}


}
