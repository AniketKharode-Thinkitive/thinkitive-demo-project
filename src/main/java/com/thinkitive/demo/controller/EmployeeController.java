package com.thinkitive.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.EmployeeDTORequest;
import com.thinkitive.demo.dto.response.EmployeeDTOResponseNative;
import com.thinkitive.demo.dto.response.EmployeeResponseDTO;
import com.thinkitive.demo.dto.response.StandardResponse;
import com.thinkitive.demo.service.EmployeeServiceImpl;
import com.thinkitive.demo.util.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/branches")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping("/{branchId}/employees")
	public ResponseEntity<StandardResponse> create(@PathVariable int branchId,
			@RequestBody EmployeeDTORequest request, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		employeeService.create(branchId, request);

		StandardResponse response = StandardResponse.suceess(requestId, "Employee Created Successfully",
				ResponseStatus.CREATED, path);

		return new ResponseEntity(response, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/{branchId}/employees")
	public ResponseEntity<StandardResponse<List<EmployeeDTOResponseNative>>> getAll(@PathVariable int branchId ,HttpServletRequest httpServletRequest) {

	    String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
	    List<EmployeeDTOResponseNative> employees =
	            employeeService.getAll(branchId);

	     StandardResponse<List<EmployeeDTOResponseNative>> of = StandardResponse.data(requestId,"Employee fetched successfully",employees,
	    		ResponseStatus.FETCHED,path);
	     return ResponseEntity.ok(of);
	}

	
	@GetMapping("/{branchId}/employees/{employeeId}")
	public ResponseEntity<StandardResponse<EmployeeDTOResponseNative>> getById(@PathVariable int branchId, @PathVariable int employeeId,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		
	    
	    	EmployeeDTOResponseNative byId = employeeService.getById(branchId, employeeId);
	    	 StandardResponse<EmployeeDTOResponseNative> of = StandardResponse.data(requestId, "Employee Fetched Based On Id", byId, ResponseStatus.FETCHED, path);
	    	 return ResponseEntity.ok(of);
	}

	@PutMapping("/{branchId}/employees/{employeeId}")
	public ResponseEntity<StandardResponse<EmployeeResponseDTO>> update(@PathVariable int branchId, @PathVariable int employeeId,
			@RequestBody EmployeeDTORequest request,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		 EmployeeResponseDTO update = employeeService.update(branchId, employeeId, request);
		 StandardResponse<EmployeeResponseDTO> of = StandardResponse.data(requestId, "Employeee Data updated",update ,ResponseStatus.UPDATED, path);
		 return ResponseEntity.ok(of);
		 
	}

	
	@DeleteMapping("/{branchId}/employees/{employeeId}")
	public ResponseEntity<StandardResponse> delete(@PathVariable int branchId, @PathVariable int employeeId) {
		
		employeeService.delete(branchId, employeeId);

		 return  ResponseEntity.noContent().build();
	}

	
	@PutMapping("/{branchId}/employees/{employeeId}/manager/{managerId}")
	public ResponseEntity<StandardResponse> assignManager(@PathVariable int branchId, @PathVariable int employeeId,@PathVariable int managerId,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		 EmployeeResponseDTO assignManager = employeeService.assignManager(branchId, employeeId, managerId);
		 StandardResponse<EmployeeResponseDTO> of = StandardResponse.data(requestId, "Manager Assigned",assignManager, ResponseStatus.UPDATED, path);
		 return ResponseEntity.ok(of);
	}

	
	@DeleteMapping("/{branchId}/employees/{employeeId}/manager")
	public ResponseEntity<StandardResponse> removeManager(@PathVariable int branchId, @PathVariable int employeeId) {

		employeeService.removeManager(branchId, employeeId);
		return ResponseEntity.noContent().build();
	}

	
	@GetMapping("/{branchId}/managers/{managerId}/employees")
	public ResponseEntity<StandardResponse> getEmployeesByManager(@PathVariable int branchId, @PathVariable int managerId,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		 List<EmployeeDTOResponseNative> employeesByManager = employeeService.getEmployeesByManager(branchId, managerId);
		 StandardResponse<List<EmployeeDTOResponseNative>> data = StandardResponse.data(requestId, "Employees Fetched By Manager", employeesByManager, ResponseStatus.FETCHED, path);
		 return ResponseEntity.ok(data);
	}

	@PutMapping("/{branchId}/employees/{employeeId}/project/{projectId}")
	public ResponseEntity<StandardResponse> assignProject(@PathVariable int branchId, @PathVariable int employeeId,
			@PathVariable int projectId , HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		EmployeeResponseDTO assignProject = employeeService.assignProject(branchId, employeeId, projectId);
		StandardResponse<EmployeeResponseDTO> data = StandardResponse.data(requestId, "Project has been assigned", assignProject, ResponseStatus.UPDATED, path);
		return ResponseEntity.ok(data);
	}

	@DeleteMapping("/{branchId}/employees/{employeeId}/project")
	public ResponseEntity<StandardResponse> removeProject(@PathVariable int branchId, @PathVariable int employeeId) {

		 employeeService.removeProject(branchId, employeeId);
		 return ResponseEntity.noContent().build();
	}

	@GetMapping("/{branchId}/projects/{projectId}/employees")
	public ResponseEntity<StandardResponse> getEmployeesByProject(@PathVariable int branchId, @PathVariable int projectId,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		List<EmployeeDTOResponseNative> employeesByProject = employeeService.getEmployeesByProject(branchId, projectId);
		StandardResponse<List<EmployeeDTOResponseNative>> data = StandardResponse.data(requestId, "Fetched Employees Based on Project:- "+projectId, employeesByProject, ResponseStatus.FETCHED, path);
		
		 return ResponseEntity.ok(data);
	}
}