package com.serinz.activos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serinz.activos.app.entitys.Employe;

public interface EmployeDAO extends JpaRepository<Employe, Integer> {

}
