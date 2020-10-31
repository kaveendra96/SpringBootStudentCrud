package com.itechro.assignmentspringboot.exceptions;

public class StudentIdExceptionResponse {
    private String studentId;

    public StudentIdExceptionResponse(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
