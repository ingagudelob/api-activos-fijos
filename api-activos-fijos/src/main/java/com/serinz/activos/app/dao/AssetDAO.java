package com.serinz.activos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serinz.activos.app.entitys.Asset;

public interface AssetDAO extends JpaRepository<Asset, Long> {

}
