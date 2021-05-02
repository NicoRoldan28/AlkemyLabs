package com.example.AlkemyLabs.service;

import com.example.AlkemyLabs.model.Materia;
import com.example.AlkemyLabs.repository.MateriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MateriaService {
    MateriaRepository materiaRepository;

    public MateriaService (MateriaRepository materiaRepository){
        this.materiaRepository=materiaRepository;
    }

    public void addMateria(Materia materia){
        materiaRepository.save(materia);
    }
    public List<Materia> getAll(){
        return materiaRepository.findAll();
    }

    public Materia getById(Integer id){
        return materiaRepository.findById(id)
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }



}
