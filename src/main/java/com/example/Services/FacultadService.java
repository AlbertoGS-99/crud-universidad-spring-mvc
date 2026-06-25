package com.example.Services;

import java.util.List;

import com.example.entities.Facultad;

public interface FacultadService {

    List<Facultad> getAllFacultades();
    Facultad saveFacultad(Facultad facultad);

}