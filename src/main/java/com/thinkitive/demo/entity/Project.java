package com.thinkitive.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@ManyToOne
	private Branch branch;
	@ManyToMany
	private List<Manager> managers;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String name, String description, Branch branch) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", branch=" + branch + "]";
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

}
