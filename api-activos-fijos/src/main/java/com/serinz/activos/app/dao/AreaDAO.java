package com.serinz.activos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serinz.activos.app.entitys.Area;

/**
 * Inteface para el Repositorio AreaDAO
 * @author ing_j
 *
 */
public interface AreaDAO extends JpaRepository<Area, Integer> {

}
