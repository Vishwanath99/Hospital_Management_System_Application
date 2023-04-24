package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Items;

public interface ItemsDao 
{
	public Items saveItems(int mid, Items  items);
	
	public Items getItemsById(int iid);
	
	public boolean deleteItemsById(int iid);
	
	public Items upadateItemsId(int iid, Items items);
	
	public List<Items> getAllitems();
}
