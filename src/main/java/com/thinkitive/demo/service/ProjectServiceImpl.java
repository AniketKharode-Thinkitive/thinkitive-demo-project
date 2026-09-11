package com.thinkitive.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.ProjectRequestDTO;
import com.thinkitive.demo.dto.response.ManagerProjectResponseDTO;
import com.thinkitive.demo.dto.response.ProjectDTOResponseNative;
import com.thinkitive.demo.dto.response.ProjectResponseDTO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.entity.Project;
import com.thinkitive.demo.exception.customexception.ResourceDoesNotMatchException;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.repo.BranchRepository;
import com.thinkitive.demo.repo.ManagerRepository;
import com.thinkitive.demo.repo.ProjectRepository;

@Service
public class ProjectServiceImpl {

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private BranchRepository branchRepository;

	public ProjectResponseDTO createProject(int branchId, ProjectRequestDTO request) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Project project = new Project();

		project.setName(request.getName());
		project.setDescription(request.getDescription());
		project.setBranch(branch);

		Project savedProject = projectRepository.save(project);

		return new ProjectResponseDTO(savedProject.getId(), savedProject.getName(), savedProject.getDescription(),
				savedProject.getBranch().getId());
	}

	public List<ProjectDTOResponseNative> getProjectByBranch(int branchId) {

		branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		return projectRepository.getAllByBranch(branchId);
	}

	public ProjectResponseDTO getProjectById(int branchId, int projectId) {

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + projectId));

		if (project.getBranch().getId() != branchId) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		return new ProjectResponseDTO(project.getId(), project.getName(), project.getDescription(),
				project.getBranch().getId());
	}

	public ProjectResponseDTO updateProject(int branchId, int projectId, ProjectRequestDTO request) {

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + projectId));

		if (project.getBranch().getId() != branchId) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		project.setName(request.getName());
		project.setDescription(request.getDescription());

		Project updatedProject = projectRepository.save(project);

		return new ProjectResponseDTO(updatedProject.getId(), updatedProject.getName(), updatedProject.getDescription(),
				updatedProject.getBranch().getId());
	}

	public void deleteProject(int branchId, int projectId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + projectId));

		if (project.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		projectRepository.delete(project);
	}

	public ManagerProjectResponseDTO assignManager(int branchId, int projectId, int managerId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + projectId));

		if (project.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + managerId));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		project.getManagers().add(manager);
		manager.getProjects().add(project);

		managerRepository.save(manager);

		return new ManagerProjectResponseDTO(manager.getId(), manager.getName(), project.getId(), project.getName(),
				branch.getId(), branch.getName());
	}

	public ManagerProjectResponseDTO removeManagerFromProject(int branchId, int projectId, int managerId) {

		Branch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch does not exist: " + branchId));

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist: " + projectId));

		if (project.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Project does not belong to this branch");
		}

		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager does not exist: " + managerId));

		if (manager.getBranch().getId() != branch.getId()) {
			throw new ResourceDoesNotMatchException("Manager does not belong to this branch");
		}

		project.getManagers().remove(manager);
		manager.getProjects().remove(project);

		managerRepository.save(manager);

		return new ManagerProjectResponseDTO(manager.getId(), manager.getName(), project.getId(), project.getName(),
				branch.getId(), branch.getName());
	}

	public List<ProjectDTOResponseNative> getAllProject() {

		return projectRepository.getAll();
	}
}