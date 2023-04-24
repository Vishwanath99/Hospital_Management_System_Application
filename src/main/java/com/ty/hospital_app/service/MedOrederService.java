package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.MedOrderDaoImp;
import com.ty.hospital_app.dto.MedOrder;

public class MedOrederService 
{
	public void saveMedOrder(int eid, MedOrder medOrder) {
		MedOrderDaoImp medOrderDaoImp=new MedOrderDaoImp();
		MedOrder medOrder2=medOrderDaoImp.saveMedOrder(eid, medOrder);
		if( medOrder2 != null) {
			System.out.println("Medorder saved");
		}
		else {
			System.out.println("Unfortunately Medorder not saved");
		}
	}

	public MedOrder getMedOrderById(int mid) {
		MedOrderDaoImp medOrderDaoImp=new MedOrderDaoImp();
		MedOrder medOrder2=medOrderDaoImp.getMedOrderById(mid);
		if (medOrder2!= null) {
			return medOrder2;	
		}
		else {
			return null;
		}
	}

	public void deleteMedOrderById(int mid) {
		MedOrderDaoImp medOrderDaoImp=new MedOrderDaoImp();
		boolean flag=medOrderDaoImp.deleteMedOrderById(mid);
		if(flag) {
			System.out.println("Encounter deleted");
		}
		else {
			System.out.println("Encounter not deleted");
		}
	}

	public MedOrder updateMedOrderId(int mid, MedOrder medOrder) {
		MedOrderDaoImp medOrderDaoImp=new MedOrderDaoImp();
		MedOrder medOrder2=medOrderDaoImp.updateMedOrderId(mid, medOrder);
		if (medOrder2 != null) {
			return medOrder2;
		}
		else {
			return null;
		}

	}

	public List<MedOrder> getAllMedorder(){
		MedOrderDaoImp medOrderDaoImp=new MedOrderDaoImp();
		List<MedOrder> medOrder2=medOrderDaoImp.getAllMedorder();
		if(medOrder2 != null)
		{
			return medOrder2;
		}
		else {
			return null;
		}


	}

	public List<MedOrder> getMedOrderByDoctorname(String dname){
		MedOrderDaoImp medOrderDaoImp=new MedOrderDaoImp();
		List<MedOrder> medOrder2=medOrderDaoImp.getMedOrderByDoctorname(dname);
		if(medOrder2 != null)
		{
			return medOrder2;
		}
		else {
			return null;
		}
	}


}
