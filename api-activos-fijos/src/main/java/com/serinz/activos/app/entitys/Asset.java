package com.serinz.activos.app.entitys;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Clase del tipo Entity pra el Modelo Asset
 * @author ing_j
 *
 */
@Data
@Entity
@Table(name="assets")
public class Asset {
	
	@Id
	@Column(name="asset_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long assetNumber;
	
	@NotBlank(message = "Nombre no puede ser NULO o VACIO")  
	private String name;
	
    @Size(min = 10, max = 100, message = "Description must be between 10 and 100 characters long")
    @Column(nullable = false)
	private String description;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false, unique = true)
	private String serial;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    
    /**
     * Realacion OneToOne para 
     */
    @JoinColumn(name = "city_id", nullable = false)
    @OneToOne
    private City city;
    
    @JoinColumn(name = "employe_id", nullable = false)
    @OneToOne
    private Employe employe;
    
    public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	@Column(name= "purchase_price", nullable = false)
	private double purchasePrice;
	
	@Column(name= "purchase_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	
	public Long getAssetNumber() {
		return assetNumber;
	}
	public void setAssetNumber(Long assetNumber) {
		this.assetNumber = assetNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	

}
