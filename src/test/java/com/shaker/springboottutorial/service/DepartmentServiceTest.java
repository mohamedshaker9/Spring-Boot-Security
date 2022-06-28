package com.shaker.springboottutorial.service;

import com.shaker.springboottutorial.entity.Department;
import com.shaker.springboottutorial.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .name("ITS")
                        .address("Egypt")
                        .code("IT-02")
                        .id(1L)
                        .build();
    System.out.println(department.toString());
        Mockito.when(departmentRepo.findByNameIgnoreCase("ITS"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Department By Name")
    public void whenValidDepartmentName_thenDepartNameShouldFound() {
        String departmentName = "ITS";
        Department departmentFound = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentFound.getName(), departmentName);
    }
}