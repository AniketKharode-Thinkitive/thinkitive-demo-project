package com.thinkitive.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thinkitive.demo.dto.response.ManagerDTOResponseNative;
import com.thinkitive.demo.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	@Query(value = "SELECT name, branch_id, email, government_id FROM manager", nativeQuery = true)
    List<ManagerDTOResponseNative> getAll();
	
	  @Query(value = "SELECT name, branch_id, email, government_id FROM manager WHERE branch_id = :bid", nativeQuery = true)
	    List<ManagerDTOResponseNative> getAllByBranch(@Param("bid") int bid);
	  
	
}
