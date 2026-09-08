package com.thinkitive.demo.dto.response;

public class EmployeeDTOResponseNative {

    private String name;
    private double salary;
    private int branchId;
    private int managerId;
    private String governmentId;

    public EmployeeDTOResponseNative(String name, double salary,
                                     int branchId, int managerId,
                                     String governmentId) {
        super();
        this.name = name;
        this.salary = salary;
        this.branchId = branchId;
        this.managerId = managerId;
        this.governmentId = governmentId;
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

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }
}