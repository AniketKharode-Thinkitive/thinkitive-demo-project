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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.BranchRequestDTO;
import com.thinkitive.demo.dto.response.BranchDTOResponseNative;
import com.thinkitive.demo.dto.response.BranchResponseDTO;
import com.thinkitive.demo.service.BranchService;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
		@Autowired
		private BranchService branchService;
		
		@PostMapping
		public BranchResponseDTO createBranch( @RequestBody BranchRequestDTO request) {
			return branchService.createBranch(request);
		}
		@GetMapping("/{id}")
		public BranchResponseDTO getBranchById(@PathVariable int id) {
			return branchService.getBranchById(id);
		}
		@GetMapping
		public List<BranchDTOResponseNative> findAll(){
			return branchService.getAllBranches();
		}
		@PutMapping("/{id}")
		public BranchResponseDTO updateById(@PathVariable int id , @RequestBody BranchRequestDTO request) {
			BranchResponseDTO updateBranch = branchService.updateBranch(id, request);
			return updateBranch;
		}
		@DeleteMapping("/{id}")
		public void delete(@PathVariable int id) {
			branchService.deleteBranch(id);
		}
}
