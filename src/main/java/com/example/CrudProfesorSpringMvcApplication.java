package com.example;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Services.ProfesorService;
import com.example.Services.FacultadService;
import com.example.entities.Profesor;
import com.example.entities.Facultad;
import com.example.model.Genero;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudProfesorSpringMvcApplication implements CommandLineRunner {

	private final ProfesorService profesorService;
	private final FacultadService facultadService;

	public static void main(String[] args) {
		SpringApplication.run(CrudProfesorSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (!facultadService.getAllFacultades().isEmpty()) {
			return;
		}

		List<Facultad> facultades = List.of(
			Facultad.builder().nombre("MATEMATICAS").build(),
			Facultad.builder().nombre("CIENCIAS").build(),
			Facultad.builder().nombre("LETRAS").build(),
			Facultad.builder().nombre("GEOLOGIA").build(),
			Facultad.builder().nombre("INGENIERIA").build()
		);

		for (Facultad facultad : facultades) {
			facultadService.saveFacultad(facultad);
		}

		List<Profesor> profesores = List.of(
			crearProfesor("Javier", "Gonzalez", "Sanch", Genero.HOMBRE, LocalDate.now(), facultades.get(4)),
			crearProfesor("Alberto", "Gonzalez", "Sanchez", Genero.MUJER, LocalDate.now(), facultades.get(3)),
			crearProfesor("Laura", "Martinez", "Lopez", Genero.MUJER, LocalDate.now(), facultades.get(0)),
			crearProfesor("Carlos", "Ruiz", "Perez", Genero.HOMBRE, LocalDate.now(), facultades.get(0)),
			crearProfesor("Sofía", "Torres", "Mora", Genero.MUJER, LocalDate.now(), facultades.get(1)),
			crearProfesor("Mateo", "Vega", "Ríos", Genero.HOMBRE, LocalDate.now(), facultades.get(1)),
			crearProfesor("Elena", "Díaz", "Cruz", Genero.MUJER, LocalDate.now(), facultades.get(2)),
			crearProfesor("Diego", "Navarro", "Luna", Genero.HOMBRE, LocalDate.now(), facultades.get(2)),
			crearProfesor("Marta", "Silva", "Méndez", Genero.MUJER, LocalDate.now(), facultades.get(4)),
			crearProfesor("Pedro", "Castro", "Rojas", Genero.HOMBRE, LocalDate.now(), facultades.get(3))
		);

		for (Profesor profesor : profesores) {
			profesorService.saveProfesor(profesor);
		}
	}

	private Profesor crearProfesor(String nombre, String primerApellido, String segundoApellido, Genero genero,
			LocalDate fechaAltaFacultad, Facultad facultad) {
		Profesor profesor = Profesor.builder()
			.nombre(nombre)
			.primerApellido(primerApellido)
			.segundoApellido(segundoApellido)
			.genero(genero)
			.fechadeAltaenlaFacultad(fechaAltaFacultad)
			.facultad(facultad)
			.build();
		return profesor;
	}

}