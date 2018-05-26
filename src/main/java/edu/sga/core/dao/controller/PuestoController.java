package edu.sga.core.dao.controller;

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

import edu.sga.core.model.Puesto;
import edu.sga.core.service.PuestoService;

@Controller
@RequestMapping("/api/v1")
public class PuestoController {

	@Autowired
	private PuestoService puestoService;
	
	@RequestMapping(value="/puesto",method=RequestMethod.GET,headers="Accept=Application/json")
	public ResponseEntity<List<Puesto>> getPuesto(@RequestParam(value="codigoPuesto",required=false) Long codigoPuesto ){
		
		List<Puesto> puestos = new ArrayList<Puesto>();
		if(codigoPuesto!=null) {
			Puesto elemento = puestoService.findById(codigoPuesto);
			if(elemento==null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			} else {
			puestos.add(elemento);
			}
		} else {
			puestos = puestoService.findAllPuesto();
			if(puestos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
		
		return new ResponseEntity<List<Puesto>>(puestos,HttpStatus.ACCEPTED);
	}
	// get findbyid
	@RequestMapping(value="/puesto/{id}",method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Puesto> getPuestoById(@PathVariable("id") Long id){
		Puesto elemento = puestoService.findById(id);
		if(elemento==null) {
			return new ResponseEntity<Puesto>(HttpStatus.NOT_FOUND);
		}
			
			return new ResponseEntity<Puesto>(elemento,HttpStatus.OK);
		}
	
	@RequestMapping(value="/puesto",method=RequestMethod.POST,headers="Accept=application/json")	
	public ResponseEntity<?> createPuesto(@RequestBody Puesto puesto, UriComponentsBuilder ucBuilder) {
		
		puestoService.savePuesto(puesto);
		
		UriComponents uriComponents = ucBuilder.path("/puesto/{id}").buildAndExpand(puesto.getCodigoPuesto());
		
		return ResponseEntity.created(uriComponents.toUri()).build();
	}
}
