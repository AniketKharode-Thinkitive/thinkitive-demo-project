package com.thinkitive.demo.dto.request;

public class ProjectRequestDTO {
	private String name;
	private String description;
    private String clientName;
    private String status;
    private String startDate;
    private String endDate;
    private double budget;
    private String technology;
    private String priority;
    private int teamSize;
	public ProjectRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectRequestDTO(String name, String description, String clientName, String status, String startDate,
			String endDate, double budget, String technology, String priority, int teamSize) {
		super();
		this.name = name;
		this.description = description;
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
		return "ProjectRequestDTO [name=" + name + ", description=" + description + ", clientName=" + clientName
				+ ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", budget=" + budget
				+ ", technology=" + technology + ", priority=" + priority + ", teamSize=" + teamSize + "]";
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
