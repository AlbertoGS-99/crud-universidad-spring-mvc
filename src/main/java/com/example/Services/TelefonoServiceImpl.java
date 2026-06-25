package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.dao.Telefonodao;
import com.example.entities.Estudiante;
import com.example.entities.Telefono;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TelefonoServiceImpl implements TelefonoService {
	
	private final Telefonodao telefonodao;

	@Override
	public List<Telefono> getAllTelefonos() {
		// TODO Auto-generated method stub
		return telefonodao.findAll();
	}

	@Override
	public Telefono saveTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		return telefonodao.save(telefono);
	}

	@Override
	public boolean existsByEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return telefonodao.existsByEstudiante(estudiante);
	}

	@Override
	public void deleteByEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		telefonodao.deleteByEstudiante(estudiante);
	}

	@Override
	public List<Telefono> findByEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return telefonodao.findByEstudiante(estudiante);
	}

}
