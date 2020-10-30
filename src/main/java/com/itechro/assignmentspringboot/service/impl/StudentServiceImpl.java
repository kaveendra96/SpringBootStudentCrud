package com.itechro.assignmentspringboot.service.impl;

import com.itechro.assignmentspringboot.model.Student;
import com.itechro.assignmentspringboot.repository.StudentRepository;
import com.itechro.assignmentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveOrUpdateStudent(Student student) {
            return studentRepository.save(student);
    }
}
