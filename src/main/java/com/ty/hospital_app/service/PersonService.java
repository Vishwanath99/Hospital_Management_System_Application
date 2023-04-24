package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.PersonDaoImp;
import com.ty.hospital_app.dto.Person;

public class PersonService {

	public void savePerson(int eid, Person persons) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person2=personDaoImp.savePerson(eid, persons);
		if( person2 != null) {
			System.out.println("Person saved");
		}
		else {
			System.out.println("Person not saved");
		}
	}


	public Person getPersonById(int pid) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person2=personDaoImp.getPersonById(pid);
		if (person2!= null) {
			return person2;	
		}
		else {
			return null;
		}
	}

	public void deletePersonById(int pid) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		boolean flag=personDaoImp.deletePersonById(pid);
		if(flag) {
			System.out.println("Observation deleted");
		}
		else {
			System.out.println("Observation not deleted");
		}
	}

	public Person upadtePersonId(int pid, Person persons) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person2=personDaoImp.upadtePersonId(pid, persons);
		if (person2 != null) {
			return person2;
		}
		else {
			return null;
		}
	}

	public List<Person> getAllPerson()
	{
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person>persons =personDaoImp.getAllPerson();
		if(persons != null)
		{
			return persons;
		}
		else {
			return null;
		}

	}

	public List<Person> getPersonByGender(String gender)
	{
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person>persons =personDaoImp.getPersonByGender(gender);
		if(persons != null)
		{
			return persons;
		}
		else {
			return null;
		}
	}

	public List<Person> getPersonByAge(int age)
	{
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person>persons =personDaoImp.getPersonByAge(age);
		if(persons != null)
		{
			return persons;
		}
		else {
			return null;
		}
	}

	public List<Person> getPersonByPhone(long phno)
	{
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person>persons =personDaoImp.getPersonByPhone(phno);
		if(persons != null)
		{
			return persons;
		}
		else {
			return null;
		}
	}
}
