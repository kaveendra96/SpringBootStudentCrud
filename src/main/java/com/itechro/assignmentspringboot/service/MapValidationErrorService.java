package com.itechro.assignmentspringboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public interface MapValidationErrorService {
    public ResponseEntity<?> mapValidationError(BindingResult result);
}
