package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Profesor;

public interface Profesordao extends JpaRepository<Profesor, Integer> {

}