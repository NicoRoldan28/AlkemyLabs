package com.example.AlkemyLabs.service;

import com.example.AlkemyLabs.model.*;
import com.example.AlkemyLabs.Utils.EntityURLBuilder;
import com.example.AlkemyLabs.repository.MateriaRepository;
import com.example.AlkemyLabs.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PersonaService {
    private static final String PERSONA_PATH="person";
    private PersonaRepository personaRepository;
    private MateriaService materiaService;



    @Autowired
    public PersonaService(PersonaRepository personaRepository,MateriaService materiaService ) {
        this.personaRepository = personaRepository;
        this.materiaService= materiaService;
    }

    public PostResponse addPersona(Persona persona) {
         Persona p= personaRepository.save(persona);
         return PostResponse.builder()
                 .status(HttpStatus.CREATED)
                 .url(EntityURLBuilder.buildURL(PERSONA_PATH,p.getDni()))
                 .build();
    }

    public Persona getById(Integer id){
         return personaRepository.findById(id)
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public PaginationResponse<Persona> getAll(Integer size, Integer page){
        Pageable pageable= PageRequest.of(page,size);
        Page<Persona> personaPage= personaRepository.findAll(pageable);

        return new PaginationResponse<>(personaPage.getContent(),
                personaPage.getTotalPages(),
                personaPage.getTotalElements());
    }

    public void addMateriaToPersona(Integer persona_id,Integer materia_id) {
        Persona p = getById(persona_id);
        Materia m = materiaService.getById(materia_id);
/*
        if(!(p instanceof Alumno) || !(p instanceof Profesor) ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }*/
        if (p instanceof Alumno) {
            if (m.getCantMaxAlumnos() < m.getAlumnos().size()) {
                ((Alumno) p).getMaterias().add(m);
                personaRepository.save(p);
            } else {
                System.out.println("La cursada ya esta llena");
            }
        } else if (p instanceof Profesor) {
            if (m.getTeacher() == null) {
                m.setTeacher((Profesor) p);
                personaRepository.save(p);
            }
        }
    }
}