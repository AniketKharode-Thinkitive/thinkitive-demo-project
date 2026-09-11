package com.thinkitive.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String username;

	    private String password;

	    private String role;
	    private String iamId;
	    @OneToOne
	    @JoinColumn(name = "manager_id")
	    private Manager manager;

	    @OneToOne
	    @JoinColumn(name = "employee_id")
	    private Employee employee;

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
					+ ", iamId=" + iamId + ", manager=" + manager + ", employee=" + employee + "]";
		}


		public User(int id, String username, String password, String role, String iamId, Manager manager,
				Employee employee) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;
			this.iamId = iamId;
			this.manager = manager;
			this.employee = employee;
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

		public String getIamId() {
			return iamId;
		}

		public void setIamId(String iamId) {
			this.iamId = iamId;
		}

		


}
