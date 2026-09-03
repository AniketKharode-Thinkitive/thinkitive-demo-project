package com.thinkitive.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.demo.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
