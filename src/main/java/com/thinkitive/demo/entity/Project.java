package com.thinkitive.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@ManyToOne
	private Branch branch;
	@ManyToMany(mappedBy = "projects")
	private List<Manager> managers =new ArrayList();
	@OneToMany(mappedBy = "project")
	private List<Employee> employees = new ArrayList<>();
    private String clientName;
    private String status;
    private String startDate;
    private String endDate;
    private double budget;
    private String technology;
    private String priority;
    private int teamSize;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String name, String description, Branch branch, List<Manager> managers,
			List<Employee> employees, String clientName, String status, String startDate,
			String endDate, double budget, String technology, String priority, int teamSize) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.branch = branch;
		this.managers = managers;
		this.employees = employees;
		this.clientName = clientName;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.technology = technology;
		this.priority = priority;
		this.teamSize = teamSize;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", branch=" + branch
				+ ", managers=" + managers + ", employees=" + employees + ", projectCode=" 
				+ ", clientName=" + clientName + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + ", budget=" + budget + ", technology=" + technology + ", priority=" + priority
				+ ", teamSize=" + teamSize + "]";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<Manager> getManagers() {
		return managers;
	}
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
    

}
