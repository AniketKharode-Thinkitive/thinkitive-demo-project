package com.thinkitive.demo.dto.request;

public class ManagerRequestDTO {

    private String name;
    private String lastName;
    private String contactNumber;
    private String governmentId;
    private String email;
    private String address;
    private String city;
    private String dateOfJoining;
    private int experienceYears;
    private String gender;
    private String qualification;
	public ManagerRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerRequestDTO(String name, String lastName, String contactNumber, String governmentId, String email,
			String address, String city, String dateOfJoining, int experienceYears, String gender,
			String qualification) {
		super();
		this.name = name;
		this.lastName = lastName;
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
		return "ManagerRequestDTO [name=" + name + ", lastName=" + lastName + ", contactNumber=" + contactNumber
				+ ", governmentId=" + governmentId + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", dateOfJoining=" + dateOfJoining + ", experienceYears=" + experienceYears + ", gender=" + gender
				+ ", qualification=" + qualification + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
