package com.thinkitive.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.BranchRequestDTO;
import com.thinkitive.demo.dto.response.BranchDTOResponseNative;
import com.thinkitive.demo.dto.response.BranchResponseDTO;
import com.thinkitive.demo.dto.response.StandardResponse;
import com.thinkitive.demo.service.BranchService;
import com.thinkitive.demo.util.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping
	public ResponseEntity<StandardResponse> createBranch(@RequestBody BranchRequestDTO request,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		branchService.createBranch(request);

		StandardResponse<Void> response = StandardResponse.suceess(requestId, "Branch is Created",
				ResponseStatus.CREATED, path);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StandardResponse> getBranchById(@PathVariable int id,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		BranchResponseDTO branch = branchService.getBranchById(id);

		StandardResponse<BranchResponseDTO> response = StandardResponse.data(requestId, "Branch Fetched Successfully",
				branch, ResponseStatus.FETCHED, path);

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<StandardResponse> findAll(
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		List<BranchDTOResponseNative> branches = branchService.getAllBranches();

		StandardResponse<List<BranchDTOResponseNative>> response = StandardResponse.data(requestId,
				"All Branches Fetched Successfully", branches, ResponseStatus.FETCHED, path);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StandardResponse> updateById(@PathVariable int id,
			@RequestBody BranchRequestDTO request, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		BranchResponseDTO updatedBranch = branchService.updateBranch(id, request);

		StandardResponse<BranchResponseDTO> response = StandardResponse.data(requestId,
				"Branch Data Updated Successfully", updatedBranch, ResponseStatus.UPDATED, path);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StandardResponse> delete(@PathVariable int id, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		branchService.deleteBranch(id);

		StandardResponse<Void> response = StandardResponse.suceess(requestId, "Branch Deleted Successfully",
				ResponseStatus.DELETED, path);

		return ResponseEntity.ok(response);
	}
}