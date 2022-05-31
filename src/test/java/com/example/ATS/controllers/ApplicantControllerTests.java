package com.example.ATS.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.ATS.models.Applicant;
import com.example.ATS.services.ApplicantService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@WebMvcTest(controllers = ApplicantController.class)
public class ApplicantControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicantService service;

    ApplicantController controller;

    @Test
    public void testFindById() throws Exception {
        Applicant applicant = new Applicant(1, "Juan", "Perez", "1-9");

        when(service.findById(1)).thenReturn(applicant);

        mockMvc.perform(get("/applicants/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Juan"))
                .andExpect(jsonPath("$.lastName").value("Perez"))
                .andExpect(jsonPath("$.rut").value("1-9"));
    }

    // @Test
    // public void testFindAllPaginated() throws Exception {
    // List<Applicant> applicants = new ArrayList<>();
    // applicants.add(new Applicant(1, "Juan", "Perez", "1-9"));

    // Page<Applicant> page = new PageImpl<>(applicants);

    // when(service.findAll(any())).thenReturn(page);

    // mockMvc.perform(
    // get("/applicants"))
    // .andExpect(status().isOk())
    // .andExpect(jsonPath("$").isMap())
    // .andExpect(jsonPath("$.content[0].id").value(1))
    // .andExpect(jsonPath("$.content[0].name").value("Juan"))
    // .andExpect(jsonPath("$.content[0].lastName").value("Perez"))
    // .andExpect(jsonPath("$.content[0].rut").value("1-9"));
    // }

    // @Test
    // public void testFindAll() throws Exception {

    // List<Applicant> applicants = new ArrayList<>();
    // applicants.add(new Applicant(1, "Juan", "Perez", "1-9"));

    // when(service.findAll()).thenReturn(applicants);

    // mockMvc.perform(
    // get("/applicants/all"))
    // .andExpect(status().isOk())
    // .andExpect(jsonPath("$").isArray())
    // .andExpect(jsonPath("$[0].id").value(1))
    // .andExpect(jsonPath("$[0].name").value("Juan"))
    // .andExpect(jsonPath("$[0].lastName").value("Perez"))
    // .andExpect(jsonPath("$[0].rut").value("1-9"));

    // }

    // @Test
    // public void testCreateApplicant() throws Exception {
    // Applicant applicant = new Applicant(1, "Juan", "Perez", "1-9");

    // when(service.create(any())).thenReturn(applicant);

    // mockMvc.perform(post("/applicants").contentType(MediaType.APPLICATION_JSON)
    // .content("{\"id\":1,\"name\":\"Juan\",\"lastName\":\"Perez\",\"rut\":\"1-9\"}"))
    // .andExpect(status().isCreated())
    // .andExpect(jsonPath("$.id").value(1))
    // .andExpect(jsonPath("$.name").value("Juan"))
    // .andExpect(jsonPath("$.lastName").value("Perez"))
    // .andExpect(jsonPath("$.rut").value("1-9"));
    // }

    // @Test
    // public void testFindByName() throws Exception {
    // List<Applicant> applicants = new ArrayList<>();
    // applicants.add(new Applicant(1, "Juan", "Perez", "1-9"));

    // when(service.findByName("juan")).thenReturn(applicants);

    // mockMvc.perform(get("/applicants/findBy?name=juan"))
    // .andExpect(status().isOk())
    // .andExpect(jsonPath("$").isArray())
    // .andExpect(jsonPath("$[0].id").value(1))
    // .andExpect(jsonPath("$[0].name").value("Juan"))
    // .andExpect(jsonPath("$[0].lastName").value("Perez"))
    // .andExpect(jsonPath("$[0].rut").value("1-9"));

    // }

    // @Test
    // public void testDelete() throws Exception {
    // doNothing().when(service).delete(any());

    // mockMvc.perform(delete("/applicants/1")).andExpect(status().isOk());
    // }

    // @Test
    // public void testUpdate() throws Exception {
    // Applicant applicant = new Applicant(1, "Juan", "Perez", "1-9");

    // when(service.update(any(), any())).thenReturn(applicant);

    // }

}