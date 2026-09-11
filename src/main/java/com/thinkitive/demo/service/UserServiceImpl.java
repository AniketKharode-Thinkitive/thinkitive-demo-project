package com.thinkitive.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.UserDTORequest;
import com.thinkitive.demo.dto.response.UserResponseDTO;
import com.thinkitive.demo.entity.Employee;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.entity.User;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.repo.EmployeeRepository;
import com.thinkitive.demo.repo.ManagerRepository;
import com.thinkitive.demo.repo.UserRepository;
import com.thinkitive.demo.security.KeycloakAdminService;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private KeycloakAdminService keycloakAdminService;

	public UserResponseDTO create(UserDTORequest request) {

		Manager manager = null;
		Employee employee = null;

		if (request.getRole().equals("MANAGER")) {

			manager = managerRepository.findById(request.getManagerId())
					.orElseThrow(() -> new ResourceNotFoundException("Manager Does Not Exist"));
		}

		if (request.getRole().equals("EMPLOYEE")) {

			employee = employeeRepository.findById(request.getEmployeeId())
					.orElseThrow(() -> new ResourceNotFoundException("Employee Does Not Exist"));
		}

		String iamId = keycloakAdminService.createUser(request.getUsername(), request.getPassword(),
				request.getFirstName(), request.getLastName(), request.getEmail());

		keycloakAdminService.assignRealmRole(iamId, request.getRole());

		User user = new User();

		user.setUsername(request.getUsername());

		user.setRole(request.getRole());

		user.setIamId(iamId);

		if (manager != null) {
			user.setManager(manager);
		}

		if (employee != null) {
			user.setEmployee(employee);
		}

		User savedUser = userRepository.save(user);

		return new UserResponseDTO(savedUser.getId(), savedUser.getUsername())
				;
	}

	public User getLoggedInUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Jwt jwt = (Jwt) authentication.getPrincipal();

		String iamId = jwt.getSubject();

		User user = userRepository.findByIamId(iamId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		return user;
	}
}