package com.thinkitive.demo.dto.request;

import com.thinkitive.demo.entity.Employee;
import com.thinkitive.demo.entity.Manager;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class UserDTORequest {
	
	 
	   

	    private String username;

	    private String password;

	    private String role;

	    
	    private Integer managerId;

	   
	    private Integer employeeId;
	    private String firstName;
	    private String lastName;
	    private String email;


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public UserDTORequest() {
			super();
			// TODO Auto-generated constructor stub
		}




		public UserDTORequest(String username, String password, String role, Integer managerId, Integer employeeId,
				String firstName, String lastName, String email) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
			this.managerId = managerId;
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		public Integer getManagerId() {
			return managerId;
		}


		public void setManagerId(Integer managerId) {
			this.managerId = managerId;
		}


		public Integer getEmployeeId() {
			return employeeId;
		}


		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}





}
