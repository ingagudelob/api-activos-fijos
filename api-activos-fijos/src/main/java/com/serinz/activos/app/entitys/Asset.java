package com.serinz.activos.app.entitys;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="assets")
public class Asset {
	
	@Id
	@Column(name="asset_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long assetNumber;
	
	@NotBlank(message = "Name cannot be empty.")  
	private String name;
	
    @Size(min = 10, max = 100, message = "Description must be between 10 and 100 characters long")
    @Column(nullable = false)
	private String description;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
	private String serial;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    
    @Column(nullable = false)
    private String dependency;
    
    public String getDependency() {
		return dependency;
	}
	public void setDependency(String dependency) {
		this.dependency = dependency;
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
