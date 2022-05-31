package com.example.ATS.services;

import java.util.List;
import java.util.Optional;

import com.example.ATS.exceptions.NotFoundException;
import com.example.ATS.models.Applicant;
import com.example.ATS.repositories.ApplicantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantRepository repository;

    /**
     * Store an anpplicant in repository
     * 
     * @param applicant applicant object to be stored
     * @return Applicant with generates id
     */

    @Override
    public Applicant create(Applicant applicant) {

        return repository.save(applicant);

    }

    /**
     * @param id
     * @return Applicant
     */

    @Override
    public Applicant findById(Integer id) {

        Optional<Applicant> result = repository.findById(id);

        return result.orElse(null);
    }

    /**
     * @return List<Applicant>
     */

    @Override
    public List<Applicant> findAll() {

        return repository.findAll();
    }

    /**
     * @param id
     * @param applicant
     * @return Applicant
     */

    @Override
    public Applicant update(Integer id, Applicant applicant) {
        Applicant storedApplicant = this.findById(id);

        if (storedApplicant == null) {
            throw new NotFoundException();
        }
        storedApplicant.setLastName(applicant.getLastName());
        storedApplicant.setName(applicant.getName());
        storedApplicant.setRut(applicant.getRut());

        repository.save(storedApplicant);

        applicant.setName("María");
        return applicant;
    }

    /**
     * @param id
     */

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * @param pegeable
     */

    @Override
    public Page<Applicant> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param name
     */

    @Override
    public List<Applicant> findByName(String name) {

        return findByName(name);
    }

    @Override
    public Object findPaginated(Object any) {
        // TODO Auto-generated method stub
        return null;
    }

}
