package com.thinkitive.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	@JoinTable(name = "manager_projects",joinColumns = @JoinColumn(name = "manager_id"),
		    inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects=new ArrayList();
	@OneToMany(mappedBy = "manager")
	private List<Employee> employees = new ArrayList<>();
	 
    private String contactNumber;
    private String governmentId;
    private String email;
    private String address;
    private String city;
    private String dateOfJoining;
    private String designation;
    private String gender;
    private String qualification;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int id, String name, Branch branch, List<Project> projects, List<Employee> employees,
			String contactNumber, String governmentId, String email, String address, String city, String dateOfJoining,
			String designation, String gender, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.projects = projects;
		this.employees = employees;
		this.contactNumber = contactNumber;
		this.governmentId = governmentId;
		this.email = email;
		this.address = address;
		this.city = city;
		this.dateOfJoining = dateOfJoining;
		this.designation = designation;
		this.gender = gender;
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", branch=" + branch + ", projects=" + projects + ", employees="
				+ employees + ", contactNumber=" + contactNumber + ", governmentId=" + governmentId + ", email=" + email
				+ ", address=" + address + ", city=" + city + ", dateOfJoining=" + dateOfJoining + ", designation="
				+ designation + ", gender=" + gender + ", qualification=" + qualification + "]";
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
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getGovernmentId() {
		return governmentId;
	}
	public void setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
    
}
