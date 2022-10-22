package com.example.service;

import com.example.dto.DavomatDto;
import com.example.dto.StudentResponse;
import com.example.entity.Davomat;
import com.example.repository.DavomatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Suxrob Sattorov, Tue 8:31 PM. 10/18/2022
 */

@Service
@RequiredArgsConstructor
public class DavomatServiceImpl implements DavomatService {

    private final DavomatRepo davomatRepo;

    private final StudentService studentService;

    @Override
    public void save() {
        for ( StudentResponse s : studentService.get() ) {
            Davomat davomat = getStudentById(s.getId());
            if ( davomat == null ) {
                Davomat d = new Davomat();
                d.setStudentId(s.getId());
                davomatRepo.save(d);
            }
        }
    }

    @Override
    public DavomatDto get( Long id ) {
        return toDto(getById(id));
    }

    @Override
    public List<DavomatDto> get() {

        List<DavomatDto> davomatDtoLinkedList = new LinkedList<>();

        for ( Davomat d : davomatRepo.findAll() ) {
            davomatDtoLinkedList.add(toDto(d));
        }
        return davomatDtoLinkedList;
    }

    @Override
    public DavomatDto editStudentIsExists( Long id ) {

        Davomat davomat = getById(id);

        davomat.setExists(!davomat.getExists());

        return toDto(davomatRepo.save(davomat));
    }

    @Override
    public Davomat getById( Long id ) {
        return davomatRepo.findById(id).orElseThrow(() -> new RuntimeException("Davomat not found"));
    }

    public DavomatDto toDto( Davomat davomat ) {
        StudentResponse student = studentService.get(davomat.getStudentId());
        DavomatDto dto = new DavomatDto();
        dto.setId(davomat.getId());
        dto.setExists(davomat.getExists());
        dto.setCreatedAt(davomat.getCreatedAt());
        dto.setStudentId(student.getId());
        dto.setStudentName(student.getName());
        dto.setStudentSurname(student.getSurname());
        return dto;
    }

    public Davomat getStudentById( Long id ) {
        return davomatRepo.findByStudentId(id);
    }

}
