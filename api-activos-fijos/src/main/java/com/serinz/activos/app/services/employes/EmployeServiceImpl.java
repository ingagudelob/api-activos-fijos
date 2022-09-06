package com.serinz.activos.app.services.employes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serinz.activos.app.dao.EmployeDAO;
import com.serinz.activos.app.entitys.Employe;

@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	private EmployeDAO service;

	@Override
	public List<Employe> getEmploye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AddEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe updateEmploye(String codEmpoye) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmploye(String codEmpoye) {
		// TODO Auto-generated method stub
		return null;
	}

}
