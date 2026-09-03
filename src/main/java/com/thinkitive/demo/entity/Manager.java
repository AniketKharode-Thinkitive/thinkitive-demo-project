package com.thinkitive.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Branch branch;
	@ManyToMany
	private List<Project> projects;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int id, String name, Branch branch) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", branch=" + branch + "]";
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
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public List<Project> getProjects() {
	    return projects;
	}

	public void setProjects(List<Project> projects) {
	    this.projects = projects;
	}

}
