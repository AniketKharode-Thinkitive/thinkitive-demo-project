package com.thinkitive.demo.dto.request;

public class EmployeeDTORequest {

    private String name;
    private double salary;
    private int managerId;
    private int projectId;

    public EmployeeDTORequest() {
        super();
    }

    public EmployeeDTORequest(String name, double salary,
                              int managerId, int projectId) {
        this.name = name;
        this.salary = salary;
        this.managerId = managerId;
        this.projectId = projectId;
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