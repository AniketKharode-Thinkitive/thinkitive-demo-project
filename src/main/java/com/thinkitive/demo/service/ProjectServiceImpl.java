package com.thinkitive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.ManagerProjectRequestDTO;
import com.thinkitive.demo.dto.request.ProjectRequestDTO;
import com.thinkitive.demo.dto.response.ManagerDTOResponseNative;
import com.thinkitive.demo.dto.response.ManagerProjectResponseDTO;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.dto.response.ProjectDTOResponseNative;
import com.thinkitive.demo.dto.response.ProjectResponseDTO;
import com.thinkitive.demo.entity.Branch;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.entity.Project;
import com.thinkitive.demo.repo.BranchRepository;
import com.thinkitive.demo.repo.ManagerRepository;
import com.thinkitive.demo.repo.ProjectRepository;

@Service
public class ProjectServiceImpl {
	@Autowired
	private final ManagerRepository managerRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private BranchRepository branchRepository;

	ProjectServiceImpl(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}
	
	 public ProjectResponseDTO createProject(int branchId,ProjectRequestDTO request) {

		  Optional<Branch> byId = branchRepository.findById(branchId);
				 Branch branch=byId.get();

	        Project project = new Project();

	        project.setName(request.getName());
	        project.setDescription(request.getDescription());
	        project.setBranch(branch);

	        Project savedProject = projectRepository.save(project);

	        return new ProjectResponseDTO( savedProject.getId(),savedProject.getName(), savedProject.getDescription(),savedProject.getBranch().getId()
	        );
	    }
	 
	 public List<ProjectDTOResponseNative> getProjectByBranch(int branchId) {
		 return projectRepository.getAllByBranch(branchId);
	 }
	  public ProjectResponseDTO getProjectById( int  branchId,int projectId) {

	         Optional<Project> byId = projectRepository.findById(projectId);
	         Project project=byId.get();
	                

	        if (project.getBranch().getId()!=branchId) {
	            throw new RuntimeException(
	                    "Project does not belong to this branch");
	        }

	        return new ProjectResponseDTO( project.getId(),project.getName(), project.getDescription(), project.getBranch().getId() );
	    }
	  public ProjectResponseDTO updateProject( int branchId, int projectId,ProjectRequestDTO request) {

	         Optional<Project> byId = projectRepository.findById(projectId);
	         Project project = byId.get();
	                

	        if (project.getBranch().getId()!=branchId) {
	            throw new RuntimeException("Project does not belong to the branch");
	        }

	        project.setName(request.getName());
	        project.setDescription(request.getDescription());

	        Project updatedProject = projectRepository.save(project);

	        return new ProjectResponseDTO( updatedProject.getId(), updatedProject.getName(),updatedProject.getDescription(), updatedProject.getBranch().getId()
	        );
	    }
	  public void deleteProject(int branchId,int projectId) {

	         Optional<Project> byId = projectRepository.findById(projectId);
	         Project project  = byId.get();
	               

	        if (project.getBranch().getId()!=branchId) {
	            throw new RuntimeException("Project does not belong to the branch");
	        }

	        projectRepository.delete(project);
	    }


	  public ManagerProjectResponseDTO assignManager(int branchId, int projectId, int managerID) {
		Optional<Branch> byId = branchRepository.findById(branchId);
		Branch branch = byId.get();
		
		Optional<Project> byId2 = projectRepository.findById(projectId);
		Project project = byId2.get();
		if(project.getBranch().getId()!=branch.getId()) {
			throw new RuntimeException("Project is not of particular branch");
		}
		Optional<Manager> byId3 = managerRepository.findById(managerID);
		Manager manager = byId3.get();
		
		if(manager.getBranch().getId()!=branch.getId()) {
			throw new RuntimeException("Manager is not of particular branch");
		}
		project.getManagers().add(manager);
		manager.getProjects().add(project);
		managerRepository.save(manager);
		return new ManagerProjectResponseDTO(manager.getId(), manager.getName(),project.getId() , project.getName(), branch.getId(), branch.getName());
	  }

	  public ManagerProjectResponseDTO removeManagerFromProject(int branchId, int projectId, int managerId) {
		  Optional<Branch> byId = branchRepository.findById(branchId);
			Branch branch = byId.get();
			
			Optional<Project> byId2 = projectRepository.findById(projectId);
			Project project = byId2.get();
			if(project.getBranch().getId()!=branch.getId()) {
				throw new RuntimeException("Project is not of particular branch");
			}
			Optional<Manager> byId3 = managerRepository.findById(managerId);
			Manager manager = byId3.get();
			
			if(manager.getBranch().getId()!=branch.getId()) {
				throw new RuntimeException("Manager is not of particular branch");
			}
			project.getManagers().remove(manager);
			manager.getProjects().remove(project);
			managerRepository.save(manager);
			return new ManagerProjectResponseDTO(manager.getId(), manager.getName(),project.getId() , project.getName(), branch.getId(), branch.getName());
	  }

	
	  
	  public List<ProjectDTOResponseNative> getAllProject(){
		  return projectRepository.getAll();
	  }
	  
	 
	 

}
