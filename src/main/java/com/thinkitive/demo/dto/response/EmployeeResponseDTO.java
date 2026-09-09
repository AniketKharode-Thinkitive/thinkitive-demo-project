package com.thinkitive.demo.dto.response;

public class EmployeeResponseDTO {

	private int id;
	private String name;
	private double salary;
	private int branchId;
	private int managerId;
	private int projectId;

	public EmployeeResponseDTO() {
		super();
	}

	public EmployeeResponseDTO(int id, String name, double salary, int branchId, int managerId, int projectId) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.branchId = branchId;
		this.managerId = managerId;
		this.projectId = projectId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}