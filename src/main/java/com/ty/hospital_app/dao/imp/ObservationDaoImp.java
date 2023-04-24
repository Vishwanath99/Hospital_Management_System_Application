package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ObservationDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Observation;

public class ObservationDaoImp implements ObservationDao
{

	public Observation saveObservation(int eid, Observation observation) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		}
		else {
			return null;
		}
		
	}

	public Observation getObservationById(int oid)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		Observation observation=entityManager.find(Observation.class, oid);
		
		return null;
	}

	public boolean deleteObservationById(int oid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation=entityManager.find(Observation.class, oid);
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Observation upadteObservationId(int oid, Observation observation) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation1=entityManager.find(Observation.class, oid);
		if(observation1!=null) {	
		observation1.setDoctor_dname(observation1.getDoctor_dname());
		observation1.setReason_observation(observation1.getReason_observation());
		entityTransaction.begin();
		entityManager.remove(observation1);
		entityTransaction.commit();
		return observation;
		}
		else {
			return null;
		}
		
	}

	public List<Observation> getAllobservation() 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Observation");
		List<Observation> observations =query.getResultList();
		
		return observations;
	}

	public List<Observation> getObservationByDoctorName(String doctor_name) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Observation s where doctor_name=?1 ");
		query.setParameter(1, doctor_name);
		List<Observation> observations =query.getResultList();
		
		return observations;
		
	}

}
