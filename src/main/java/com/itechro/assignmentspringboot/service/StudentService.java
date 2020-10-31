package com.itechro.assignmentspringboot.service;

import com.itechro.assignmentspringboot.model.Student;


public interface StudentService {
    public Student saveOrUpdateStudent(Student student);

    Student findStudentById(String studentId);

    Iterable<Student> findAllStudents();

    void deleteStudentById(String studentId);
}
