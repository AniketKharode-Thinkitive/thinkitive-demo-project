package com.thinkitive.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.ManagerRequestDTO;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.service.ManagerServiceImpl;

@RestController
@RequestMapping("/api/branches/{bid}/managers")
public class ManagerController {
	@Autowired
	private ManagerServiceImpl msi;
	@PostMapping
	public ManagerResponseDTIO create(@PathVariable int bid , @RequestBody ManagerRequestDTO mr ) {
		ManagerResponseDTIO manager = msi.createManager(bid, mr);
		return manager;
}
	@GetMapping
	public List<ManagerResponseDTIO> findAllMan(@PathVariable int bid){
		List<ManagerResponseDTIO> managersByBranch = msi.getManagersByBranch(bid);
		return managersByBranch;
	}
	@GetMapping("/{managerId}")
	public ManagerResponseDTIO findManagerById(@PathVariable int bid , @PathVariable int managerId ) {
		ManagerResponseDTIO managerById = msi.findManagerById(bid, managerId);
		return managerById;
	}
	@PutMapping("/{managerId}")
	public ManagerResponseDTIO update(@PathVariable int bid , @PathVariable int managerId,@RequestBody ManagerRequestDTO mr) {
		ManagerResponseDTIO update = msi.update(bid, managerId, mr);
		return update;
	}
	@DeleteMapping("/{managerId}")
	public void delete(@PathVariable int bid , @PathVariable int managerId) {
		msi.delete(bid, managerId);
	}
}
