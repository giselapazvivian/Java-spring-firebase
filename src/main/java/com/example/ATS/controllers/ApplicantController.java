package com.example.ATS.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.ATS.models.Applicant;
import com.example.ATS.services.ApplicantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api that creates, retrieve upadates an delete
 * applicants
 */
@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private ApplicantService service;

    @Autowired
    ApplicantController(ApplicantService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Applicant> findAll() {
        return service.findAll();
    }

    @GetMapping("/findBy")
    public List<Applicant> findByName(@RequestParam(name = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping("/{id}")
    public Applicant findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<Applicant> findPaginated(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Applicant create(@Valid @RequestBody Applicant applicant) {
        return service.create(applicant);
    }

    @PutMapping("/{id}")
    public Applicant update(@PathVariable Integer id, @Valid @RequestBody Applicant applicant) {
        return service.update(id, applicant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}