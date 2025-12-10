package net.ipn.tutorias.controller;

import java.util.Date;
import net.ipn.tutorias.service.db.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import net.ipn.tutorias.model.CClase;
import net.ipn.tutorias.model.CUsuario;
import net.ipn.tutorias.service.IClaseService;

@Controller
@RequestMapping("/tutorias")
public class jcTutorias {

	@Autowired
	private final UsuarioService usuarioService;

	@Autowired
	private IClaseService serviceClases;

	jcTutorias(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

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
		modelo.addAttribute("titulo_tabla", "Listado de Tutores");
		return "/tutorias/lista";
	}

	@GetMapping("/alumnos")
	public String mostrarTutorados(Model modelo) {
		modelo.addAttribute("titulo", "Alumnos");
		modelo.addAttribute("descripcion",
				"En esta sección podrás gestionar de forma organizada a los estudiantes registrados en la plataforma. Aquí podrás consultar información esencial como su carrera, semestre, progreso académico y tutor asignado. Esta vista facilita el seguimiento, administración y apoyo personalizado para cada alumno, permitiendo una experiencia educativa más eficiente y centralizada.");
		modelo.addAttribute("titulo_tabla", "Listado de Alumnos");
		return "/tutorias/lista";

	}

	@GetMapping("/form")
	public String mostrarForm(CClase clase) {
		return "/tutorias/form";
	}

	@PostMapping("/save")
	public String guardarClase(CClase clase, BindingResult resultado, HttpSession session,
			RedirectAttributes atributos) {
		if (resultado.hasErrors()) {
			for (ObjectError e : resultado.getAllErrors()) {
				System.out.println("Ocurrió un error! :( " + e.getDefaultMessage());

			}
			return "tutorias/form";
		}
		CUsuario user = (CUsuario) session.getAttribute("usuario");
		clase.setFecha(new Date());
		clase.setIdUsuario(user.getId()); // Agregar usuario que capturó (variable de sesión)

		serviceClases.guardar(clase);
		System.out.println(clase);
		atributos.addFlashAttribute("mensaje", "Tutoria agregada correctamente! :D");
		return "redirect:/tutorias/";

	}

	@GetMapping("/eliminar/{id}")
	public String eliminarTutoria(@PathVariable("id") int id, RedirectAttributes atributos) {
		serviceClases.eliminarClase(id);
		atributos.addFlashAttribute("mensaje", "La Tutoría ha sido eliminada con éxito!! :D");
		return "redirect:/tutorias/";
	}

	@GetMapping("/editar/{id}")
	public String editarTutoria(@PathVariable("id") Integer id, Model model, RedirectAttributes atributos) {
		CClase clase = serviceClases.obtenerPorId(id);
		model.addAttribute("CClase", clase); 
		atributos.addFlashAttribute("mensaje", "La Tutoría ha sido modfificada con éxito!! :D");
		return "tutorias/form"; 
	}

}
