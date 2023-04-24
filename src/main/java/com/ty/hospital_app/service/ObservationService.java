package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ObservationDaoImp;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.dto.Observation;

public class ObservationService {


	public void saveObservation(int eid, Observation observation) {
		ObservationDaoImp daoImp=new ObservationDaoImp();
		Observation observation2=daoImp.saveObservation(eid, observation);
		if( observation2 != null) {
			System.out.println("Observation saved");
		}
		else {
			System.out.println("Observation not saved");
		}
	}

	public Observation getObservationById(int oid) {
		ObservationDaoImp daoImp=new ObservationDaoImp();
		Observation observation2=daoImp.getObservationById(oid);
		if (observation2!= null) {
			return observation2;	
		}
		else {
			return null;
		}
	}

	public void deleteObservationById(int oid) {
		ObservationDaoImp daoImp=new ObservationDaoImp();
		boolean flag=daoImp.deleteObservationById(oid);
		if(flag) {
			System.out.println("Observation deleted");
		}
		else {
			System.out.println("Observation not deleted");
		}
	}

	public Observation upadteObservationId(int oid, Observation observation) {
		ObservationDaoImp daoImp=new ObservationDaoImp();
		Observation observation2=daoImp.upadteObservationId(oid, observation);
		if (observation2 != null) {
			return observation2;
		}
		else {
			return null;
		}
	}

	public List<Observation> getAllobservation()
	{
		ObservationDaoImp daoImp=new ObservationDaoImp();
		List<Observation> observations =daoImp.getAllobservation();
		if(observations != null)
		{
			return observations;
		}
		else {
			return null;
		}
	}

	public List<Observation> getObservationByDoctorName(String doctor_name) {
		ObservationDaoImp daoImp=new ObservationDaoImp();
		List<Observation> observations =daoImp.getObservationByDoctorName(doctor_name);
		if(observations != null)
		{
			return observations;
		}
		else {
			return null;
		}

	}

}
