package com.example.AlkemyLabs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "materias")
public class Materia {

    @Column(name = "asignature_id")
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El campo name es obligatorio.")
    @Column(name = "name")
    private String name;

    @NotNull(message = "El campo horario es obligatorio.")
    @Column(name = "schedule")
    private String horario;

    @NotNull(message = "El campo description es obligatorio.")
    @Column(name = "description")
    private String descripcion;

    @Column(name = "students")
    @ManyToMany(mappedBy = "materias", cascade= CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Alumno> alumnos;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Profesor teacher;

    @NotNull(message = "El campo cantMaxAlumnos es obligatorio.")
    @Column(name = "max_number_student")
    private Integer cantMaxAlumnos;

}
