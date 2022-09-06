package com.serinz.activos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.serinz.activos.app.entitys.Area;

/**
 * Interface DAO para las peticiones de Areas con Querys
 * @author ing Jaime Agudelo
 *
 */
public interface areaDaoQuery extends JpaRepository<Area, String> {
	
	/**
	 * Query - sentencia para la consulta la existencia de un area
	 * @param serial Recibe el area como parametro
	 * @return devuelve un boolean 
	 */
	@Query(
			value = "SELECT * FROM areas WHERE areas.city like %:city%",
			nativeQuery = true
			)
	Area searchByCity(@Param ("city") String city);
	
}
