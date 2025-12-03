package net.ipn.tutorias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutorias")
public class jcTutorias {

	@GetMapping("/")
	public String mostrarTutorias() {
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

}
