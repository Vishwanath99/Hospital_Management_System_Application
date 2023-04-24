package com.ty.hospital_app.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.HospitalDao;
import com.ty.hospital_app.dto.Hospital;

public class HospitalDaoImp implements HospitalDao
{

	public Hospital savehospital(Hospital hospital) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return hospital; 
	}

	public Hospital getHospitalById(int hospital_id) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Hospital hospital=entityManager.find(Hospital.class, hospital_id);
		
		return hospital;
	}

	public boolean deleteHospitalById(int hospital_id)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, hospital_id);
		
		if(hospital!=null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}	
	}

	public Hospital updateHospital(int hospital_id, Hospital hospital)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital1=entityManager.find(Hospital.class, hospital_id);
	
		if (hospital1 != null) 
		{
			hospital1.setHospital_name(hospital.getHospital_name());
			hospital1.setHospital_website(hospital.getHospital_website());
			entityTransaction.begin();  
			entityManager.merge(hospital1);
			entityTransaction.commit();
			return hospital1;  
		}  
		else {
			return null;
		}
	}
}
