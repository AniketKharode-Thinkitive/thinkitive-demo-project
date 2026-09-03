package com.thinkitive.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.demo.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
