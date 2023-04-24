package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;

public class AddressDaoImp implements AddressDao
{

	public Address saveAddress(int branch_id, Address address) 
	{

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, branch_id);
		if (branch!=null) 
		{
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		}
		else {
			return null;	
		}
	}

	public Address getAddressById(int aid) 
	{

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Address address=entityManager.find(Address.class, aid);
		
		return null;
	}

	public boolean deleteAddresById(int aid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address=entityManager.find(Address.class, aid);
		if(address!=null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Address updateAdressById(int aid, Address address)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address1=entityManager.find(Address.class, aid);
		if (address1 != null){
			address1.setStreet(address1.getStreet());
			address1.setState(address1.getState());
			address1.setPincode(address1.getPincode());
			entityTransaction.begin();
			entityManager.remove(address1);
			entityTransaction.commit();
			return address;
		}
		else {
			return null;
		}
	}

	public List<Address> getAddressAll() 
	{

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Address s");
		List<Address> addresses=query.getResultList();
		
		return addresses;
	}
}
