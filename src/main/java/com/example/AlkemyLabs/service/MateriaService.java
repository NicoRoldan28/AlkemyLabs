package com.example.AlkemyLabs.service;

import com.example.AlkemyLabs.Utils.EntityURLBuilder;
import com.example.AlkemyLabs.model.Materia;
import com.example.AlkemyLabs.model.PaginationResponse;
import com.example.AlkemyLabs.model.Persona;
import com.example.AlkemyLabs.model.PostResponse;
import com.example.AlkemyLabs.repository.MateriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MateriaService {
    private static final String MATERIA_PATH="materia";
    MateriaRepository materiaRepository;

    public MateriaService (MateriaRepository materiaRepository){
        this.materiaRepository=materiaRepository;
    }

    public PostResponse addMateria(Materia materia) {
        Materia m= materiaRepository.save(materia);
        return PostResponse.builder()
                .status(HttpStatus.CREATED)
                .url(EntityURLBuilder.buildURL(MATERIA_PATH,m.getId()))
                .build();
    }

    public PaginationResponse<Materia> getAll(Integer size, Integer page){
        Pageable pageable= PageRequest.of(page,size);
        Page<Materia> materiaPage= materiaRepository.findAll(pageable);

        return new PaginationResponse<>(materiaPage.getContent(),
                materiaPage.getTotalPages(),
                materiaPage.getTotalElements());
    }

    public Materia getById(Integer id){
        return materiaRepository.findById(id)
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
