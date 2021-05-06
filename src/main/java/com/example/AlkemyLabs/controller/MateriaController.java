package com.example.AlkemyLabs.controller;

import com.example.AlkemyLabs.model.Materia;
import com.example.AlkemyLabs.model.PaginationResponse;
import com.example.AlkemyLabs.model.Persona;
import com.example.AlkemyLabs.model.PostResponse;
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
    public PostResponse addMateria (@RequestBody Materia materia){
        return materiaService.addMateria(materia);
    }


    @GetMapping()
    public PaginationResponse<Materia> getAll(@RequestParam(value = "size",defaultValue = "20")Integer size,
                                              @RequestParam(value = "page", defaultValue = "0")Integer page){
        return materiaService.getAll(size,page);
    }

    @GetMapping("/{id}")
    public Materia getById(Integer id){
        return materiaService.getById(id);
    }
}
