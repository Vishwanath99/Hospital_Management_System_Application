package com.ty.hospital_app.service;  

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService 
{
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp daoImp=new HospitalDaoImp();
		Hospital hospital1=daoImp.savehospital(hospital);
		if (hospital1 != null) {
			System.out.println("Data saved");
		}
		else {
			System.out.println("Unfortunately data not saved");
		}
	}

	public Hospital getHospitalById(int hospital_id) {
		HospitalDaoImp daoImp=new HospitalDaoImp();
		Hospital hospital1=daoImp.getHospitalById(hospital_id);
		if (hospital1 != null) {
			return hospital1;	
		}
		else {
			return null;
		}
	}

	public void deleteHospitalById(int hospital_id) {
		HospitalDaoImp daoImp=new HospitalDaoImp();
		boolean flag =daoImp.deleteHospitalById(hospital_id);
		if(flag) {
			System.out.println("Data deleted");
		}
		else {
			System.out.println("Data not deleted");
		}
	}


	public Hospital updateHospital(int hospital_id, Hospital hospital) {
		HospitalDaoImp daoImp=new HospitalDaoImp();
		Hospital hospital1=daoImp.updateHospital(hospital_id, hospital);
		if (hospital1 != null) {
			return hospital1;
		}
		else {
			return null;
		}
	}

}
