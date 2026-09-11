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

import com.thinkitive.demo.dto.request.ManagerRequestDTO;
import com.thinkitive.demo.dto.response.ManagerDTOResponseNative;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.dto.response.StandardResponse;
import com.thinkitive.demo.service.ManagerServiceImpl;
import com.thinkitive.demo.util.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/branches/{bid}/managers")
public class ManagerController {

	@Autowired
	private ManagerServiceImpl msi;

	@PostMapping
	public ResponseEntity<StandardResponse> create(@PathVariable int bid, @RequestBody ManagerRequestDTO mr,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		msi.createManager(bid, mr);

		StandardResponse response = StandardResponse.suceess(requestId, "Manager Created Successfully",
				ResponseStatus.CREATED, path);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<StandardResponse> findAllMan(@PathVariable int bid, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		List<ManagerDTOResponseNative> managers = msi.getManagersByBranch(bid);

		StandardResponse response = StandardResponse.data(requestId, "Managers Fetched Successfully", managers,
				ResponseStatus.FETCHED, path);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{managerId}")
	public ResponseEntity<StandardResponse> findManagerById(@PathVariable int bid, @PathVariable int managerId,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		ManagerResponseDTIO manager = msi.findManagerById(bid, managerId);

		StandardResponse response = StandardResponse.data(requestId, "Manager Fetched Successfully", manager,
				ResponseStatus.FETCHED, path);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{managerId}")
	public ResponseEntity<StandardResponse> update(@PathVariable int bid, @PathVariable int managerId,
			@RequestBody ManagerRequestDTO mr, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		ManagerResponseDTIO update = msi.update(bid, managerId, mr);

		StandardResponse response = StandardResponse.data(requestId, "Manager Data Updated Successfully", update,
				ResponseStatus.UPDATED, path);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{managerId}")
	public ResponseEntity<StandardResponse> delete(@PathVariable int bid, @PathVariable int managerId,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		msi.delete(bid, managerId);

		StandardResponse response = StandardResponse.suceess(requestId, "Manager Deleted Successfully",
				ResponseStatus.DELETED, path);

		return ResponseEntity.ok(response);
	}
}