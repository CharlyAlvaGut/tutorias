package net.ipn.tutorias.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import net.ipn.tutorias.dto.DocumentoDTO;
import net.ipn.tutorias.dto.FlujoDTO;
import net.ipn.tutorias.dto.PublicacionDTO;
import net.ipn.tutorias.model.CDocumento;
import net.ipn.tutorias.model.CFlujo;
import net.ipn.tutorias.model.CPublicacion;
import net.ipn.tutorias.model.CUsuario;
import net.ipn.tutorias.service.IDocumentoService;
import net.ipn.tutorias.service.IFlujoService;
import net.ipn.tutorias.service.IPublicacionService;


@Controller
@RequestMapping("/flowdocs")
public class jcFlowDocs {

	@Autowired
	private IPublicacionService servicePublicacion;
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@Autowired
	private IFlujoService serviceFlujo;
	
	@GetMapping("/{id}")
	public String mostrarFlowDocs(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		return "/flowdocs/flowdocs";
	}
	
	@GetMapping("/{id}/tablon")
	@ResponseBody
	public List<PublicacionDTO> mostrarFragmento(@PathVariable Integer id, Model model) {
		List<PublicacionDTO> lista = servicePublicacion.buscarPublicacionesPorClase(id);
		return lista;
	}
	
	@GetMapping("/{id}/documentos")
	@ResponseBody
	public List<DocumentoDTO> mostrarDocumentos(@PathVariable Integer id, Model model) {
		List<DocumentoDTO> lista = serviceDocumento.obtenerDocumentos(id);
		return lista;
	}
	
	
	@GetMapping("/{id}/descargar")
	public ResponseEntity<byte[]> descargarDocumentos(@PathVariable Integer id) {
		CDocumento doc = serviceDocumento.obtenerPorId(id);
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION,
		                "attachment; filename=\"" + doc.getNombre() + "\"")
		        .contentType(MediaType.APPLICATION_OCTET_STREAM)
		        .body(doc.getDocumento());
	}
	
	
	@PostMapping("/save")
	public String guardar(@RequestParam("publicacion") String publicacion, @RequestParam("idClase") Integer id,@RequestParam("documento") MultipartFile[] documentos,HttpSession session, RedirectAttributes atr) {
		CPublicacion pub = new CPublicacion();
	    pub.setDescripcion(publicacion);
	    pub.setFecha(new Date());
	    pub.setIdUsuario(((CUsuario) session.getAttribute("usuario")).getId());
	    pub.setIdClase(id);//Pendiente obtener la clase a la que se le publica
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
	    atr.addFlashAttribute("mensaje", "Se guardó el registro correctamente");
	    return "redirect:"+id;
	}
	
	@GetMapping("/{clase}/{id}/{estatus}/saveEstatus")
	public String guardar(HttpSession session,@PathVariable Integer clase, @PathVariable Integer id, @PathVariable Integer estatus, RedirectAttributes atributos) {
		CUsuario u = (CUsuario) session.getAttribute("usuario");
		CFlujo flujo = new CFlujo();
		flujo.setIdDocumento(id);
		flujo.setIdEstatus(estatus);
		flujo.setIdUsuario(u.getId());
		flujo.setIdClase(clase);
		flujo.setFecha(new Date());
		serviceFlujo.guardar(flujo);
		atributos.addFlashAttribute("mensaje", "Se guardó el registro correctamente");
		return "redirect:"+clase;
	}

	
	@GetMapping("/{id}/mostrar")
	@ResponseBody
	public List<FlujoDTO> mostrarFlujo(@PathVariable Integer id) {
		System.err.println(id);
		List<FlujoDTO> lista = serviceFlujo.obtenerFlujos(id);
		return lista;
	}
}
