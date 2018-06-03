package edu.sga.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import edu.sga.core.model.Profesor;
import edu.sga.core.model.Puesto;
import edu.sga.core.service.ProfesorService;
import edu.sga.core.service.PuestoService;

@Controller
@RequestMapping("/api/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	@Autowired
	private PuestoService puestoService;
	
	@RequestMapping(value="/profesor",method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Profesor>> getProfesor(@RequestParam(value="codigoProfesor",required=false) Long codigoProfesor){
		
		List<Profesor> profesores = new ArrayList<Profesor>();
		if(codigoProfesor!=null) {
			Profesor elemento = profesorService.findById(codigoProfesor);
			if(elemento==null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			} else {
				profesores.add(elemento);
			}
		} else {
			profesores = profesorService.findAllProfesor();
			if(profesores.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			}
		}
		
		return new ResponseEntity<List<Profesor>>(profesores,HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(value="/profesor/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Profesor> getProfesorById(@PathVariable("id") Long codigoProfesor) {
		
		Profesor profesor = profesorService.findById(codigoProfesor);
		if(profesor==null) {
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Profesor>(profesor,HttpStatus.OK);
	}
	
	@RequestMapping(value="/profesor",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<?> createProfesor(@RequestBody Profesor profesor,UriComponentsBuilder ucBuilder) {
		
		Puesto puesto = puestoService.findById(profesor.getPuesto().getCodigoPuesto());
		profesor.setPuesto(puesto);
        profesorService.saveProfesor(profesor);
        
		UriComponents uriComponents = ucBuilder.path("/profesor/{id}").buildAndExpand(profesor.getCodigoProfesor());
		return ResponseEntity.created(uriComponents.toUri()).build();
		
	}
	
	
}
