package com.thinkitive.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.BranchRequestDTO;
import com.thinkitive.demo.dto.response.BranchDTOResponseNative;
import com.thinkitive.demo.dto.response.BranchResponseDTO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.repo.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public BranchResponseDTO createBranch(BranchRequestDTO brd) {

		Branch branch = new Branch();

		branch.setName(brd.getName());
		branch.setLocation(brd.getLocation());

		Branch savedBranch = branchRepository.save(branch);

		return new BranchResponseDTO(savedBranch.getId(), savedBranch.getName(), savedBranch.getLocation());
	}

	@Override
	public BranchResponseDTO getBranchById(int id) {

		Branch branch = branchRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Branch Not Found: " + id));

		return new BranchResponseDTO(branch.getId(), branch.getName(), branch.getLocation());
	}

	@Override
	public List<BranchDTOResponseNative> getAllBranches() {

		return branchRepository.getAll();
	}

	@Override
	public BranchResponseDTO updateBranch(int id, BranchRequestDTO brd) {

		Branch branch = branchRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Branch Not Found: " + id));

		branch.setName(brd.getName());
		branch.setLocation(brd.getLocation());

		Branch savedBranch = branchRepository.save(branch);

		return new BranchResponseDTO(savedBranch.getId(), savedBranch.getName(), savedBranch.getLocation());
	}

	@Override
	public void deleteBranch(int id) {

		Branch branch = branchRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Branch Not Found: " + id));

		branchRepository.delete(branch);
	}
}