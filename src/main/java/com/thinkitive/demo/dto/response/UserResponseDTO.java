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
    private String name;
    private int salary;

    public UserResponseDTO(int id, String name) {
        this.id = id;
        this.name = name;
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

	
    
}