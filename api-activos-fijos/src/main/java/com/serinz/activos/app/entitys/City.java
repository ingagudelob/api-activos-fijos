package com.serinz.activos.app.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase del tipo Entity como Modelo Ciudades
 * @author ing_j
 *
 */

@Entity
@Table(name = "cities")
public class City {

	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="name_city", nullable = false, unique = true)
	private String nameCity;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private Set<Area> areas = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
		for(Area area : areas) {
			area.setCity(this);
		}
	}

	

}
