package com.example.service;

import com.example.dto.StudentRequest;
import com.example.dto.StudentResponse;
import com.example.entity.Student;

import java.util.List;

/**
 * @author Suxrob Sattorov, Mon 11:11 AM. 10/10/2022
 */

public interface StudentService {

    StudentResponse save( StudentRequest request );

    StudentResponse get( Long id );

    List<StudentResponse> get();

    StudentResponse edit( Long id, StudentRequest request );

    StudentResponse delete( Long id );

    Student getById( Long id );

}
