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
    private String contactNumber;
    private String email;
    private String openingTime;
    private String closingTime;
    private int floorNumber;
    private boolean parkingAvailable;
    private int establishedYear;
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(int id, String name, String location, List<Employee> employees, String contactNumber, String email,
			String openingTime, String closingTime, int floorNumber, boolean parkingAvailable, int establishedYear) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.employees = employees;
		this.contactNumber = contactNumber;
		this.email = email;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.floorNumber = floorNumber;
		this.parkingAvailable = parkingAvailable;
		this.establishedYear = establishedYear;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", location=" + location + ", employees=" + employees
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", openingTime=" + openingTime
				+ ", closingTime=" + closingTime + ", floorNumber=" + floorNumber + ", parkingAvailable="
				+ parkingAvailable + ", establishedYear=" + establishedYear + "]";
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
		this.location = location;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	public String getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public boolean isParkingAvailable() {
		return parkingAvailable;
	}
	public void setParkingAvailable(boolean parkingAvailable) {
		this.parkingAvailable = parkingAvailable;
	}
	public int getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}
    


}
