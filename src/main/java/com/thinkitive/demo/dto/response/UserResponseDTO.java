package com.thinkitive.demo.dto.response;

import com.thinkitive.demo.entity.Employee;
import com.thinkitive.demo.entity.Manager;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class UserResponseDTO {
	
	    private int id;

	    private String username;

	    private String role;

	    private Manager manager;

	    
	    private Employee employee;


	


		public UserResponseDTO(int id, String username, String role, Manager manager, Employee employee) {
			super();
			this.id = id;
			this.username = username;
			this.role = role;
			this.manager = manager;
			this.employee = employee;
		}


		@Override
		public String toString() {
			return "UserResponseDTO [id=" + id + ", username=" + username + ", role=" + role + ", manager=" + manager
					+ ", employee=" + employee + "]";
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		public Manager getManager() {
			return manager;
		}


		public void setManager(Manager manager) {
			this.manager = manager;
		}


		public Employee getEmployee() {
			return employee;
		}


		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
	    
	    
		

}
