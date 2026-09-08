package com.thinkitive.demo.dto.response;

public class ProjectDTOResponseNative {

    private String name;
    private String description;
    private int branchId;
    private String clientName;
    private String status;

    public ProjectDTOResponseNative(String name, String description,
                                    int branchId, String clientName,
                                    String status) {
        super();
        this.name = name;
        this.description = description;
        this.branchId = branchId;
        this.clientName = clientName;
        this.status = status;
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

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
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
}