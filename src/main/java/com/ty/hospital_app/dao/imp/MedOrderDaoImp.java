package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.MedOrderDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.MedOrder;

public class MedOrderDaoImp implements MedOrderDao
{

	public MedOrder saveMedOrder(int eid, MedOrder medOrder)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return medOrder;
		}
		else {
			return null;
		}
	}

	public MedOrder getMedOrderById(int mid)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		MedOrder medOrder=entityManager.find(MedOrder.class, mid);
		
		return null;
	}

	public boolean deleteMedOrderById(int mid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedOrder medOrder=entityManager.find(MedOrder.class, mid);
		if(medOrder!=null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public MedOrder updateMedOrderId(int mid, MedOrder medOrder) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedOrder medOrder1=entityManager.find(MedOrder.class, mid);
		if (medOrder1 != null) {
			medOrder1.setDname(medOrder1.getDname());
			medOrder1.setOrderDate(medOrder1.getOrderDate());
			medOrder.setTotal(medOrder1.getTotal());
			entityTransaction.begin();
			entityManager.remove(medOrder1);
			entityTransaction.commit();
			return medOrder;
		}
		else {
			return null;
		}
		
	}

	public List<MedOrder> getAllMedorder() 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from MedOrder s ");
		List<MedOrder> medOrders=query.getResultList();
	
		return medOrders;
	}

	public List<MedOrder> getMedOrderByDoctorname(String dname) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from MedOrder s where dname=?1");
		query.setParameter(1, dname);
		List<MedOrder> medOrders=query.getResultList();
		
		return medOrders;
	
	}

}
