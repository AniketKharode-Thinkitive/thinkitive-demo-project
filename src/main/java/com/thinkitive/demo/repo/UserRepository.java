package com.thinkitive.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String Username);
	
	Optional<User> findByIamId(String iamId);

}
