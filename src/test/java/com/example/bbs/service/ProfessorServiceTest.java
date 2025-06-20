package com.example.bbs.service;

import com.example.bbs.domain.Department;
import com.example.bbs.domain.Professor;
import com.example.bbs.repository.DepartmentRepository;
import com.example.bbs.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProfessorServiceTest {

    @Autowired
    ProfessorService professorService;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ProfessorRepository professorRepository;

    @BeforeEach
    void initData() {
        Department department = departmentRepository.save(new Department(null, "department_name_1"));
        professorRepository.save(new Professor(null, "professor_name_1", department));
        professorRepository.save(new Professor(null, "professor_name_2", department));
    }

    @Test
    @Transactional
    void getDepartmentById() {
        // given
        Department department1 = new Department(null, "department_name_1");
        Department saved1 = departmentRepository.save(department1);
        Department department2 = new Department(null, "department_name_2");
        Department saved2 = departmentRepository.save(department2);
        // when
        Department department = professorService.getDepartmentById(saved1.getId());
        // then
        Assertions.assertThat(department.getId()).isEqualTo(saved1.getId());
    }

    @Test
    void getProfessorById() {
        // given
        Professor professor1 = professorRepository.findByName("professor_name_1").orElseThrow();
        // when
        Professor findProfessor = professorService.getProfessorById(professor1.getId());
        System.out.println("findProfessor = " + findProfessor);
        // then
        Assertions.assertThat(findProfessor.getId()).isEqualTo(professor1.getId());
    }

}