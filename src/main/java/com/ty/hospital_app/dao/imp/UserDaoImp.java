package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.UserDao;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.dto.User;

public class UserDaoImp implements UserDao
{

	public User saveUser(User user)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user; 
	}

	public User getUserById(int uid)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user=entityManager.find(User.class, uid);

		return null;
	}

	public boolean deleteUserById(int uid)
	{

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user=entityManager.find(User.class, uid);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public User upadteUserId(int uid)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user1=entityManager.find(User.class, uid);
		if(user1 != null) {
			user1.setName(user1.getName());
			user1.setEmail(user1.getEmail());
			user1.setPhno(user1.getPhno());
			user1.setPassword(user1.getPassword());
			user1.setRole(user1.getRole());
			entityTransaction.begin();
			entityManager.remove(user1);
			entityTransaction.commit();
			return user1;
		}  
		else {
			return null;
		}	
	}

	public List<User> getAlluser() 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from User s");
		List<User> users  = query.getResultList();
		
		return users;
	}

	public List<User> getAlluserByRole(String role)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from User s where role=?1");
		query.setParameter(1, role);
		List<User> users  = query.getResultList();
		
		return users;
	}

}
