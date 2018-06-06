package edu.sga.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sga.core.model.Alumno;
import edu.sga.core.service.AlumnoService;

@Controller
@RequestMapping("/api/v1")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	
	@RequestMapping(value="/alumno",method=RequestMethod.GET,headers="Accept=Application/json")
	public ResponseEntity<List<Alumno>> getAlumnoByNombre(@RequestParam(value="nombres",required=false) String nombre){
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		if(nombre!=null) {
			alumnos = alumnoService.findByNombre(nombre);
			if(nombre==null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}/*else {
				alumnos.add(elemento);	
			}*/
		}else {
			alumnos = alumnoService.findAllAlumnos();
			if(alumnos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<List<Alumno>>(alumnos,HttpStatus.ACCEPTED);
	}
	
	
}
