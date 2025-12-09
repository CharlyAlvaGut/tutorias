package net.ipn.tutorias.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.ipn.tutorias.model.Clase;
import net.ipn.tutorias.service.IClaseService;

@Controller
@RequestMapping("/tutorias")
public class jcTutorias {
	
	@Autowired
	IClaseService serviceClases;

	@GetMapping("/")
	public String mostrarTutorias(Model modelo) {
		modelo.addAttribute("clases", serviceClases.buscarTodos());
		return "/tutorias/tutorias";
	}

	@GetMapping("/tutores")
	public String mostrarTutores(Model modelo) {
		modelo.addAttribute("titulo", "Tutores");
		modelo.addAttribute("descripcion",
				"En esta sección podrás gestionar a los especialistas que brindan apoyo académico dentro de la plataforma. Aquí podrás consultar su área de conocimiento, disponibilidad, materias que imparten y los alumnos que tienen asignados. Esta vista facilita la organización del personal docente y garantiza que cada estudiante reciba el acompañamiento adecuado por parte del tutor más apto.");
		modelo.addAttribute("titulo_tabla","Listado de Tutores");
		return "/tutorias/lista";
	}

	@GetMapping("/alumnos")
	public String mostrarTutorados(Model modelo) {
		modelo.addAttribute("titulo", "Alumnos");
		modelo.addAttribute("descripcion",
				"En esta sección podrás gestionar de forma organizada a los estudiantes registrados en la plataforma. Aquí podrás consultar información esencial como su carrera, semestre, progreso académico y tutor asignado. Esta vista facilita el seguimiento, administración y apoyo personalizado para cada alumno, permitiendo una experiencia educativa más eficiente y centralizada.");
		modelo.addAttribute("titulo_tabla","Listado de Alumnos");
		return "/tutorias/lista";

	}
	
	@GetMapping("/form")
	public String mostrarForm(Clase clase, Model modelo) {
		return "/tutorias/form";
	}
	
	@PostMapping("/save")
	public String guardarClase(Clase clase, BindingResult resultado, RedirectAttributes atributos) {
		//System.out.println(resultado.toString());
		if (resultado.hasErrors()) {
			for (ObjectError e : resultado.getAllErrors()) {
				System.out.println("Ocurrió un error! :( " + e.getDefaultMessage());

			}
			return "tutorias/form";
		}
		
		clase.setFecha(new Date());
		
		serviceClases.guardar(clase);
		
		System.out.println(clase);

		atributos.addFlashAttribute("mensaje", "Vacante agregada correctamente! :D");
		return "redirect:/tutorias/"; // Peticion GET a index

	}

}
