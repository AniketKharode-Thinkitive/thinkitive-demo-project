package com.thinkitive.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double salary;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String contactNumber;
    private String governmentId;
    private String email;
    private String address;
    private String city;
    private String dateOfJoining;
    private int experienceYears;
    private String gender;
    private String qualification;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, double salary, Branch branch, Manager manager, Project project,
			String contactNumber, String governmentId, String email, String address, String city, String dateOfJoining,
			int experienceYears, String gender, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.branch = branch;
		this.manager = manager;
		this.project = project;
		this.contactNumber = contactNumber;
		this.governmentId = governmentId;
		this.email = email;
		this.address = address;
		this.city = city;
		this.dateOfJoining = dateOfJoining;
		this.experienceYears = experienceYears;
		this.gender = gender;
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", branch=" + branch + ", manager="
				+ manager + ", project=" + project + ", contactNumber=" + contactNumber + ", governmentId="
				+ governmentId + ", email=" + email + ", address=" + address + ", city=" + city + ", dateOfJoining="
				+ dateOfJoining + ", experienceYears=" + experienceYears + ", gender=" + gender + ", qualification="
				+ qualification + "]";
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
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
	public int getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
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