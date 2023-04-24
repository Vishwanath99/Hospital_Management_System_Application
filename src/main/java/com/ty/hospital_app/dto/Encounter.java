package com.ty.hospital_app.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
 
@Entity  
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String reason;
	private Date dateofjoin;
	private String dateOfdischarge;
	@OneToMany(mappedBy = "encounters")
	private List<Observation> observations;
	@ManyToOne
	@JoinColumn
	private Person persons;
	@ManyToOne
	@JoinColumn
	private Branch branchs;
	@OneToMany(mappedBy = "encounters")
	private List<MedOrder> medOrders;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public String getDateOfdischarge() {
		return dateOfdischarge;
	}
	public void setDateOfdischarge(String dateOfdischarge) {
		this.dateOfdischarge = dateOfdischarge;
	}
	public List<Observation> getObservations() {
		return observations;
	}
	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}
	public Person getPerson() {
		return persons;
	}
	public void setPerson(Person persons) {
		this.persons = persons;
	}
	public Branch getBranchs() {
		return branchs;
	}
	public void setBranchs(Branch branchs) {
		this.branchs = branchs;
	}
	public List<MedOrder> getMedOrders() {
		return medOrders;
	}
	public void setMedorders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}
	
	
	
}
