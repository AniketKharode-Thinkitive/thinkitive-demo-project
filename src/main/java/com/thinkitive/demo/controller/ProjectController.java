package com.thinkitive.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.ProjectRequestDTO;
import com.thinkitive.demo.dto.response.ManagerProjectResponseDTO;
import com.thinkitive.demo.dto.response.ProjectDTOResponseNative;
import com.thinkitive.demo.dto.response.ProjectResponseDTO;
import com.thinkitive.demo.dto.response.StandardResponse;
import com.thinkitive.demo.service.ProjectServiceImpl;
import com.thinkitive.demo.util.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/branches/{branchId}/projects")
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectService;

	@PostMapping
	public ResponseEntity<StandardResponse> createProject(@PathVariable int branchId,
			@RequestBody ProjectRequestDTO request, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		projectService.createProject(branchId, request);

		StandardResponse response = StandardResponse.suceess(requestId, "Project Created Successfully",
				ResponseStatus.CREATED, path);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<StandardResponse> getProjectsByBranch(@PathVariable int branchId,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		List<ProjectDTOResponseNative> projects = projectService.getProjectByBranch(branchId);

		StandardResponse response = StandardResponse.data(requestId, "Projects Fetched Successfully", projects,
				ResponseStatus.FETCHED, path);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<StandardResponse> getProjectById(@PathVariable int branchId, @PathVariable int projectId,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		ProjectResponseDTO project = projectService.getProjectById(branchId, projectId);

		StandardResponse response = StandardResponse.data(requestId, "Project Fetched Successfully", project,
				ResponseStatus.FETCHED, path);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{projectId}")
	public ResponseEntity<StandardResponse> updateProject(@PathVariable int branchId, @PathVariable int projectId,
			@RequestBody ProjectRequestDTO request, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		ProjectResponseDTO updatedProject = projectService.updateProject(branchId, projectId, request);

		StandardResponse response = StandardResponse.data(requestId, "Project Data Updated Successfully",
				updatedProject, ResponseStatus.UPDATED, path);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<StandardResponse> deleteProject(@PathVariable int branchId, @PathVariable int projectId,
			HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		projectService.deleteProject(branchId, projectId);

		StandardResponse response = StandardResponse.suceess(requestId, "Project Deleted Successfully",
				ResponseStatus.DELETED, path);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/{projectId}/managers/{managerID}")
	public ResponseEntity<StandardResponse> giveManagerToProject(@PathVariable int branchId,
			@PathVariable int projectId, @PathVariable int managerID, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		ManagerProjectResponseDTO assignManager = projectService.assignManager(branchId, projectId, managerID);

		StandardResponse response = StandardResponse.data(requestId, "Manager Assigned To Project Successfully",
				assignManager, ResponseStatus.UPDATED, path);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{projectId}/managers/{managerId}")
	public ResponseEntity<StandardResponse> removeManagerFromProject(@PathVariable int branchId,
			@PathVariable int projectId, @PathVariable int managerId, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();

		ManagerProjectResponseDTO removedManager = projectService.removeManagerFromProject(branchId, projectId,
				managerId);

		StandardResponse response = StandardResponse.data(requestId, "Manager Removed From Project Successfully",
				removedManager, ResponseStatus.UPDATED, path);

		return ResponseEntity.ok(response);
	}
}