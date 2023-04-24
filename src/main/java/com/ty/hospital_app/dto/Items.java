package com.ty.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity  
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iid;
	private String name;
	private double cost;
	private int quantity;
	@ManyToOne
	@JoinColumn
	private MedOrder medOrders;
	
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MedOrder getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(MedOrder medOrders) {
		this.medOrders = medOrders;
	}
	
	
	
}
