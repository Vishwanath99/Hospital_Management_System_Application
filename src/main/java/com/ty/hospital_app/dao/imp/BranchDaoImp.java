package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public class BranchDaoImp implements BranchDao
{

	public Branch saveBranch(int hospital_id, Branch branch) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, hospital_id);
		
		if (hospital != null) 
		{
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		}  
		else {
			return null;
		}
	}

	public Branch getBranchById(int branch_id)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Branch branch=entityManager.find(Branch.class, branch_id);
		
		return  branch;
	}

	public boolean deleteBranchById(int branch_id) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, branch_id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}	
		
	}  

	public Branch updateBranchId(int branch_id, Branch branch) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch1=entityManager.find(Branch.class, branch_id);
		
		if (branch1 != null) 
		{
			branch1.setBranch_name(branch1.getBranch_name());
			branch1.setPhno(branch1.getPhno());
			branch1.setEmail(branch1.getEmail());
			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
			return branch;  
		}  
		else {
			return null;
		}
	}

	public List<Branch> getAllBranch()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Branch s");
		List<Branch> branch=query.getResultList();
		
		return branch;
	}

}
