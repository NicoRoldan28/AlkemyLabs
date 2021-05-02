package com.example.AlkemyLabs.controller;

import com.example.AlkemyLabs.model.Materia;
import com.example.AlkemyLabs.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")

public class MateriaController {
    private final MateriaService materiaService;

    @Autowired
    public MateriaController(MateriaService materiaService){
        this.materiaService=materiaService;
    }

    @PostMapping("/")
    public void addMateria(@RequestBody Materia materia){
        materiaService.addMateria(materia);
    }

    @GetMapping()
    public List<Materia> getAll(){
        return materiaService.getAll();
    }

    @GetMapping("/{id}")
    public Materia getById(Integer id){
        return materiaService.getById(id);
    }
}
