package com.shaker.springboottutorial.repository;


import com.shaker.springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

   public Department findByName(String departmentName);
   public Department findByNameIgnoreCase(String departmentName);
}
