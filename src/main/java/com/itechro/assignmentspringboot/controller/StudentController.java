package com.itechro.assignmentspringboot.controller;

import com.itechro.assignmentspringboot.model.Student;
import com.itechro.assignmentspringboot.service.MapValidationErrorService;
import com.itechro.assignmentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    //create student and update student
    @PostMapping("")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult result){

        ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
        if(errorMap!=null)
            return errorMap;

        Student studentNew=studentService.saveOrUpdateStudent(student);
        return new ResponseEntity<Student>(studentNew, HttpStatus.CREATED);
    }
    //Get student
    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable String studentId){
        Student student=studentService.findStudentById(studentId);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }
    //get all student
    @GetMapping("/all")
    public Iterable<Student> getAllStudents(){
        return studentService.findAllStudents();
    }
    //delete given student
    @GetMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteProject(@PathVariable String studentId){
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<String>("Student id :"+studentId+" was deleted",HttpStatus.OK);
    }
}
