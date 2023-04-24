package com.ty.hospital_app.service;

import java.util.List;  

import com.ty.hospital_app.dao.imp.ItemsdaoImp;
import com.ty.hospital_app.dto.Items;

public class ItemsService 
{
	public void saveItems(int mid, Items  items) {
		ItemsdaoImp itemsdaoImp=new ItemsdaoImp();
		Items items2=itemsdaoImp.saveItems(mid, items);
		if( items2 != null) {
			System.out.println("Items saved");
		}
		else {
			System.out.println("Items Medorder not saved");
		}
	}

	public Items getItemsById(int iid) {
		ItemsdaoImp itemsdaoImp=new ItemsdaoImp();
		Items items2=itemsdaoImp.getItemsById(iid);
		if (items2!= null) {
			return items2;	
		}
		else {
			return null;
		}
	}

	public void deleteItemsById(int iid) {
		ItemsdaoImp itemsdaoImp=new ItemsdaoImp();
		boolean flag=itemsdaoImp.deleteItemsById(iid);
		if(flag) {
			System.out.println("Items deleted");
		}
		else {
			System.out.println("Items not deleted");  
		}

	}

	public Items upadateItemsId(int iid, Items items) {
		ItemsdaoImp itemsdaoImp=new ItemsdaoImp();
		Items items2=itemsdaoImp.upadateItemsId(iid, items);
		if (items2 != null) {
			return items2;
		}
		else {
			return null;
		}
	}

	public List<Items> getAllitems() {
		ItemsdaoImp itemsdaoImp=new ItemsdaoImp();
		List<Items> items =itemsdaoImp.getAllitems();
		if(items != null)
		{
			return items;
		}
		else {
			return null;
		}
	}
}
