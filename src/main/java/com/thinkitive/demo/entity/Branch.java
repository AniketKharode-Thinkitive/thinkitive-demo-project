package com.thinkitive.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	@OneToMany(mappedBy = "branch")
	private List<Employee> employees = new ArrayList();
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", location=" + location + "]";
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
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location=location;
		
	}
	public List<Employee> getEmployees() {
	    return employees;
	}

	public void setEmployees(List<Employee> employees) {
	    this.employees = employees;
	}
	

}
