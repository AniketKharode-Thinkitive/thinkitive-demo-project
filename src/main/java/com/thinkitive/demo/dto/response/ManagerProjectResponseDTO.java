package com.thinkitive.demo.dto.response;

public class ManagerProjectResponseDTO {

    private int managerId;
    private String managerName;

    private int projectId;
    private String projectName;

    private int branchId;
    private String branchName;


    public ManagerProjectResponseDTO() {
    }

	public ManagerProjectResponseDTO(int managerId, String managerName, int projectId, String projectName, int branchId,
			String branchName) {

        this.managerId = managerId;
        this.managerName = managerName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

}