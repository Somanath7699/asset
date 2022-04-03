package com.sprint1.assets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;



@Entity
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
	private int shipment_id;
	@Column
	@NotEmpty(message = "should not be empty")
	private String shipment_company_name;
	@Column
	@NotEmpty(message = "should not be empty")
	private String shipment_state;
	@Column
	@NotEmpty(message = "should not be empty")
	private String shipment_country;
	@Column
	@NotEmpty(message = "should not be empty")
	private String subLocation;
	@OneToOne
	@JoinColumn(name = "asset_id",referencedColumnName = "asset_id")
	private Asset asset;
	
	public Shipment() {
	
	}
	public Shipment(int shipment_id, @NotEmpty(message = "should not be empty") String shipment_company_name,
			@NotEmpty(message = "should not be empty") String shipment_state,
			@NotEmpty(message = "should not be empty") String shipment_country,
			@NotEmpty(message = "should not be empty") String subLocation) {
	
		this.shipment_id = shipment_id;
		this.shipment_company_name = shipment_company_name;
		this.shipment_state = shipment_state;
		this.shipment_country = shipment_country;
		this.subLocation = subLocation;
	}
	
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public String getShipment_company_name() {
		return shipment_company_name;
	}
	public void setShipment_company_name(String shipment_company_name) {
		this.shipment_company_name = shipment_company_name;
	}
	
	public int getShipment_id() {
		return shipment_id;
	}
	public void setShipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}
	public String getShipment_state() {
		return shipment_state;
	}
	public void setShipment_state(String shipment_state) {
		this.shipment_state = shipment_state;
	}
	public String getShipment_country() {
		return shipment_country;
	}
	public void setShipment_country(String shipment_country) {
		this.shipment_country = shipment_country;
	}
	public String getSubLocation() {
		return subLocation;
	}
	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}
	@Override
	public String toString() {
		return "Shipment [shipment_id=" + shipment_id + ", shipment_company_name=" + shipment_company_name
				+ ", shipment_state=" + shipment_state + ", shipment_country=" + shipment_country + ", subLocation="
				+ subLocation + "]";
	}
	
	
	
	

}
