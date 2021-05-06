package com.example.AlkemyLabs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Alumno extends Persona {

    @ManyToMany @JoinTable(name = "persons_x_asignatures",
            joinColumns ={@JoinColumn(name = "persons_id")},
            inverseJoinColumns={@JoinColumn(name = "asignatures_id")})
    @JsonIgnore
    private List<Materia> materias;

    @Column(name = "file")
    private Integer legajo;


    @Override
    public TypePersona typePersona() {
        return TypePersona.STUDENT;
    }
}
