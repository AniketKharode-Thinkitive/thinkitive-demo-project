package com.thinkitive.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	public StandardResponse<EmployeeResponseDTO> create(@PathVariable int branchId, @RequestBody EmployeeDTORequest request,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		EmployeeResponseDTO employeeResponseDTO = employeeService.create(branchId, request);
		return StandardResponse.of(requestId, "Employee Created Successfully", employeeResponseDTO, ResponseStatus.CREATED, path);
	}

	
//	@GetMapping("/{branchId}/employees")
//	public StandardResponse<List<EmployeeDTOResponseNative>> getAll(@PathVariable int branchId) {
//		String requestId = UUID.randomUUID().toString();
//		List<EmployeeDTOResponseNative> all = employeeService.getAll(branchId);
////		StandardResponse<List<EmployeeDTOResponseNative>> sr =  new StandardResponse().setCode(ResponseStatus.FETCHED);
//		return new StandardResponse.of("Employee fetched Successfully", all, HttpStatus.OK);
//		
//	}
	
	@GetMapping("/{branchId}/employees")
	public StandardResponse<List<EmployeeDTOResponseNative>> getAll(@PathVariable int branchId ,HttpServletRequest httpServletRequest) {

	    String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
	    List<EmployeeDTOResponseNative> employees =
	            employeeService.getAll(branchId);

	    return StandardResponse.of(requestId,"Employee fetched successfully",employees,
	    		ResponseStatus.FETCHED,path);
	}


	
	@GetMapping("/{branchId}/employees/{employeeId}")
	public StandardResponse<EmployeeDTOResponseNative> getById(@PathVariable int branchId, @PathVariable int employeeId,HttpServletRequest httpServletRequest) {
		String requestId = UUID.randomUUID().toString();
	    String path = httpServletRequest.getRequestURI();
		
	    
	    	EmployeeDTOResponseNative byId = employeeService.getById(branchId, employeeId);
	    	return StandardResponse.of(requestId, "Employee Fetched Based On Id", byId, ResponseStatus.FETCHED, path);
	}

	@PutMapping("/{branchId}/employees/{employeeId}")
	public EmployeeResponseDTO update(@PathVariable int branchId, @PathVariable int employeeId,
			@RequestBody EmployeeDTORequest request) {

		return employeeService.update(branchId, employeeId, request);
	}

	
	@DeleteMapping("/{branchId}/employees/{employeeId}")
	public String delete(@PathVariable int branchId, @PathVariable int employeeId) {

		employeeService.delete(branchId, employeeId);

		return "Employee deleted successfully";
	}

	
	@PutMapping("/{branchId}/employees/{employeeId}/manager/{managerId}")
	public EmployeeResponseDTO assignManager(@PathVariable int branchId, @PathVariable int employeeId,@PathVariable int managerId) {

		return employeeService.assignManager(branchId, employeeId, managerId);
	}

	
	@DeleteMapping("/{branchId}/employees/{employeeId}/manager")
	public EmployeeResponseDTO removeManager(@PathVariable int branchId, @PathVariable int employeeId) {

		return employeeService.removeManager(branchId, employeeId);
	}

	
	@GetMapping("/{branchId}/managers/{managerId}/employees")
	public List<EmployeeDTOResponseNative> getEmployeesByManager(@PathVariable int branchId, @PathVariable int managerId) {

		return employeeService.getEmployeesByManager(branchId, managerId);
	}

	@PutMapping("/{branchId}/employees/{employeeId}/project/{projectId}")
	public EmployeeResponseDTO assignProject(@PathVariable int branchId, @PathVariable int employeeId,
			@PathVariable int projectId) {

		return employeeService.assignProject(branchId, employeeId, projectId);
	}

	@DeleteMapping("/{branchId}/employees/{employeeId}/project")
	public EmployeeResponseDTO removeProject(@PathVariable int branchId, @PathVariable int employeeId) {

		return employeeService.removeProject(branchId, employeeId);
	}

	@GetMapping("/{branchId}/projects/{projectId}/employees")
	public List<EmployeeDTOResponseNative> getEmployeesByProject(@PathVariable int branchId, @PathVariable int projectId) {

		return employeeService.getEmployeesByProject(branchId, projectId);
	}
}