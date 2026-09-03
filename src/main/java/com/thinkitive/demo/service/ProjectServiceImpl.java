package com.thinkitive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.ProjectRequestDTO;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
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
	private ProjectRepository projectRepository;
	@Autowired
	private BranchRepository branchRepository;
	
	 public ProjectResponseDTO createProject(
	            int branchId,
	            ProjectRequestDTO request) {

		  Optional<Branch> byId = branchRepository.findById(branchId);
				 Branch branch=byId.get();

	        Project project = new Project();

	        project.setName(request.getName());
	        project.setDescription(request.getDescription());
	        project.setBranch(branch);

	        Project savedProject = projectRepository.save(project);

	        return new ProjectResponseDTO(
	                savedProject.getId(),
	                savedProject.getName(),
	                savedProject.getDescription(),
	                savedProject.getBranch().getId()
	        );
	    }
	 
	 public List<ProjectResponseDTO> getProjectByBranch(int branchId) {
		 List<Project> projects = projectRepository.findAll();

	        List<ProjectResponseDTO> responseList = new ArrayList();

	        for (Project project : projects) {

	            if (project.getBranch().getId()==(branchId)) {

	                ProjectResponseDTO response =
	                        new ProjectResponseDTO(
	                                project.getId(),
	                                project.getName(),
	                                project.getDescription(),
	                                project.getBranch().getId()
	                        );

	                responseList.add(response);
	            }
	 }
	        return responseList;
	 }
	  public ProjectResponseDTO getProjectById(
	            int  branchId,
	            int projectId) {

	         Optional<Project> byId = projectRepository.findById(projectId);
	         Project project=byId.get();
	                

	        if (project.getBranch().getId()==branchId) {
	            throw new RuntimeException(
	                    "Project does not belong to this branch");
	        }

	        return new ProjectResponseDTO(
	                project.getId(),
	                project.getName(),
	                project.getDescription(),
	                project.getBranch().getId()
	        );
	    }
	  public ProjectResponseDTO updateProject(
	            int branchId,
	            int projectId,
	            ProjectRequestDTO request) {

	         Optional<Project> byId = projectRepository.findById(projectId);
	         Project project = byId.get();
	                

	        if (project.getBranch().getId()==branchId) {
	            throw new RuntimeException(
	                    "Project does not belong to the branch");
	        }

	        project.setName(request.getName());
	        project.setDescription(request.getDescription());

	        Project updatedProject = projectRepository.save(project);

	        return new ProjectResponseDTO(
	                updatedProject.getId(),
	                updatedProject.getName(),
	                updatedProject.getDescription(),
	                updatedProject.getBranch().getId()
	        );
	    }
	  public void deleteProject(
	            int branchId,
	            int projectId) {

	         Optional<Project> byId = projectRepository.findById(projectId);
	         Project project  = byId.get();
	               

	        if (project.getBranch().getId()==branchId) {
	            throw new RuntimeException(
	                    "Project does not belong to the branch");
	        }

	        projectRepository.delete(project);
	    }
	 
	 

}
