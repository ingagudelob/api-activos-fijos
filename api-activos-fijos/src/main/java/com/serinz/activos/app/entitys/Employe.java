package com.serinz.activos.app.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "employes")
public class Employe {
	
	@Id
	@Column(name="cod_employe")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long codEmploye;
	
	@Column(name="name_employe", nullable = false)
	public String nameEmploye;
	
}
