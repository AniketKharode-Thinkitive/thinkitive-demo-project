package com.thinkitive.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thinkitive.demo.dto.response.EmployeeDTOResponseNative;
import com.thinkitive.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT name, salary, branch_id, manager_id, government_id FROM employee", nativeQuery = true)
	List<EmployeeDTOResponseNative> getAll();
	
	 @Query(value = "SELECT name, salary, branch_id, manager_id, government_id FROM employee WHERE branch_id = :bid ", nativeQuery = true)
	    List<EmployeeDTOResponseNative> getAllByBranch(@Param("bid") int bid);

		@Query(value = "SELECT name, salary, branch_id, manager_id, government_id " + "FROM employee "
				+ "WHERE project_id = :projectId " + "AND branch_id = :branchId", nativeQuery = true)
		List<EmployeeDTOResponseNative> getEmployeesByProject(@Param("branchId") int branchId,
				@Param("projectId") int projectId);

	    @Query(value = "SELECT name, salary, branch_id, manager_id, government_id FROM employee WHERE manager_id = :mid AND branch_id = :bid", nativeQuery = true)
	    List<EmployeeDTOResponseNative> getEmployeesByManager(@Param("bid")int bid, @Param("mid") int mid);

		@Query(value = "SELECT name, salary, branch_id, manager_id, government_id FROM employee WHERE id = :employeeId AND branch_id = :branchId", nativeQuery = true)
		EmployeeDTOResponseNative getById(@Param("branchId") int branchId, @Param("employeeId") int employeeId);
	    
}
