package com.sprint1.assets.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Asset implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
	private int asset_id;
	
	@Column
	@NotEmpty(message = "should not be empty")
	private String recipient_name;
	
	@NotEmpty(message = "should not be empty")
	private String recipient_location;
	
	@NonNull
	@Size(min = 2, message = " Name should have atleast 2 characters")
	
	@Column
	private String asset_Manufacturer;
	
	@Column
//@NotEmpty(message = "should not be empty")
	private String asset_model;
	
	@Column
//@NotEmpty(message = "should not be empty")
	private String asset_type;

	private Status asset_status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate asset_Movement_date; //Dispatched Date
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expected_delivery_date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate actual_delivered_date;

	public LocalDate getActual_delivered_date() {
		return actual_delivered_date;
	}

	public void setActual_delivered_date(LocalDate actual_delivered_date) {
		this.actual_delivered_date = actual_delivered_date;
	}

	private String asset_source_location;
	private String asset_destination_location;
	@JsonIgnore
	@OneToOne(mappedBy ="asset",cascade = CascadeType.ALL)
	private Shipment shipment;
	

	public Asset() {
		
	}

public Asset(int asset_id, @NotEmpty(message = "should not be empty") String recipient_name,
		@NotEmpty(message = "should not be empty") String recipient_location,
		@Size(min = 2, message = " Name should have atleast 2 characters") String asset_Manufacturer,
		String asset_model, String asset_type, Status asset_status, LocalDate asset_Movement_date,
		LocalDate expected_delivery_date, LocalDate actual_delivered_date, String asset_source_location,
		String asset_destination_location, Shipment shipment) {
	
	this.asset_id = asset_id;
	this.recipient_name = recipient_name;
	this.recipient_location = recipient_location;
	this.asset_Manufacturer = asset_Manufacturer;
	this.asset_model = asset_model;
	this.asset_type = asset_type;
	this.asset_status = asset_status;
	this.asset_Movement_date = asset_Movement_date;
	this.expected_delivery_date = expected_delivery_date;
	this.actual_delivered_date = actual_delivered_date;
	this.asset_source_location = asset_source_location;
	this.asset_destination_location = asset_destination_location;
	this.shipment = shipment;
}
	public int getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}	

	public String getRecipient_name() {
		return recipient_name;
	}

	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}

	public String getRecipient_location() {
		return recipient_location;
	}

	public void setRecipient_location(String recipient_location) {
		this.recipient_location = recipient_location;
	}

	public String getAsset_Manufacturer() {
		return asset_Manufacturer;
	}

	public void setAsset_Manufacturer(String asset_Manufacturer) {
		this.asset_Manufacturer = asset_Manufacturer;
	}

	public String getAsset_model() {
		return asset_model;
	}

	public void setAsset_model(String asset_model) {
		this.asset_model = asset_model;
	}

	public String getAsset_type() {
		return asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}

	public Enum<Status> getAsset_status() {
		return asset_status;
	}

	public void setAsset_status(Status asset_status) {
		this.asset_status = asset_status;
	}

	public LocalDate getAsset_Movement_date() {
		return asset_Movement_date;
	}

	public void setAsset_Movement_date(LocalDate asset_Movement_date) {
		this.asset_Movement_date = asset_Movement_date;
	}

	public LocalDate getExpected_delivery_date() {
		return expected_delivery_date;
	}

	public void setExpected_delivery_date(LocalDate expected_delivery_date) {
		this.expected_delivery_date = expected_delivery_date;
	}

	public String getAsset_source_location() {
		return asset_source_location;
	}

	public void setAsset_source_location(String asset_source_location) {
		this.asset_source_location = asset_source_location;
	}

	public String getAsset_destination_location() {
		return asset_destination_location;
	}

	public void setAsset_destination_location(String asset_destination_location) {
		this.asset_destination_location = asset_destination_location;
	}
	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Override
	public String toString() {
		return "Asset [asset_id=" + asset_id + ", recipient_name=" + recipient_name + ", recipient_location="
				+ recipient_location + ", asset_Manufacturer=" + asset_Manufacturer + ", asset_model=" + asset_model
				+ ", asset_type=" + asset_type + ", asset_status=" + asset_status + ", asset_Movement_date="
				+ asset_Movement_date + ", expected_delivery_date=" + expected_delivery_date
				+ ", actual_delivered_date=" + actual_delivered_date + ", asset_source_location="
				+ asset_source_location + ", asset_destination_location=" + asset_destination_location + ", shipment="
				+ shipment + "]";
	}


}
