package com.thinkitive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.EmployeeDTORequest;
import com.thinkitive.demo.dto.request.ManagerRequestDTO;
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

	public List<EmployeeResponseDTO> getAll(int branchId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		List<Employee> employees = employeeRepository.findAll();

		List<EmployeeResponseDTO> list = new ArrayList();

		for (Employee employee : employees) {

			if (employee.getBranch().getId() == branch.getId()) {

				EmployeeResponseDTO response = new EmployeeResponseDTO(employee.getId(), employee.getName(),employee.getSalary(), employee.getBranch().getId(), employee.getManager().getId(),employee.getProject().getId());

				list.add(response);
			}
		}

		return list;
	}

	public EmployeeResponseDTO getById(int branchId, int employeeId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Employee> byId2 = employeeRepository.findById(employeeId);

		Employee employee = byId2.get();

		if (employee.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Employee does not belong to this branch");
		}

		return new EmployeeResponseDTO(employee.getId(), employee.getName(), employee.getSalary(),employee.getBranch().getId(), employee.getManager().getId(), employee.getProject().getId());
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
	
	public List<EmployeeResponseDTO> getEmployeesByManager(int branchId, int managerId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Manager> byId2 = managerRepository.findById(managerId);

		Manager manager = byId2.get();

		if (manager.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Manager does not belong to this branch");
		}

		List<Employee> employees = manager.getEmployees();

		List<EmployeeResponseDTO> list = new ArrayList<>();

		for (Employee employee : employees) {

			EmployeeResponseDTO response = new EmployeeResponseDTO(employee.getId(), employee.getName(),employee.getSalary(), employee.getBranch().getId(), employee.getManager().getId(),employee.getProject().getId());

			list.add(response);
		}

		return list;
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

	public List<EmployeeResponseDTO> getEmployeesByProject(int branchId, int projectId) {

		Optional<Branch> byId = branchRepository.findById(branchId);

		Branch branch = byId.get();

		Optional<Project> byId2 = projectRepository.findById(projectId);

		Project project = byId2.get();

		if (project.getBranch().getId() != branch.getId()) {

			throw new RuntimeException("Project does not belong to this branch");
		}

		List<Employee> employees = project.getEmployees();

		List<EmployeeResponseDTO> list = new ArrayList<>();

		for (Employee employee : employees) {

			EmployeeResponseDTO response = new EmployeeResponseDTO(employee.getId(), employee.getName(),employee.getSalary(), employee.getBranch().getId(), employee.getManager().getId(),employee.getProject().getId());

			list.add(response);
		}

		return list;
	}
}
