package com.itechro.assignmentspringboot.repository;

import com.itechro.assignmentspringboot.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
    Student findById(long id);
    Iterable<Student> findAll();
}
