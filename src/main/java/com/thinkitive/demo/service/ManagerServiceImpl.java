package com.thinkitive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.ManagerRequestDTO;
import com.thinkitive.demo.dto.response.ManagerDTOResponseNative;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.repo.BranchRepository;
import com.thinkitive.demo.repo.ManagerRepository;
@Service
public class ManagerServiceImpl {
	
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private ManagerRepository managerRepository;
	
	public ManagerResponseDTIO createManager(int bid , ManagerRequestDTO mr ) {
		Optional<Branch> byId = branchRepository.findById(bid);
		if(byId.isEmpty()) {
	    	throw new ResourceNotFoundException("Branch  does not exist");
	    }
		Branch branch = byId.get();
		Manager m = new Manager();
		m.setName(mr.getName());
		m.setBranch(branch);
		
		Manager save = managerRepository.save(m);
		return new ManagerResponseDTIO(save.getId(),save.getName(),save.getBranch().getId());
	}
	
	public List<ManagerDTOResponseNative> getManagersByBranch(int branchId) {
			Optional<Branch> byId = branchRepository.findById(branchId);
			if(byId.isEmpty()) {
				throw new ResourceNotFoundException("Branch Does Not exist");
			}
		
		 return managerRepository.getAllByBranch(branchId);
	}
	

	
	public ManagerResponseDTIO findManagerById(int bid,int mid) {
		Optional<Branch> byId = branchRepository.findById(bid);
		if(byId.isEmpty()) {
			throw new ResourceNotFoundException("Branch Does Not exist");
		}
		Branch branch = byId.get();
		Optional<Manager> byId2 = managerRepository.findById(mid);
		if(byId2.isEmpty()) {
			throw new ResourceNotFoundException("Manager Id Does Not exist");
		}
		Manager mr = byId2.get();
		if(mr.getBranch().getId()!=bid) {
			throw new ResourceNotFoundException("Manager does not belong to this branch");
		}
		return new ManagerResponseDTIO(mr.getId(), mr.getName(), mr.getBranch().getId());
	}
	
	public ManagerResponseDTIO update(int bid,int mid , ManagerRequestDTO mr) {
		Optional<Branch> byId = branchRepository.findById(bid);
		Branch branch = byId.get();
		Optional<Manager> byId2 = managerRepository.findById(mid);
		Manager manager = byId2.get();
		if(manager.getBranch().getId()!=branch.getId()) {
			throw new RuntimeException("Manager does not exist in this branch");
		}	
		manager.setName(mr.getName());
		Manager updated = managerRepository.save(manager);
		return new ManagerResponseDTIO(updated.getId(), updated.getName(),updated.getBranch().getId());
	}
	
	public void delete(int bid , int mid) {
		Optional<Branch> byId = branchRepository.findById(bid);
		Branch branch = byId.get();
		Optional<Manager> byId2 = managerRepository.findById(mid);
		Manager manager = byId2.get();
		if(manager.getBranch().getId()!=branch.getId()) {
			throw new RuntimeException("Manager does not exist in this branch");
		}	
		managerRepository.delete(manager);
	}
}
