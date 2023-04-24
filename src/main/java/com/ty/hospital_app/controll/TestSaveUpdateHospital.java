package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestSaveUpdateHospital {
	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		HospitalService service=new HospitalService();
		hospital.setHospital_id(2);
		hospital.setHospital_name("Apollo");
		hospital.setHospital_website("www.apollo.com");
		service.updateHospital(2, hospital);

	}
}
