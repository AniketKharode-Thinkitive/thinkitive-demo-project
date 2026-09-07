package com.thinkitive.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.dto.request.UserDTORequest;
import com.thinkitive.demo.dto.response.UserResponseDTO;
import com.thinkitive.demo.entity.Employee;
import com.thinkitive.demo.entity.Manager;
import com.thinkitive.demo.entity.User;
import com.thinkitive.demo.repo.EmployeeRepository;
import com.thinkitive.demo.repo.ManagerRepository;
import com.thinkitive.demo.repo.UserRepository;

@Service
public class UserServiceImpl {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ManagerRepository managerRepository;

	    @Autowired
	    private EmployeeRepository employeeRepository;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    	
	    public UserResponseDTO create(UserDTORequest request) {

	        User user = new User();

	        user.setUsername(request.getUsername());

	        user.setPassword(
	                passwordEncoder.encode(request.getPassword())
	        );

	        user.setRole(request.getRole());

	        if (request.getRole().equals("MANAGER")) {

	            Optional<Manager> byId = managerRepository.findById(request.getManagerId());

	            Manager manager = byId.get();
	            user.setManager(manager);
	        }

	        if (request.getRole().equals("EMPLOYEE")) {

	            Optional<Employee> byId =
	                    employeeRepository.findById(request.getEmployeeId());

	            Employee employee = byId.get();

	            user.setEmployee(employee);
	        }

	        User save = userRepository.save(user);

	        int managerId = 0;

	        int employeeId = 0;

	        if (save.getManager() != null) {
	            managerId = save.getManager().getId();
	        }

	        if (save.getEmployee() != null) {
	            employeeId = save.getEmployee().getId();
	        }

			return new UserResponseDTO(save.getId(),save.getUsername(),save.getRole(),save.getManager(),save.getEmployee() );
	    }
	    public User getLoggedInUser() {

	        Authentication authentication =
	                SecurityContextHolder.getContext().getAuthentication();

	        String username = authentication.getName();

	        Optional<User> byUsername =
	                userRepository.findByUsername(username);

	        if (byUsername.isEmpty()) {
	            throw new RuntimeException("User not found");
	        }

	        return byUsername.get();
	    }

	    
}
