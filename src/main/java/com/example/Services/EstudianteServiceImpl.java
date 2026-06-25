package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.Estudiantedao;
import com.example.entities.Estudiante;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	/* Esta clase necesita del DAO para implementar todos sus metodos.
	 * Anteriormente la inyeccion de dependencias tenia lugar a traves
	 * de la anotacion @Autowire de Spring, pero desde un tiempo
	 * se ha llegado a la conclusion que la inyeccion de dependencia 
	 * por constructor es mas eficiente.
	 * 
	 * Y si utilizamos el lombok, para que se inyecte una dependencia por constructor
	 * solamente hay que agregarle el modificador final */
	
	private final Estudiantedao estudiantedao;

	@Override
	public List<Estudiante> getAllEstudiantes() {
		// TODO Auto-generated method stub
		return estudiantedao.findAll();
	}

	@Override
	public void saveEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		estudiantedao.save(estudiante);
	}

	@Override
	public Estudiante getEstudianteById(int id) {
		return estudiantedao.findById(id).orElse(null);
	}

	@Override
	public void deleteEstudianteById(int id) {
		estudiantedao.deleteById(id);
	}

}
