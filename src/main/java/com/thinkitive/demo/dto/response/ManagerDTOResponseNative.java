package com.thinkitive.demo.dto.response;

public class ManagerDTOResponseNative {

    private String name;
    private int branchId;
    private String email;
    private String governmentId;

    public ManagerDTOResponseNative(String name, int branchId,
                                    String email, String governmentId) {
        super();
        this.name = name;
        this.branchId = branchId;
        this.email = email;
        this.governmentId = governmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }
}