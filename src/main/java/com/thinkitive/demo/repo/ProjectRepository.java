package com.thinkitive.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thinkitive.demo.dto.response.ProjectDTOResponseNative;
import com.thinkitive.demo.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	  @Query(value = "SELECT name, description, branch_id, client_name, status FROM project", nativeQuery = true)
	    List<ProjectDTOResponseNative> getAll();
	  
	  @Query(value = "SELECT name, description, branch_id, client_name, status FROM project WHERE branch_id = :bid", nativeQuery = true)
	    List<ProjectDTOResponseNative> getAllByBranch(@Param ("bid") int bid);
	  
	  
}
