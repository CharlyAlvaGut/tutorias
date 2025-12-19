package net.ipn.tutorias.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import net.ipn.tutorias.model.CDocumento;
import net.ipn.tutorias.model.CPublicacion;
import net.ipn.tutorias.model.CUsuario;
import net.ipn.tutorias.service.IDocumentoService;
import net.ipn.tutorias.service.IPublicacionService;


@Controller
@RequestMapping("/flowdocs")
public class jcFlowDocs {

	@Autowired
	private IPublicacionService servicePublicacion;
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@GetMapping("/")
	public String mostrarFlowDocs() {
		
		return "/flowdocs/flowdocs";
	}
	
	@PostMapping("/save")
	public String guardar(@RequestParam("publicacion") String publicacion,@RequestParam("documento") MultipartFile[] documentos,HttpSession session) {
	    CPublicacion pub = new CPublicacion();
	    pub.setDescripcion(publicacion);
	    pub.setFecha(new Date());
	    pub.setIdUsuario(((CUsuario) session.getAttribute("usuario")).getId());
	    pub.setIdClase(8);//Pendiente obtener la clase a la que se le publica
	    pub = servicePublicacion.guardar(pub);

	    for (MultipartFile file : documentos) {

	        if (!file.isEmpty()) {

	            CDocumento doc = new CDocumento();
	            doc.setIdPublicacion(pub.getId());
	            doc.setNombre(file.getOriginalFilename());
	            try {
	            	doc.setDocumento(file.getBytes());
	            } catch (IOException e) {
	            	System.out.println("Error al obtener bytes del documento!");
	            }
	            serviceDocumento.guardar(doc);
	        }
	    }

	    return "redirect:/flowdocs/";
	}

}
