package com.shaker.springboottutorial.service;


import com.shaker.springboottutorial.entity.Department;
import com.shaker.springboottutorial.error.DepartmentNotFoundException;
import com.shaker.springboottutorial.repository.DepartmentRepo;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(Department department){
         return departmentRepo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepo.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = departmentRepo.findById(departmentId);
        if(!departmentOptional.isPresent()){
            throw new DepartmentNotFoundException("NO Department with this ID");
        }
        return departmentOptional.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
         departmentRepo.deleteById(departmentId);
         return "Deraptment Deleted Successfully";
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDB = departmentRepo.getById(departmentId);

        if(Objects.nonNull(department.getName()) &&
                !"".equalsIgnoreCase(department.getName())){
            departmentDB.setName(department.getName());
        }

        if(Objects.nonNull(department.getAddress()) &&
                !"".equalsIgnoreCase(department.getAddress())){
            departmentDB.setAddress(department.getAddress());
        }

        if(Objects.nonNull(department.getCode()) &&
                !"".equalsIgnoreCase(department.getCode())){
            departmentDB.setCode(department.getCode());
        }

        return departmentRepo.save(departmentDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepo.findByNameIgnoreCase(departmentName);
    }


}
