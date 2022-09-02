package com.serinz.activos.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serinz.activos.app.entitys.Asset;


public interface assetDaoQuery extends JpaRepository<Asset, String> {
	
	@Query(
			value = "SELECT * FROM assets WHERE assets.serial like %:serial%",
			nativeQuery = true
			)
	Asset searchBySerial(@Param("serial") String serial);
	
	@Query(
			value = "SELECT * FROM assets WHERE assets.purchase_date like %:purchase_date%",
			nativeQuery = true
			)
	List<Asset> searchByDate(@Param("purchase_date") String purchase_date);
	
	@Query(
			value = "SELECT * FROM assets WHERE assets.type like %:type%",
			nativeQuery = true
			)
	List<Asset> searchByType(@Param("type") String type);
	
}
