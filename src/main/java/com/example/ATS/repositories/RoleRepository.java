package com.example.ATS.repositories;

import java.util.Optional;

import com.example.ATS.Enum.ERole;
import com.example.ATS.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}