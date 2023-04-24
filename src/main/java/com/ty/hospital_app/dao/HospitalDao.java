package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.Hospital;

public interface HospitalDao
{
	public Hospital savehospital(Hospital hospital);
	
	public Hospital getHospitalById(int hospital_id);
	
	public boolean  deleteHospitalById(int hospital_id);
	
	public Hospital updateHospital(int hospital_id, Hospital hospital);
	
}
