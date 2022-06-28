package com.shaker.springboottutorial.service;

import com.shaker.springboottutorial.entity.Department;
import com.shaker.springboottutorial.error.DepartmentNotFoundException;


import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
