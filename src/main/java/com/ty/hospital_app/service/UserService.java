package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.UserDaoImp;
import com.ty.hospital_app.dto.User;

public class UserService {

	public void saveUser(User user) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user2=userDaoImp.saveUser(user);
		if( user2 != null) {
			System.out.println("User saved");
		}
		else {
			System.out.println("User not saved");
		}
	}

	public User getUserById(int uid) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user2=userDaoImp.getUserById(uid);
		if (user2!= null) {
			return user2;	
		}
		else {
			return null;
		}
	}

	public void deleteUserById(int uid) {
		UserDaoImp userDaoImp=new UserDaoImp();
		boolean flag=userDaoImp.deleteUserById(uid);
		if(flag) {
			System.out.println("User deleted");
		}
		else {
			System.out.println("User not deleted");
		}
	}

	public User upadteUserId(int uid) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user2=userDaoImp.upadteUserId(uid);
		if (user2 != null) {
			return user2;
		}
		else {
			return null;
		}
	}

	public List<User> getAlluser()	{
		UserDaoImp userDaoImp=new UserDaoImp();
		List<User>users =userDaoImp.getAlluser();
		if(users != null)
		{
			return users;
		}
		else {
			return null;
		}
	}

	public List<User> getAlluserByRole(String role)	{
		UserDaoImp userDaoImp=new UserDaoImp();
		List<User>users =userDaoImp.getAlluserByRole(role);
		if(users != null)
		{
			return users;
		}
		else {
			return null;
		}
	}
}
