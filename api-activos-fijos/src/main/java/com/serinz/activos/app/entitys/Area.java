package com.serinz.activos.app.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "areas")
public class Area {

	@Id
	@Column(name="cod_area", nullable = false)
	private String codArea;
	
	@Column(name="name_area", nullable = false)
	private String nameArea;
	
	@Column(name="city", nullable = false)
	private String city;

}
