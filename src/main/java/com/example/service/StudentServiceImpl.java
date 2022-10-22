package com.example.service;

import com.example.dto.StudentRequest;
import com.example.dto.StudentResponse;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Suxrob Sattorov, Tue 8:31 PM. 10/18/2022
 */

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;

    private final StudentMapper studentMapper;

    @Override
    public StudentResponse save( StudentRequest request ) {
        Student student = studentRepo.findByNameAndSurname(request.getName(), request.getSurname());
        if ( student != null ) {
            throw new RuntimeException("These students exist");
        }
        return studentMapper.toResponse(studentRepo.save(studentMapper.toEntity(request)));
    }

    @Override
    public StudentResponse get( Long id ) {
        return studentMapper.toResponse(getById(id));
    }

    @Override
    public List<StudentResponse> get() {
        List<StudentResponse> wordResponseList = new LinkedList<>();
        for ( Student s : studentRepo.findAll() ) {
            wordResponseList.add(studentMapper.toResponse(s));
        }
        return wordResponseList;
    }

    @Override
    public StudentResponse edit( Long id, StudentRequest request ) {

        Student student = getById(id);

        if ( request.getName() != null ) student.setName(request.getName());
        if ( request.getSurname() != null ) student.setSurname(request.getSurname());

        return studentMapper.toResponse(studentRepo.save(student));
    }

    @Override
    public StudentResponse delete( Long id ) {
        Student student = getById(id);
        studentRepo.delete(student);
        return studentMapper.toResponse(student);
    }

    @Override
    public Student getById( Long id ) {
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
