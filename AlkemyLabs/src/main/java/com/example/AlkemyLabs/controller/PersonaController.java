package com.example.AlkemyLabs.controller;

import com.example.AlkemyLabs.model.PaginationResponse;
import com.example.AlkemyLabs.model.Persona;
import com.example.AlkemyLabs.model.PostResponse;
import com.example.AlkemyLabs.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService personaService;
    private ConversionService conversionService;

    @Autowired
    public PersonaController(PersonaService personaService,ConversionService conversionService) {
        this.personaService = personaService;
        this.conversionService= conversionService;
    }

    @GetMapping("/userForm")
    public String getUserForm(){
        return "user-form/user-view.html";
    }

    @PostMapping("/")
    public PostResponse addPerson (@RequestBody Persona persona){
        return personaService.addPersona(persona);
    }

    @GetMapping("/{id}")
    public Persona getById(@PathVariable Integer id){
       return personaService.getById(id);
    }

   @GetMapping()
    public PaginationResponse<Persona> getAll(@RequestParam(value = "size",defaultValue = "20")Integer size,
                                              @RequestParam(value = "page", defaultValue = "0")Integer page){
        return personaService.getAll(size,page);
    }

    @PutMapping("/{persona_id}/materia/{materia_id}")
    public void addMateriaToPersona(Integer persona_id,Integer materia_id){
        personaService.addMateriaToPersona(persona_id,materia_id);
    }
}
