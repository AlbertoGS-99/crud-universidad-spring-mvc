package com.example.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.model.Genero;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Estudiante {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;


    @NotNull(message = "El nombre no puede estar vacio")
	@NotBlank(message = "El nombre no puede contener espacios en blanco, solamente")
	@Size(min = 4, max = 30, message = "El nombre tiene que estar entre 4 y 30 caracteres")
    @Pattern(regexp = "^([A-ZÁÉÍÓÚÑ][a-záéíóúüñ]+(\s)?)+$", message = "El nombre solo puede contener los caracteres de la A a la Z y su primer caracter a de ser una letra mayuscula (A-Z)")
    private String nombre;

    @NotNull(message = "El primer apellido no puede estar vacio")
	@NotBlank(message = "El primer apellido no puede contener espacios en blanco, solamente")
	@Size(min = 4, max = 30, message = "El primer apellido tiene que estar entre 4 y 30 caracteres")
    @Pattern(regexp = "^([A-ZÁÉÍÓÚÑ][a-záéíóúüñ]+(\s)?)+$", message = "El primer apellido solo puede contener los caracteres de la A a la Z y su primer caracter a de ser una letra mayuscula (A-Z)")
    private String primerApellido;

    @NotNull(message = "El segundo apellido no puede estar vacio")
	@NotBlank(message = "El segundo apellido no puede contener espacios en blanco, solamente")
	@Size(min = 4, max = 30, message = "El segundo apellido tiene que estar entre 4 y 30 caracteres")
    @Pattern(regexp = "^([A-ZÁÉÍÓÚÑ][a-záéíóúüñ]+(\s)?)+$", message = "El segundo apellido solo puede contener los caracteres de la A a la Z y su primer caracter a de ser una letra mayuscula (A-Z)")
    private String segundoApellido;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha de Matriculacion no puede ser inferior a la fecha actual")
    private LocalDate FechadeMatriculacionFacultad;

    @ManyToOne(fetch = FetchType.LAZY)
    private Facultad facultad;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estudiante")
    @Builder.Default
    private Set<Telefono> telefonos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estudiante")
    @Builder.Default
    private Set<Correo> correos = new HashSet<>();

    // Nombre de archivo de la foto asociada al estudiante (opcional)
    private String foto;

}
