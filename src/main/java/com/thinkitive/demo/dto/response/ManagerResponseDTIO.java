package com.thinkitive.demo.dto.response;

import com.thinkitive.demo.entity.Branch;

public class ManagerResponseDTIO {
	 private int id;

	  private String name;
	    
	

	  private int branchId;


	  public ManagerResponseDTIO(int id, String name, int branchId) {
		super();
		this.id = id;
		this.name = name;
		this.branchId = branchId;
	  }

	  @Override
	  public String toString() {
		return "ManagerResponseDTIO [id=" + id + ", name=" + name +  ", branchId=" + branchId + "]";
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



	  public int getBranchId() {
		  return branchId;
	  }

	  public void setBranchId(int branchId) {
		  this.branchId = branchId;
	  }
	  
	  
}
