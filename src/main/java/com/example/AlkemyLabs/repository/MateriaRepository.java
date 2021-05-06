package com.example.AlkemyLabs.repository;

import com.example.AlkemyLabs.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia,Integer> {

}
