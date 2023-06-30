package com.ust.DepartmentService.Repo;

import com.ust.DepartmentService.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

  Optional<Department> findBydepartmentId(long departmentId);
}
