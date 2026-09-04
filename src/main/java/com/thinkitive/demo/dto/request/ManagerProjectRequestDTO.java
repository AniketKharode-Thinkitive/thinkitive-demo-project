package com.thinkitive.demo.dto.request;

public class ManagerProjectRequestDTO {

	private int branchId;
	private int projectId;
	private int managerId;

	public ManagerProjectRequestDTO() {
	}

	public ManagerProjectRequestDTO(int branchId, int projectId, int managerId) {

		this.branchId = branchId;
		this.projectId = projectId;
		this.managerId = managerId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}