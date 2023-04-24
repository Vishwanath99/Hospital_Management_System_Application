package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Branch;

public interface BranchDao {
	public Branch saveBranch(int hospital_id, Branch branch);
	
	public Branch getBranchById(int branch_id);
	
	public boolean deleteBranchById(int branch_id);
	
	public Branch updateBranchId(int branch_id, Branch branch);
	
	public List<Branch> getAllBranch();
	
}
