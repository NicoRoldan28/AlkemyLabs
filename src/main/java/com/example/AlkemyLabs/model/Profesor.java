package com.example.AlkemyLabs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Profesor extends Persona {

    @Column(name = "active")
    private Boolean activo;

    @Override
    public TypePersona typePersona() {
        return TypePersona.TEACHER;
    }
}
