package com.example.AlkemyLabs.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, property = "typePersona", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value= Profesor.class, name = "TEACHER"),
        @JsonSubTypes.Type(value= Alumno.class, name = "STUDENT")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Persons")
public abstract class Persona {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El campo name es obligatorio.")
    @Column(name = "name")
    private String name;

    @NotNull(message = "El campo lastName es obligatorio.")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "El campo dni es obligatorio.")
    @Column(name = "dni")
    private Integer dni;

    @NotNull(message = "El campo role es obligatorio.")
    @OneToOne
    @JoinColumn(name = "role_id")
    public Role role;

    @NotNull(message = "El campo typePerson es obligatorio.")
    @Column(name = "typePerson")
    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePersona typePersona();

}
