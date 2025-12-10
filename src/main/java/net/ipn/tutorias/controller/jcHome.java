package net.ipn.tutorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import net.ipn.tutorias.model.CUsuario;
import net.ipn.tutorias.service.IUsuarioService;

@Controller
public class jcHome {

	@Autowired
	private IUsuarioService serviceUsuario;

	@GetMapping("/")
	public String mostrarHome(HttpSession session, Authentication auth) {
		if(auth != null) {
			String username = auth.getName();
			System.out.println("Nombre de usario: " + username);
			System.out.println("Roles:");
			for (GrantedAuthority rol : auth.getAuthorities()) {
				System.out.println("-" + rol.getAuthority());
			}

			if (session.getAttribute("usuario") == null) {
				CUsuario usuario = serviceUsuario.obtenerPorCorreo(username);
				usuario.setPassword(null); // Para que no se pase la contraseña a la sesión
				session.setAttribute("usuario", usuario);
				
			}
		}
		return "home";
	}

	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}

	@GetMapping("/registro")
	public String mostrarRegistro(CUsuario usuario) {
		return "signin";
	}

	@PostMapping("/registro")
	public String guardarRegistro(CUsuario usuario, RedirectAttributes atributos) {
		serviceUsuario.guardar(usuario);
		atributos.addFlashAttribute("mensaje", "Usuario registrado correctamente! :D/");
		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String cerrarSesion(HttpServletRequest request, HttpSession session) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		session = null;
		return "redirect:/login";
	}

}
