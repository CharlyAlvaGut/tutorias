package net.ipn.tutorias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flowdocs")
public class jcFlowDocs {
	
	@GetMapping("/")
	public String mostrarFlowDocs() {
		return "/flowdocs/flowdocs";
	}
	
}
