package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.EncounterDaoImp;
import com.ty.hospital_app.dto.Encounter;

public class EncounterService {

	public void saveEncounter(int branch_id, Encounter encounter) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter2=encounterDaoImp.saveEncounter(branch_id, encounter);
		if( encounter2 != null) {
			System.out.println("Encounter saved");
		}
		else {
			System.out.println("Unfortunately Encounter not saved");
		}	
	}

	public Encounter getEncounterById(int eid) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter2=encounterDaoImp.getEncounterById(eid);
		if (encounter2!= null) {
			return encounter2;	
		}
		else {
			return null;
		}
	}

	public void deleteEncounterById(int eid) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		boolean flag=encounterDaoImp.deleteEncounterById(eid);
		if(flag) {
			System.out.println("Encounter deleted");
		}
		else {
			System.out.println("Encounter not deleted");
		}

	}  

	public Encounter updateEncounetrId(int eid, Encounter encounter) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter2=encounterDaoImp.updateEncounetrId(eid, encounter);
		if (encounter2 != null) {
			return encounter2;
		}
		else {
			return null;
		}
	}
	public List<Encounter> getAllEncounter() {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		List<Encounter> encounters =encounterDaoImp.getAllEncounter();
		if(encounters != null)
		{
			return encounters ;
		}
		else {
			return null;
		}
	}
}
