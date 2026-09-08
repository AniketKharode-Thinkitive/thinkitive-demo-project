package com.thinkitive.demo.service;

import java.util.List;

import com.thinkitive.demo.dto.request.BranchRequestDTO;
import com.thinkitive.demo.dto.response.BranchDTOResponseNative;
import com.thinkitive.demo.dto.response.BranchResponseDTO;

public interface BranchService {
	BranchResponseDTO createBranch(BranchRequestDTO brd);
	BranchResponseDTO getBranchById(int id);
	List<BranchDTOResponseNative>  getAllBranches();
	BranchResponseDTO updateBranch(int id ,BranchRequestDTO brd);
	void deleteBranch(int d);
}
