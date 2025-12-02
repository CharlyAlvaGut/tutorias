package net.ipn.tutorias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class jcHome {

	@GetMapping("/")
	public String mostrarHome() {
		return "home";
	}
}
