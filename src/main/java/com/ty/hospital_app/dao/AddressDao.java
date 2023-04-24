package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;

public interface AddressDao {
	public Address saveAddress(int branch_id, Address address);
	
	public Address getAddressById(int aid);
	
	public boolean deleteAddresById(int aid);
	
	public Address updateAdressById(int aid, Address address);
	
	public List<Address> getAddressAll();
}
