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

import com.thinkitive.demo.dto.request.ManagerProjectRequestDTO;
import com.thinkitive.demo.dto.request.ProjectRequestDTO;
import com.thinkitive.demo.dto.response.ManagerDTOResponseNative;
import com.thinkitive.demo.dto.response.ManagerProjectResponseDTO;
import com.thinkitive.demo.dto.response.ManagerResponseDTIO;
import com.thinkitive.demo.dto.response.ProjectDTOResponseNative;
import com.thinkitive.demo.dto.response.ProjectResponseDTO;
import com.thinkitive.demo.service.ProjectServiceImpl;

@RestController
@RequestMapping("/api/branches/{branchId}/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping
    public ProjectResponseDTO createProject(@PathVariable int branchId,@RequestBody ProjectRequestDTO request) {

        return projectService.createProject( branchId, request);
    }

    @GetMapping
    public List<ProjectDTOResponseNative> getProjectsByBranch( @PathVariable int branchId) {

        return projectService.getProjectByBranch(branchId);
    }

    @GetMapping("/{projectId}")
    public ProjectResponseDTO getProjectById(@PathVariable int branchId,@PathVariable int projectId) {

        return projectService.getProjectById( branchId, projectId);
    }

    @PutMapping("/{projectId}")
    public ProjectResponseDTO updateProject(
            @PathVariable int branchId,@PathVariable int projectId, @RequestBody ProjectRequestDTO request) {

        return projectService.updateProject(branchId, projectId, request);
    }

    @DeleteMapping("/{projectId}")
    public String deleteProject(@PathVariable int branchId,@PathVariable int projectId) {

        projectService.deleteProject(branchId, projectId);

        return "Project deleted successfully";
    }
    @PostMapping("/{projectId}/managers/{managerID}")
    public ManagerProjectResponseDTO giveManagerToProject(@PathVariable int branchId ,@PathVariable int projectId,@PathVariable int managerID ) {
    		ManagerProjectResponseDTO assignManager = projectService.assignManager(branchId,projectId,managerID);
    		return assignManager;
    }
    
	@DeleteMapping("/{projectId}/managers/{managerId}")
	public ManagerProjectResponseDTO removeManagerFromProject(@PathVariable int branchId, @PathVariable int projectId,@PathVariable int managerId) {

		return projectService.removeManagerFromProject(branchId, projectId, managerId);
	}

	
	
	
}