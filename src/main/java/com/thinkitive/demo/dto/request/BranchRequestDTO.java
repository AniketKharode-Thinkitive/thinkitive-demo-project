package com.thinkitive.demo.dto.request;

public class BranchRequestDTO {
	private String name;
    private String email;
    private String contactNumber;
    private String location;
    private String openingTime;
    private String closingTime;
    private int floorNumber;
    private boolean parkingAvailable;
    private int establishedYear;
	public BranchRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BranchRequestDTO(String name, String email, String contactNumber, String location, String openingTime,
			String closingTime, int floorNumber, boolean parkingAvailable, int establishedYear) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.location = location;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.floorNumber = floorNumber;
		this.parkingAvailable = parkingAvailable;
		this.establishedYear = establishedYear;
	}
	@Override
	public String toString() {
		return "BranchRequestDTO [name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", location=" + location + ", openingTime=" + openingTime + ", closingTime=" + closingTime
				+ ", floorNumber=" + floorNumber + ", parkingAvailable=" + parkingAvailable + ", establishedYear="
				+ establishedYear + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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