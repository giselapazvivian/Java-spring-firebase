package com.example.ATS.controllers;

import com.example.ATS.models.Applicant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {
    @GetMapping()
    public String greeting() {
        return "Hola Mundo";
    }

    @GetMapping("/applicant")
    public Applicant findApplicant() {
        Applicant applicant = new Applicant("1", "John", "Rambo", "1-9");
        return applicant;
    }

    @GetMapping("/variables/{id}")
    public String showVariables(
            @PathVariable String id,
            @RequestParam(defaultValue = "1") Integer page) {
        return "id: " + id + "<br>page: " + page;
    }
}