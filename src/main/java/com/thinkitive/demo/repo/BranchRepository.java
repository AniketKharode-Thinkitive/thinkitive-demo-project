package com.thinkitive.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thinkitive.demo.dto.response.BranchDTOResponseNative;
import com.thinkitive.demo.entity.Branch;


@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
	@Query(value = "SELECT name, email, contact_number, location FROM branch", nativeQuery = true)
	List<BranchDTOResponseNative> getAll();
}
