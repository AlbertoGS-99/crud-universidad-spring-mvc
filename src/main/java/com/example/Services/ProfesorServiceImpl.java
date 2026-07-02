package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.Profesordao;
import com.example.entities.Profesor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final Profesordao profesorDao;

    @Override
    public List<Profesor> getAllProfesores() {
        
        return profesorDao.findAll();

    }

    @Override
    public Profesor getProfesorById(int id) {

        return profesorDao.findById(id).orElseThrow(() ->
            new RuntimeException("Profesor no encontrado con id: "+id));

    }

    @Override
    public Profesor saveProfesor(Profesor profesor) {

        return profesorDao.save(profesor);
    
    }

    @Override
    public void deleteProfesorById(int id) {

        profesorDao.deleteById(id);
    
    }

    @Override
    public void deleteProfesor(Profesor profesor) {

        profesorDao.delete(profesor);
    
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {

        return profesorDao.save(profesor);
    
    }

}