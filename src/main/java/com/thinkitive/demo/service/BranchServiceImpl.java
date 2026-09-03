package com.thinkitive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.BranchRequestDTO;
import com.thinkitive.demo.dto.response.BranchResponseDTO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.repo.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private  BranchRepository branchRepository;

	@Override
	public BranchResponseDTO createBranch(BranchRequestDTO brd) {
		Branch b = new Branch();
		b.setName(brd.getName());
		b.setLocation(brd.getLocation());
		Branch save = branchRepository.save(b);
		return new BranchResponseDTO(save.getId(),save.getName(),save.getLocation());
	}

	@Override
	public BranchResponseDTO getBranchById(int id) {
		Optional<Branch> byId = branchRepository.findById(id);
		Branch branch = byId.get();
		return new BranchResponseDTO(branch.getId(),branch.getName(),branch.getLocation());
	}

	@Override
	public List<BranchResponseDTO> getAllBranches() {
		List<Branch> all = branchRepository.findAll();
		List<BranchResponseDTO> list = new ArrayList();
		for(Branch a:all) {
			BranchResponseDTO br = new BranchResponseDTO(a.getId(),a.getName(),a.getLocation());
			list.add(br);
		}
		return list;
	}

	@Override
	public BranchResponseDTO updateBranch(int id, BranchRequestDTO brd) {
		Optional<Branch> byId = branchRepository.findById(id);
		Branch branch = byId.get();
		branch.setName(brd.getName());
		branch.setLocation(brd.getLocation());
		Branch newB = branchRepository.save(branch);
		
		return new BranchResponseDTO(newB.getId(),newB.getName(),newB.getLocation());
	}

	@Override
	public void deleteBranch(int d) {
		Optional<Branch> byId = branchRepository.findById(d);
		Branch branch = byId.get();
		branchRepository.delete(branch);
		
	}


}