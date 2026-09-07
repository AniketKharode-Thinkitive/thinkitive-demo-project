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

	    
	    private int managerId;

	   
	    private int employeeId;


		public UserDTORequest() {
			super();
			// TODO Auto-generated constructor stub
		}




		public UserDTORequest( String username, String password, String role, int managerId, int employeeId) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
			this.managerId = managerId;
			this.employeeId = employeeId;
		}




		@Override
		public String toString() {
			return "UserDTORequest [ username=" + username + ", password=" + password + ", role=" + role
					+ ", managerId=" + managerId + ", employeeId=" + employeeId + "]";
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




		public int getManagerId() {
			return managerId;
		}




		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}




		public int getEmployeeId() {
			return employeeId;
		}




		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}


	
	    
	    
		
		

}
