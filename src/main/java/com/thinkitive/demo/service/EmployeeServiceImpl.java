package com.thinkitive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.EmployeeDTORequest;
import com.thinkitive.demo.dto.request.ManagerRequestDTO;
import com.thinkitive.demo.dto.response.EmployeeDTOResponseNative;
import com.thinkitive.demo.dto.response.EmployeeResponseDTO;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.entity.Employee;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.entity.Project;
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
    		Optional<Branch> byId = branchRepository.findById(branchId);
    		Branch branch = byId.get();
    		Optional<Manager> byId2 = managerRepository.findById(request.getManagerId());
    		Manager manager = byId2.get();
    		Optional<Project> byId3 = projectRepository.findById(request.getProjectId());
    		Project project = byId3.get();
    		Employee employee = new Employee();
    		employee.setName(request.getName());
    		employee.setSalary(request.getSalary());
    		employee.setManager(manager);
    		employee.setProject(project);
    		employee.setBranch(branch);
    		Employee save = employeeRepository.save(employee);
    		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(), save.getManager().getId(), save.getProject().getId());
    		
    }

	public List<EmployeeDTOResponseNative> getAll(int branchId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		List<EmployeeDTOResponseNative> employees = employeeRepository.getAll();

		List<EmployeeDTOResponseNative> list = new ArrayList();

		for (EmployeeDTOResponseNative employee : employees) {

			if (employee.getBranchId() == branch.getId()) {

				EmployeeDTOResponseNative response = new EmployeeDTOResponseNative(employee.getName(), employee.getSalary(), employee.getBranchId(), employee.getManagerId(), employee.getGovernmentId());

				list.add(response);
			}
		}

		return list;
	}

	public EmployeeDTOResponseNative getById(int branchId, int employeeId) {
	    EmployeeDTOResponseNative employee =
	            employeeRepository.getById(branchId, employeeId);

	    return employee;

	}

	public EmployeeResponseDTO update(int branchId, int employeeId, EmployeeDTORequest request) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		Optional<Manager> byId3 = managerRepository.findById(request.getManagerId());

		Manager manager = byId3.get();

		Optional<Project> byId4 = projectRepository.findById(request.getProjectId());

		Project project = byId4.get();

		employee.setName(request.getName());

		employee.setSalary(request.getSalary());

		employee.setManager(manager);

		employee.setProject(project);

		employee.setBranch(branch);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),save.getManager().getId(), save.getProject().getId());
	}

	public void delete(int branchId, int employeeId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		employeeRepository.delete(employee);
	}

	public EmployeeResponseDTO assignManager(int branchId, int employeeId, int managerId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		Optional<Manager> byId3 = managerRepository.findById(managerId);

		Manager manager = byId3.get();

		if (manager.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Manager does not belong to this branch");
		}

		employee.setManager(manager);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),save.getManager().getId(), save.getProject().getId());
	}

	public EmployeeResponseDTO removeManager(int branchId, int employeeId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		employee.setManager(null);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(), 0,save.getProject().getId());
	}
	
	public List<EmployeeDTOResponseNative> getEmployeesByManager(int branchId, int managerId) {
		 List<EmployeeDTOResponseNative> all =
		            employeeRepository.getEmployeesByManager(branchId,managerId);

		    return all;
		
	}
	
	public EmployeeResponseDTO assignProject(int branchId, int employeeId, int projectId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		Optional<Project> byId3 = projectRepository.findById(projectId);

		Project project = byId3.get();

		if (project.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Project does not belong to this branch");
		}

		employee.setProject(project);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),save.getManager().getId(), save.getProject().getId());
	}

	public EmployeeResponseDTO removeProject(int branchId, int employeeId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		employee.setProject(null);

		Employee save = employeeRepository.save(employee);

		return new EmployeeResponseDTO(save.getId(), save.getName(), save.getSalary(), save.getBranch().getId(),save.getManager().getId(), 0);
	}

	public List<EmployeeDTOResponseNative> getEmployeesByProject(int branchId, int projectId) {

		
		List<EmployeeDTOResponseNative> all =
	            employeeRepository.getEmployeesByProject(branchId, projectId);

	    return all;
		
	}
	public List<EmployeeDTOResponseNative> getAllByBranch(int bid) {
	    return employeeRepository.getAllByBranch(bid);
	}
}
