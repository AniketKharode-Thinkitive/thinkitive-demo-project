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

import com.thinkitive.demo.dto.request.EmployeeDTORequest;
import com.thinkitive.demo.dto.response.EmployeeResponseDTO;
import com.thinkitive.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/branches")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping("/{branchId}/employees")
	public EmployeeResponseDTO create(@PathVariable int branchId, @RequestBody EmployeeDTORequest request) {

		return employeeService.create(branchId, request);
	}

	
	@GetMapping("/{branchId}/employees")
	public List<EmployeeResponseDTO> getAll(@PathVariable int branchId) {

		return employeeService.getAll(branchId);
	}

	
	@GetMapping("/{branchId}/employees/{employeeId}")
	public EmployeeResponseDTO getById(@PathVariable int branchId, @PathVariable int employeeId) {

		return employeeService.getById(branchId, employeeId);
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
	public List<EmployeeResponseDTO> getEmployeesByManager(@PathVariable int branchId, @PathVariable int managerId) {

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
	public List<EmployeeResponseDTO> getEmployeesByProject(@PathVariable int branchId, @PathVariable int projectId) {

		return employeeService.getEmployeesByProject(branchId, projectId);
	}
}