package com.serinz.activos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serinz.activos.app.entitys.Asset;

/**
 * Interface para el repositorio AssetDAO - Tiene acceso a al base de datos
 * @author ing_j
 *
 */
public interface AssetDAO extends JpaRepository<Asset, Long> {


}

