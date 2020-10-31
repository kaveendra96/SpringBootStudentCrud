package com.itechro.assignmentspringboot.service.impl;

import com.itechro.assignmentspringboot.exceptions.StudentIdException;
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

    @Override
    public Student findStudentById(String studentId) {
        Student student=studentRepository.findById(Long.parseLong(studentId));
        if (student ==null){
            throw new StudentIdException("Student Id :"+studentId+"  does not exsist");
        }
        return student;

    }

    @Override
    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(String studentId) {
        Student student=studentRepository.findById(Long.parseLong(studentId));
        if (student==null){
            throw new StudentIdException("cannot find student with id :"+studentId+"  student does not exist ");
        }
        studentRepository.delete(student);
    }
}
