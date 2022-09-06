package com.serinz.activos.app.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Clase del tipo Entity como Modelo Areas
 * 
 * @author ing_j
 *
 */

@Entity
@Table(name = "areas")
public class Area {

	@Id
	@Column(name = "cod_area", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codArea;

	@Column(name = "name_area", nullable = false, unique = true)
	private String nameArea;

	// LAZY, traerá un dato cuando lo indiquemos
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private City city;

	public int getCodArea() {
		return codArea;
	}

	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}

	public String getNameArea() {
		return nameArea;
	}

	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
