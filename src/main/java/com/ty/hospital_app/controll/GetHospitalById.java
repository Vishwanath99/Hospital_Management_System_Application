package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class GetHospitalById {
	public static void main(String[] args) {
		HospitalService service=new HospitalService();
		Hospital hospital=service.getHospitalById(1);
		System.out.println("Hospital Id:"+hospital.getHospital_id());
		System.out.println("Hospital Name:"+hospital.getHospital_name());
		System.out.println("Hospital Website:"+hospital.getHospital_website());
		System.out.println("***********************");
	}
}
