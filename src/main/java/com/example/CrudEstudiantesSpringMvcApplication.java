package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Profesor;
import com.example.entities.Telefono;
import com.example.model.Genero;
import com.example.Services.EstudianteService;
import com.example.Services.FacultadService;
import com.example.Services.ProfesorService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudEstudiantesSpringMvcApplication implements CommandLineRunner {

	private final EstudianteService estudianteService;
	private final FacultadService facultadService;
	private final ProfesorService profesorService;

	public static void main(String[] args) {
		SpringApplication.run(CrudEstudiantesSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Facultad facultad1 = Facultad.builder()
			.nombre("MATEMATICAS")
			.build();
		
		Facultad facultad2 = Facultad.builder()
			.nombre("CIENCIAS")
			.build();
		
		Facultad facultad3 = Facultad.builder()
			.nombre("LETRAS")
			.build();

		Facultad facultad4 = Facultad.builder()
			.nombre("GEOLOGIA")
			.build();

			Facultad facultad5 = Facultad.builder()
			.nombre("INGENIERIA")
			.build();

		facultadService.saveFacultad(facultad1);
		facultadService.saveFacultad(facultad2);
		facultadService.saveFacultad(facultad3);
		facultadService.saveFacultad(facultad4);
		facultadService.saveFacultad(facultad5);

		Estudiante estudiante1 = Estudiante.builder()
			.nombre("Duglas")
			.primerApellido("Tayron")
			.segundoApellido("Gonzalez")
			.genero(Genero.HOMBRE)
			.fechaMatriculacion(LocalDate.now())
			.facultad(facultad5)
			.correos(Set.of(
				Correo.builder()
					.direccion("duglas1@gmail.com")
					.build(),	
				Correo.builder()
					.direccion("duglas2@gmail.com")
					.build()
				))
			.telefonos(Set.of(
				Telefono.builder()
					.numero("654764555")
					.build(),
				Telefono.builder()
					.numero("675743545")
					.build()
			))
			.build();

			estudiante1.getCorreos().forEach(correo -> correo.setEstudiante(estudiante1));
			estudiante1.getTelefonos().forEach(telefono -> telefono.setEstudiante(estudiante1));

			Estudiante estudiante2 = Estudiante.builder()
			.nombre("Guti")
			.primerApellido("Malo")
			.segundoApellido("Gonzalez")
			.genero(Genero.MUJER)
			.fechaMatriculacion(LocalDate.now())
			.facultad(facultad4)
			.correos(Set.of(
				Correo.builder()
					.direccion("guti1@gmail.com")
					.build(),	
				Correo.builder()
					.direccion("guti2@gmail.com")
					.build()
				))
			.telefonos(Set.of(
				Telefono.builder()
					.numero("154353441")
					.build(),
				Telefono.builder()
					.numero("709856784")
					.build()
			))
			.build();

			estudiante2.getCorreos().forEach(correo -> correo.setEstudiante(estudiante2));
			estudiante2.getTelefonos().forEach(telefono -> telefono.setEstudiante(estudiante2));

			estudianteService.saveEstudiante(estudiante1);
			estudianteService.saveEstudiante(estudiante2);

			Profesor profesor1 = Profesor.builder()
				.nombre("Victor Rafael")
				.primerApellido("Machado")
				.segundoApellido("Arteaga")
				.genero(Genero.HOMBRE)
				.fechadeAltaenlaFacultad(LocalDate.now())
				.salario(new BigDecimal(5000))
				.facultad(facultad5)
			.build();

			Profesor profesor2 = Profesor.builder()
				.nombre("Jimena")
				.primerApellido("Gonzalez")
				.segundoApellido("Sanch")
				.genero(Genero.MUJER)
				.fechadeAltaenlaFacultad(LocalDate.now())
				.salario(new BigDecimal(5000))
				.facultad(facultad5)
			.build();

			Profesor profesor3 = Profesor.builder()
				.nombre("Javier")
				.primerApellido("Gonzalez")
				.segundoApellido("Sanchez")
				.genero(Genero.HOMBRE)
				.fechadeAltaenlaFacultad(LocalDate.now())
				.salario(new BigDecimal(5000))
				.facultad(facultad2)
			.build();

			Profesor profesor4 = Profesor.builder()
				.nombre("Alberto")
				.primerApellido("Gonzalez")
				.segundoApellido("Sanchez")
				.genero(Genero.HOMBRE)
				.fechadeAltaenlaFacultad(LocalDate.now())
				.salario(new BigDecimal(5000))
				.facultad(facultad1)
			.build();

			profesorService.saveProfesor(profesor1);
			profesorService.saveProfesor(profesor2);
			profesorService.saveProfesor(profesor3);
			profesorService.saveProfesor(profesor4);
	}

}