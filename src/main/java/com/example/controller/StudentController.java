package com.example.controller;

import com.example.dto.StudentRequest;
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
@RequestMapping( "/student" )
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public String index( Model model ) {
        model.addAttribute("studentList", studentService.get());
        return "student_index";
    }

    @GetMapping( "/save" )
    public String create( Model model ) {
        model.addAttribute("student", new StudentRequest());
        model.addAttribute("isEdit", false);
        return "student_create";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute StudentRequest request ) {
        studentService.save(request);
        return "redirect:/student";
    }

    @PostMapping( "/get/{id}" )
    public String get( @PathVariable( "id" ) Long id, Model model ) {
        model.addAttribute(studentService.get(id));
        return "student_index";
    }

    @GetMapping( "/edit/{id}" )
    public String edit( @PathVariable( "id" ) Long id, Model model ) {
        model.addAttribute("student", studentService.get(id));
        model.addAttribute("isEdit", true);
        return "student_create";
    }

    @PostMapping( "/edit/{id}" )
    public String edit( @PathVariable( "id" ) Long id,
                        @ModelAttribute StudentRequest request ) {
        studentService.edit(id, request);
        return "redirect:/student";
    }

    @GetMapping( "/delete/{id}" )
    public String delete( @PathVariable( "id" ) Long id ) {
        studentService.delete(id);
        return "redirect:/student";
    }
}
