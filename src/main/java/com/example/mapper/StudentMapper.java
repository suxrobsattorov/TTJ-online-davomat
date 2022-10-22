package com.example.mapper;

import com.example.dto.StudentRequest;
import com.example.dto.StudentResponse;
import com.example.entity.Student;
import org.mapstruct.Mapper;

/**
 * @author Suxrob Sattorov, Mon 11:06 AM. 10/10/2022
 */

@Mapper( componentModel = "spring" )
public interface StudentMapper {

    StudentResponse toResponse( Student entity );

    Student toEntity( StudentRequest request );

}
