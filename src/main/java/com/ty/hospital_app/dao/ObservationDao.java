package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Observation;

public interface ObservationDao {
	
	public Observation saveObservation(int eid, Observation observation);
	
	public Observation getObservationById(int oid);
	
	public boolean deleteObservationById(int oid);
	
	public Observation upadteObservationId(int oid, Observation observation);
	
	public List<Observation> getAllobservation();
	
	public List<Observation> getObservationByDoctorName(String doctor_name);
}
