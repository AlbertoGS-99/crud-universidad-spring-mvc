package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Profesor;
import com.example.Services.FacultadService;
import com.example.Services.ProfesorService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/profesores")
public class ProfesorController {

    private static final Logger LOG = Logger.getLogger("EstudianteController");

    private final ProfesorService profesorService;
    private final FacultadService facultadService;

    @GetMapping("/listar")
    public String listarProfesores(Model model) {

        model.addAttribute("profesores", profesorService.getAllProfesores());

        return "listadoProfesores";

    }
    
    @GetMapping("/alta")
    public String mostrarformularioAlta(Model model,
        @ModelAttribute Profesor profesor) {
        
        model.addAttribute("facultades", facultadService.getAllFacultades());

        return "altaModificacionProfesores";
    }
    
    @PostMapping("/persistir")
    public String procesarFormularioAltaModificacion(
        @ModelAttribute Profesor profesor,
        Model model,
        @RequestParam(name = "file", required = false) MultipartFile file) {

        if (file != null && !file.isEmpty()) {
			
			Path relativePath = Paths.get("src/main/resources/static/imagenes/");
			String absolutePath = relativePath.toFile().getAbsolutePath();
			Path completePath = Paths.get(absolutePath + "/" + file.getOriginalFilename());

			try {

				byte[] bytesImagenRecibida = file.getBytes();
				Files.write(completePath, bytesImagenRecibida);
				profesor.setFotodelProfesor(file.getOriginalFilename());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if(profesor.getId() != 0){

			Profesor profesorAntiguo = profesorService.getProfesorById(profesor.getId());
			profesor.setFotodelProfesor(profesorAntiguo.getFotodelProfesor());
		}

        LOG.info("Profesor recibido :");
		LOG.info(profesor.toString());

        profesorService.saveProfesor(profesor);
        
        return "redirect:/profesores/listar";
    }
    
    @GetMapping("/detalles/{id}")
    public String detallesProfesor(Model model,
		@PathVariable(name = "id", required = true) int profesor_id) {

		model.addAttribute("profesor", profesorService.getProfesorById(profesor_id));

		return "detallesProfesor";

	}
    
    @GetMapping("/update/{id}")
    public String actualizarEmpleado(Model model,
		@PathVariable(name = "id", required = true) int profesor_id) {

        Profesor profesor = profesorService.getProfesorById(profesor_id);

        model.addAttribute("profesor", profesor);
        model.addAttribute("facultades", facultadService.getAllFacultades());

        String foto = profesor.getFotodelProfesor();

        LOG.info("foto "+ foto);

		if (foto != null) {
			
			model.addAttribute("foto", foto);

		}

        return "altaModificacionProfesores";

    }
    
    @GetMapping("/delete/{id}")
    public String deleteEstudiante(Model model,
		@PathVariable(name = "id", required = true) int profesor_id) {

        Profesor profesor = profesorService.getProfesorById(profesor_id);

        String foto = profesor.getFotodelProfesor();

		Path relativePath = Paths.get("src/main/resources/static/imagenes/");
		String absolutePath = relativePath.toFile().getAbsolutePath();
		Path completePath = Paths.get(absolutePath + "/" + foto);

		if (foto != null) {
			try {
				Files.delete(completePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		profesorService.deleteProfesorById(profesor_id);

		return "redirect:/profesores/listar";

    }
    

}