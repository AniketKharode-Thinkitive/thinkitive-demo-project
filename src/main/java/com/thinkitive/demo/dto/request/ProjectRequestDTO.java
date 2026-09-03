package com.thinkitive.demo.dto.request;

public class ProjectRequestDTO {
	private String name;
	private String description;
	public ProjectRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectRequestDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProjectRequestDTO [name=" + name + ", description=" + description + "]";
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
	
	
}
