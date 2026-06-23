package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Estudiante;
import java.util.List;
import com.example.model.Genero;



public interface Estudiantedao extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findByNombre(String nombre);

    boolean existsByGenero(Genero genero);

}
