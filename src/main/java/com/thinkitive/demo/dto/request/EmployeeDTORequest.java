package com.thinkitive.demo.dto.request;

public class EmployeeDTORequest {

    private String name;
    private double salary;
    private int managerId;
    private int projectId;
    private String lastName;
    private String contactNumber;
    private String governmentId;
    private String email;
    private String address;
    private String city;
    private String dateOfJoining;
    private String designation;
    private String gender;
    private String qualification;
	public EmployeeDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTORequest(String name, double salary, int managerId, int projectId, String lastName,
			String contactNumber, String governmentId, String email, String address, String city, String dateOfJoining,
			String designation, String gender, String qualification) {
		super();
		this.name = name;
		this.salary = salary;
		this.managerId = managerId;
		this.projectId = projectId;
		this.lastName = lastName;
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
		return "EmployeeDTORequest [name=" + name + ", salary=" + salary + ", managerId=" + managerId + ", projectId="
				+ projectId + ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", governmentId="
				+ governmentId + ", email=" + email + ", address=" + address + ", city=" + city + ", dateOfJoining="
				+ dateOfJoining + ", designation=" + designation + ", gender=" + gender + ", qualification="
				+ qualification + "]";
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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