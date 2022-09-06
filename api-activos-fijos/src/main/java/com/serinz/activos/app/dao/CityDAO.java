package com.serinz.activos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serinz.activos.app.entitys.City;

/**
 * Interface para el repositorio CityDAO - Tiene acceso a al base de datos
 * @author ing_j
 *
 */
public interface CityDAO extends JpaRepository<City, Integer> {

}
