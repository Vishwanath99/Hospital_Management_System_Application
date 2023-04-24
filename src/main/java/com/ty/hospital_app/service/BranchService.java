package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Branch;

public class BranchService 
{
	public void saveBranch(int hospital_id, Branch branch) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch2=branchDaoImp.saveBranch(hospital_id, branch);
		if(branch2 != null) {
			System.out.println("Branch saved");
		}
		else {
			System.out.println("Unfortunately Branch not saved");
		}
	}

	public Branch getBranchById(int branch_id) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch2=branchDaoImp.getBranchById(branch_id);
		if (branch2 != null) {
			return branch2;	
		}
		else {
			return null;
		}

	}

	public void deleteBranchById(int branch_id) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		boolean flag=branchDaoImp.deleteBranchById(branch_id);
		if(flag) {
			System.out.println("Branch deleted");
		}
		else {
			System.out.println("Branch not deleted");
		}
	}

	public Branch updateBranchId(int branch_id, Branch branch) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch2=branchDaoImp.updateBranchId(branch_id, branch);
		if (branch2 != null) {
			return branch2;
		}
		else {
			return null;
		}

	}

	public List<Branch> getAllBranch() {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		List<Branch> branch2=branchDaoImp.getAllBranch();
		if(branch2 != null)
		{
			return branch2;
		}
		else {
			return null;
		}

	}
}
