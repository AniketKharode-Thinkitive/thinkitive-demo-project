package com.thinkitive.demo.dto.response;

public class ProjectResponseDTO {
	
	  	private int id;
	    private String name;
	    private String description;
	    private int branchId;
		public ProjectResponseDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProjectResponseDTO(int id, String name, String description, int branchId) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.branchId = branchId;
		}
		@Override
		public String toString() {
			return "ProjectResponseDTO [id=" + id + ", name=" + name + ", description=" + description + ", branchId="
					+ branchId + "]";
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
		public int getBranchId() {
			return branchId;
		}
		public void setBranchId(int branchId) {
			this.branchId = branchId;
		}
	    
	    

}
