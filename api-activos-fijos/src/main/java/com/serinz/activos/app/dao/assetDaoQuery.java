package com.serinz.activos.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serinz.activos.app.entitys.Asset;

/**
 * Interface DAO para las peticiones de activos con Querys
 * @author ing Jaime Agudelo
 *
 */
public interface assetDaoQuery extends JpaRepository<Asset, String> {
	
	/**
	 * Query - sentencia para la consulta de activos por serial
	 * @param serial Recibe el serial como parametro
	 * @return devuelve un objeto con la informacion consultada
	 */
	@Query(
			value = "SELECT * FROM assets WHERE assets.serial like %:serial%",
			nativeQuery = true
			)
	Asset searchBySerial(@Param("serial") String serial);
	
	
	/**
	 * Query - sentencia para la consulta de activos por fecha de compra
	 * @param purchase_date Recibe la fecha de compra como parametro
	 * @return devuelve una lista con los activos con la misma fecha de compra
	 */
	@Query(
			value = "SELECT * FROM assets WHERE assets.purchase_date like %:purchase_date%",
			nativeQuery = true
			)
	List<Asset> searchByDate(@Param("purchase_date") String purchase_date);
	
	
	/**
	 * Query - sentencia para la consulta de activos por tipo
	 * @param type Recibe el tipo como parametro
	 * @return devuelve una lista con los activos con el mismo tipo
	 */
	@Query(
			value = "SELECT * FROM assets WHERE assets.type like %:type%",
			nativeQuery = true
			)
	List<Asset> searchByType(@Param("type") String type);
	
}
