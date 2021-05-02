package com.example.AlkemyLabs.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Roles")

public class Role{
    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_type")
    @AccessType(AccessType.Type.PROPERTY)
    private TypeRole typeRole;

    @Column(name = "role_description")
    private String description;

}
