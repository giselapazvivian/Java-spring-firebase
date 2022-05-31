package com.example.ATS.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.ATS.models.Applicant;
import com.example.ATS.repositories.ApplicantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = { ApplicantService.class, ApplicantServiceImpl.class })
public class ApplicantServiceTests {
    @MockBean
    ApplicantRepository repository;

    @Autowired
    ApplicantService service;

    @Test
    void testFindById() {
        Optional<Applicant> applicant = Optional.of(
                new Applicant(1, "Juan", "Perez", "1-9"));

        when(repository.findById(anyInt())).thenReturn(applicant);

        var result = service.findById(1);

        assertEquals(1, result.getId());
        assertEquals("Juan", result.getName());
        assertEquals("Perez", result.getLastName());
        assertEquals("1-9", result.getRut());
    }
}