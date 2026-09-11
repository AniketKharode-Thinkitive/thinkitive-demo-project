package com.thinkitive.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.EmployeeDTORequest;
import com.thinkitive.demo.dto.response.EmployeeDTOResponseNative;
import com.thinkitive.demo.dto.response.EmployeeResponseDTO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.entity.Employee;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.entity.Project;
import com.thinkitive.demo.exception.customexception.ResourceDoesNotMatchException;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.repo.BranchRepository;
import com.thinkitive.demo.repo.EmployeeRepository;
import com.thinkitive.demo.repo.ManagerRepository;
import com.thinkitive.demo.repo.ProjectRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public EmployeeResponseDTO create(int branchId, EmployeeDTORequest request) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Manager manager = managerRepository.findById(request.getManagerId())
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + request.getManagerId()));

		Project project = projectRepository.findById(request.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + request.getProjectId()));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		if (project.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		Employee employee = new Employee();

		employee.setName(request.getName());
		employee.setSalary(request.getSalary());
		employee.setManager(manager);
		employee.setProject(project);
		employee.setBranch(branch);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),
				save.getManager().getId(), save.getProject().getId());
	}

	public List<EmployeeDTOResponseNative> getAll(int branchId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch Id does not exist: " + branchId));

		List<EmployeeDTOResponseNative> employees = employeeRepository.getAll();

		return employees.stream().filter(employee -> employee.getBranchId() == branch.getId())
				.map(employee -> new EmployeeDTOResponseNative(employee.getName(), employee.getSalary(),
						employee.getBranchId(), employee.getManagerId(), employee.getGovernmentId()))
				.collect(Collectors.toList());
	}

	public EmployeeDTOResponseNative getById(int branchId, int employeeId) {

		EmployeeDTOResponseNative employee = employeeRepository.getById(branchId, employeeId);

		if (employee == null) {
			throw new ResourceNotFoundException("Employee does not exist: " + employeeId);
		}

		return employee;
	}

	public EmployeeResponseDTO update(int branchId, int employeeId, EmployeeDTORequest request) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist: " + employeeId));

		if (employee.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Employee does not belong to this branch");
		}

		Manager manager = managerRepository.findById(request.getManagerId())
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + request.getManagerId()));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		Project project = projectRepository.findById(request.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + request.getProjectId()));

		if (project.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		employee.setName(request.getName());
		employee.setSalary(request.getSalary());
		employee.setManager(manager);
		employee.setProject(project);
		employee.setBranch(branch);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),
				save.getManager().getId(), save.getProject().getId());
	}

	public void delete(int branchId, int employeeId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist: " + employeeId));

		if (employee.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Employee does not belong to this branch");
		}

		employeeRepository.delete(employee);
	}

	public EmployeeResponseDTO assignManager(int branchId, int employeeId, int managerId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist: " + employeeId));

		if (employee.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Employee does not belong to this branch");
		}

		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + managerId));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		employee.setManager(manager);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),
				save.getManager().getId(), save.getProject().getId());
	}

	public EmployeeResponseDTO removeManager(int branchId, int employeeId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist: " + employeeId));

		if (employee.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Employee does not belong to this branch");
		}

		employee.setManager(null);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(), 0,
				save.getProject().getId());
	}

	public List<EmployeeDTOResponseNative> getEmployeesByManager(int branchId, int managerId) {

		List<EmployeeDTOResponseNative> all = employeeRepository.getEmployeesByManager(branchId, managerId);

		if (all == null) {
			throw new ResourceNotFoundException("Employee does not exist");
		}

		return all;
	}

	public EmployeeResponseDTO assignProject(int branchId, int employeeId, int projectId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist: " + employeeId));

		if (employee.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Employee does not belong to this branch");
		}

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + projectId));

		if (project.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		employee.setProject(project);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),
				save.getManager().getId(), save.getProject().getId());
	}

	public EmployeeResponseDTO removeProject(int branchId, int employeeId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist: " + employeeId));

		if (employee.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Employee does not belong to this branch");
		}

		employee.setProject(null);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),
				save.getManager().getId(), 0);
	}

	public List<EmployeeDTOResponseNative> getEmployeesByProject(int branchId, int projectId) {

		List<EmployeeDTOResponseNative> all = employeeRepository.getEmployeesByProject(branchId, projectId);

		if (all == null) {
			throw new ResourceNotFoundException("Employee does not exist");
		}

		return all;
	}

	public List<EmployeeDTOResponseNative> getAllByBranch(int branchId) {

		branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		return employeeRepository.getAllByBranch(branchId);
	}
}