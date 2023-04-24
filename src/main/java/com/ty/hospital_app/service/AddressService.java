package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.AddressDaoImp;
import com.ty.hospital_app.dto.Address;

public class AddressService {

	public void saveAddress(int branch_id, Address address) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.saveAddress(branch_id, address);
		if(address2 != null) {
			System.out.println("Address saved");
		}
		else {
			System.out.println("Unfortunately Address not saved");
		}

	}

	public Address getAddressById(int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.getAddressById(aid);
		if (address2!= null) {
			return address2;	
		}
		else {
			return null;
		}
	}

	public void deleteAddresById(int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		boolean falg=addressDaoImp.deleteAddresById(aid);
		if(falg) {
			System.out.println("Address deleted");
		}
		else {
			System.out.println("Address not deleted");
		}
	}

	public Address updateAdressById(int aid, Address address) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.updateAdressById(aid, address);
		if (address2 != null) {
			return address2;
		}
		else {
			return null;
		}
	}

	public List<Address> getAddressAll() {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		List<Address> address =addressDaoImp.getAddressAll();
		if( address != null)
		{
			return  address ;
		}
		else {
			return null;
		}
	}
}
