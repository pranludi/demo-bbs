package com.example.bbs.service;

import com.example.bbs.domain.Department;
import com.example.bbs.domain.Professor;
import com.example.bbs.repository.DepartmentRepository;
import com.example.bbs.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final DepartmentRepository departmentRepository;

    public ProfessorService(DepartmentRepository departmentRepository, ProfessorRepository professorRepository) {
        this.departmentRepository = departmentRepository;
        this.professorRepository = professorRepository;
    }

    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    public Professor getProfessorById(long id) {
        return professorRepository.findById(id).orElseThrow();
    }
}
