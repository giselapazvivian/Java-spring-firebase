package com.example.ATS.repositories;

import java.util.List;

import com.example.ATS.models.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

    List<Applicant> findByName(String name);

    List<Applicant> findByNameAndLastName(String name, String lastName);

    Object findById(String anyString);

}
