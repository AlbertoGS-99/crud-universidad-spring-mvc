package com.example;

import java.math.BigDecimal;
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
				Facultad.builder().nombre("INGENIERIA").build());

		for (Facultad facultad : facultades) {
			facultadService.saveFacultad(facultad);
		}

		List<Profesor> profesores = List.of(
				Profesor.builder()
						.nombre("Javier")
						.primerApellido("Gonzalez")
						.segundoApellido("Sanch")
						.genero(Genero.HOMBRE)
						.fechadeAltaenlaFacultad(LocalDate.of(2020, 1, 15))
						.salario(new BigDecimal(5000))
						.facultad(facultades.get(4))
						.build(),

				Profesor.builder()
						.nombre("Alberto")
						.primerApellido("Gonzalez")
						.segundoApellido("Sanchez")
						.genero(Genero.HOMBRE)
						.fechadeAltaenlaFacultad(LocalDate.of(2020, 3, 22))
						.salario(new BigDecimal(6000))
						.facultad(facultades.get(3))
						.build(),

				Profesor.builder()
						.nombre("Laura")
						.primerApellido("Martinez")
						.segundoApellido("Lopez")
						.genero(Genero.MUJER)
						.fechadeAltaenlaFacultad(LocalDate.of(2020, 6, 5))
						.salario(new BigDecimal(5500))
						.facultad(facultades.get(0))
						.build(),

				Profesor.builder()
						.nombre("Carlos")
						.primerApellido("Ruiz")
						.segundoApellido("Perez")
						.genero(Genero.HOMBRE)
						.fechadeAltaenlaFacultad(LocalDate.of(2021, 2, 10))
						.salario(new BigDecimal(7000))
						.facultad(facultades.get(0))
						.build(),

				Profesor.builder()
						.nombre("Sofía")
						.primerApellido("Torres")
						.segundoApellido("Mora")
						.genero(Genero.MUJER)
						.fechadeAltaenlaFacultad(LocalDate.of(2021, 5, 18))
						.salario(new BigDecimal(6500))
						.facultad(facultades.get(1))
						.build(),

				Profesor.builder()
						.nombre("Mateo")
						.primerApellido("Vega")
						.segundoApellido("Ríos")
						.genero(Genero.HOMBRE)
						.fechadeAltaenlaFacultad(LocalDate.of(2021, 9, 30))
						.salario(new BigDecimal(7200))
						.facultad(facultades.get(1))
						.build(),

				Profesor.builder()
						.nombre("Elena")
						.primerApellido("Díaz")
						.segundoApellido("Cruz")
						.genero(Genero.MUJER)
						.fechadeAltaenlaFacultad(LocalDate.of(2022, 1, 12))
						.salario(new BigDecimal(5800))
						.facultad(facultades.get(2))
						.build(),

				Profesor.builder()
						.nombre("Diego")
						.primerApellido("Navarro")
						.segundoApellido("Luna")
						.genero(Genero.HOMBRE)
						.fechadeAltaenlaFacultad(LocalDate.of(2022, 7, 8))
						.salario(new BigDecimal(6300))
						.facultad(facultades.get(2))
						.build(),

				Profesor.builder()
						.nombre("Marta")
						.primerApellido("Silva")
						.segundoApellido("Méndez")
						.genero(Genero.MUJER)
						.fechadeAltaenlaFacultad(LocalDate.of(2023, 4, 14))
						.salario(new BigDecimal(6700))
						.facultad(facultades.get(4))
						.build(),

				Profesor.builder()
						.nombre("Pedro")
						.primerApellido("Castro")
						.segundoApellido("Rojas")
						.genero(Genero.HOMBRE)
						.fechadeAltaenlaFacultad(LocalDate.of(2023, 11, 21))
						.salario(new BigDecimal(7100))
						.facultad(facultades.get(3))
						.build());

		for (Profesor profesor : profesores) {
			profesorService.saveProfesor(profesor);
		}
	}
}