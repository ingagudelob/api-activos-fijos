package com.serinz.activos.app.services.employes;

import java.util.List;

import com.serinz.activos.app.entitys.Employe;

public interface IEmployeService {

	public List<Employe> getEmploye();
	public String AddEmploye(Employe employe);
	public Employe updateEmploye(String codEmploye);
	public String deleteEmploye(String codEmploye);
}
