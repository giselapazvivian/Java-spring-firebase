package com.example.ATS.services;

import java.util.List;

import com.example.ATS.models.Applicant;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

/**
 * 
 * 
 */
public interface ApplicantService {

    /**
     * Create applicant
     * 
     * @param applicant
     * @return applicant created
     */

    Applicant create(Applicant applicant);

    /**
     * find applicant by id
     * 
     * @return applicant by id
     */

    Applicant findById(Integer id);

    /**
     * find all applicants for page
     * 
     * @return pageable of applicants
     */

    Page<Applicant> findAll(Pageable pageable);

    /**
     * find all applicants stored
     * 
     * @return a list of applicants
     */

    List<Applicant> findAll();

    /**
     * find applicant by name
     * 
     * @return applicant by name
     */

    List<Applicant> findByName(String name);

    /**
     * Update applicants
     * 
     * @return applicant updated
     */

    Applicant update(Integer id, Applicant applicant);

    /**
     * find applicants by id
     * 
     * @return applicant by id
     */

    void delete(Integer id);

    Object findPaginated(Object any);

}
