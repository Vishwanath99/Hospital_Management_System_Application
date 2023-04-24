package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;

public class EncounterDaoImp implements EncounterDao
{

	public Encounter saveEncounter(int branch_id, Encounter encounter) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, branch_id);
		if (branch!=null) {
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		}
		else {
			return null;	
		}
	}

	public Encounter getEncounterById(int eid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		
		return null;
	}

	public boolean deleteEncounterById(int eid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Encounter updateEncounetrId(int eid, Encounter encounter) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter1=entityManager.find(Encounter.class, eid);
		if (encounter1!=null) {
			encounter1.setReason(encounter1.getReason());
			encounter1.setDateofjoin(encounter1.getDateofjoin());
			encounter1.setDateOfdischarge(encounter1.getDateOfdischarge());
			entityTransaction.begin();
			entityManager.remove(encounter1);
			entityTransaction.commit();
			return encounter;
		}
		else {
			return null;
		}
		
	}

	public List<Encounter> getAllEncounter() 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Encounter s");
		List<Encounter> encounters=query.getResultList();
		
		return encounters;
	}

}
