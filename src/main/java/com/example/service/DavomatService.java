package com.example.service;

import com.example.dto.DavomatDto;
import com.example.entity.Davomat;

import java.util.List;

/**
 * @author Suxrob Sattorov, Mon 11:11 AM. 10/10/2022
 */

public interface DavomatService {

    void save();

    DavomatDto get( Long id );

    List<DavomatDto> get();

    DavomatDto editStudentIsExists( Long id);

    Davomat getById( Long id );

}
