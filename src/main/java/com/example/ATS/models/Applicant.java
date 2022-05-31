package com.example.ATS.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.ATS.validation.ValidRut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant {
    public Applicant(String string, String name, String lastName, String rut) {
    }

    public Applicant(Integer id2, String name2, String lastName2, int i) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 10)
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @ValidRut
    @Column(unique = true)
    private String rut;
}