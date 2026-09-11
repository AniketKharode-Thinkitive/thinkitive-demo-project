package com.thinkitive.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.ManagerRequestDTO;
import com.thinkitive.demo.dto.response.ManagerDTOResponseNative;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.exception.customexception.ResourceDoesNotMatchException;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.repo.BranchRepository;
import com.thinkitive.demo.repo.ManagerRepository;

@Service
public class ManagerServiceImpl {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private ManagerRepository managerRepository;

	public ManagerResponseDTIO createManager(int bid, ManagerRequestDTO mr) {

		Branch branch = branchRepository.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + bid));

		Manager manager = new Manager();

		manager.setName(mr.getName());
		manager.setBranch(branch);

		Manager savedManager = managerRepository.save(manager);

		return new ManagerResponseDTIO(savedManager.getId(), savedManager.getName(), savedManager.getBranch().getId());
	}

	public List<ManagerDTOResponseNative> getManagersByBranch(int branchId) {

		branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		return managerRepository.getAllByBranch(branchId);
	}

	public ManagerResponseDTIO findManagerById(int bid, int mid) {

		Branch branch = branchRepository.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + bid));

		Manager manager = managerRepository.findById(mid)
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + mid));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		return new ManagerResponseDTIO(manager.getId(), manager.getName(), manager.getBranch().getId());
	}

	public ManagerResponseDTIO update(int bid, int mid, ManagerRequestDTO mr) {

		Branch branch = branchRepository.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + bid));

		Manager manager = managerRepository.findById(mid)
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + mid));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		manager.setName(mr.getName());

		Manager updatedManager = managerRepository.save(manager);

		return new ManagerResponseDTIO(updatedManager.getId(), updatedManager.getName(),
				updatedManager.getBranch().getId());
	}

	public void delete(int bid, int mid) {

		Branch branch = branchRepository.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + bid));

		Manager manager = managerRepository.findById(mid)
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + mid));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		managerRepository.delete(manager);
	}
}