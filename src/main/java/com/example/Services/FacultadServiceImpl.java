package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.Facultaddao;
import com.example.entities.Facultad;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FacultadServiceImpl implements FacultadService {
	private final Facultaddao facultaddao;

	@Override
	public void saveFacultad(Facultad facultad) {
		facultaddao.save(facultad);
	}

	@Override
	public List<Facultad> getAllFacultades() {
		return facultaddao.findAll();
	}
}
