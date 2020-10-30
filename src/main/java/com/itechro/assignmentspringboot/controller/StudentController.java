package com.itechro.assignmentspringboot.controller;

import com.itechro.assignmentspringboot.model.Student;
import com.itechro.assignmentspringboot.service.MapValidationErrorService;
import com.itechro.assignmentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    //create student
    @PostMapping("")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult result){

        ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
        if(errorMap!=null)
            return errorMap;

        Student studentNew=studentService.saveOrUpdateStudent(student);
        return new ResponseEntity<Student>(studentNew, HttpStatus.CREATED);
    }
}
