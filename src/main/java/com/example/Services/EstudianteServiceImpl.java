package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.Estudiantedao;
import com.example.entities.Estudiante;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class EstudianteServiceImpl implements EstudianteService {


    private final Estudiantedao estudiantedao;

@Override
public List<Estudiante> getAllEstudiantes();
return est


}
