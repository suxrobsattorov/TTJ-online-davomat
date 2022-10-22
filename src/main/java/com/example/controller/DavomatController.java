package com.example.controller;

import com.example.dto.DavomatDto;
import com.example.dto.StudentRequest;
import com.example.service.DavomatService;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Suxrob Sattorov, Mon 2:08 PM. 10/10/2022
 */

@Controller
@RequiredArgsConstructor
@RequestMapping( "/davomat" )
public class DavomatController {

    private final DavomatService davomatService;

    @GetMapping()
    public String index( Model model ) {
        model.addAttribute("davomatList", davomatService.get());
        return "davomat_index";
    }

    @PostMapping( "/get/{id}" )
    public String get( @PathVariable( "id" ) Long id, Model model ) {
        model.addAttribute(davomatService.get(id));
        return "davomat_index";
    }

    @GetMapping( "/edit/{id}" )
    public String edit( @PathVariable( "id" ) Long id, Model model ) {
        model.addAttribute("davomat", davomatService.get(id));
        davomatService.editStudentIsExists(id);
        return "redirect:/davomat";
    }
}
