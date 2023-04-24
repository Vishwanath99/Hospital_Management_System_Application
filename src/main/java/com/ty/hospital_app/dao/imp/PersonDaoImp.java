package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.dto.Person;

public class PersonDaoImp implements PersonDao
{

	public Person savePerson(int eid, Person persons)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(persons);
			entityTransaction.commit();
			return persons;
		}
		else {
			return null;
		}

	}

	public Person getPersonById(int pid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Person person=entityManager.find(Person.class, pid);

		return null;
	}

	public boolean deletePersonById(int pid) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, pid);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Person upadtePersonId(int pid, Person persons)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person1=entityManager.find(Person.class, pid);
		if(person1 != null) {
//			person1.setPid(person1.getPid());
			person1.setName(person1.getName());
			person1.setAge(person1.getAge());
			person1.setAddress(person1.getAddress());
			person1.setPhno(person1.getPhno());
			person1.setGender(person1.getGender());
			entityTransaction.begin();
			entityManager.remove(person1);
			entityTransaction.commit();
			return person1;
		}  
		else {
			return null;
		}	
	}

	public List<Person> getAllPerson()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Person s");
		List<Person> persons  = query.getResultList();
		
		return persons ;
		
	
	}

	public List<Person> getPersonByGender(String gender) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Person s where gender=?1");
		query.setParameter(1, gender);
		List<Person> persons  = query.getResultList();
		
		return persons ;

		
	}

	public List<Person> getPersonByAge(int age)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Person s where age=?1");
		query.setParameter(1, age);
		List<Person> persons  = query.getResultList();
		
		return persons ;
	}

	public List<Person> getPersonByPhone(long phno) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Person s where phno=?1 ");
        query.setParameter(1, phno);
		List<Person> persons  = query.getResultList();
		
		return persons ;
		
	}

}
