package com.shaker.springboottutorial.repository;

import com.shaker.springboottutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepoTest {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .name("ME")
                        .address("Alex")
                        .code("ME - 01")
                        .build();

        Department department1 =
                Department.builder()
                        .name("EL")
                        .address("Alex")
                        .code("EL - 02")
                        .build();
        entityManager.persist(department);
        entityManager.persist(department1);


    }

    @Test
    public void whenFoundById_thenReturnDepartment(){
        Department department = departmentRepo.findById(2L).get();
        assertEquals("EL", department.getName());

    }
}