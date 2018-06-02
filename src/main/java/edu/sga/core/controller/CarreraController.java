package edu.sga.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import edu.sga.core.model.Carrera;
import edu.sga.core.service.CarreraService;

@Controller
@RequestMapping("/api/v1")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;
	
	@RequestMapping(value="/carrera",method = RequestMethod.GET,headers ="Accept=application/json")
	
	public ResponseEntity<List<Carrera>> getCarrera(@RequestParam(value="descripcion",required=false) String descripcion){
	
		List<Carrera> carreras = new ArrayList<Carrera>();
		if(descripcion != null) {
			Carrera elemento = carreraService.findByDescription(descripcion);
			if(elemento==null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			} else {
			carreras.add(elemento);
			}
		}else {
			carreras = carreraService.findAllCarreras();
			if(carreras.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<List<Carrera>>(carreras,HttpStatus.OK);
	}
	
	// get findbyid
	@RequestMapping(value="/carrera/{id}",method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Carrera> getCarreraById(@PathVariable("id") Long id){
		Carrera elemento = carreraService.findById(id);
		if(elemento==null) {
			return new ResponseEntity<Carrera>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Carrera>(elemento,HttpStatus.OK);
	}
	// post crear
	@RequestMapping(value="/carrera",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<?> createCarrera(@RequestBody Carrera carrera,UriComponentsBuilder ucBuilder){
		
		if(carreraService.findByDescription(carrera.getDescripcion()) != null) {
			return new ResponseEntity("Existe una carrera con esta descripcion",HttpStatus.CONFLICT);
		}
		carreraService.saveCarrera(carrera);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/v1/carrera/{id}").buildAndExpand(carrera.getCodigoCarrera()).toUri());
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}
	// Delete
	@RequestMapping(value="/carrera/{id}", method = RequestMethod.DELETE,headers="Accept=application/json")
	public ResponseEntity<?> deleteCarrera(@PathVariable("id") Long id){
		if(id == null || id <= 0) {
			return new ResponseEntity("Debe ingresar un id",HttpStatus.CONFLICT);
		}
		Carrera elemento = carreraService.findById(id);
		if(elemento==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		carreraService.deleteCarreraById(id);
		return new ResponseEntity<Carrera>(HttpStatus.OK);
		
	}
	// update
	@RequestMapping(value="/carrera/{id}",method = RequestMethod.PATCH,headers="Accept=application/json")
	public ResponseEntity<Carrera> updateCarrera(@PathVariable("id") Long id, @RequestBody Carrera carrera) {
		
		if(id == null || id <= 0) {
			return new ResponseEntity("Debe de ingresar un codigo",HttpStatus.CONFLICT);
		}
		Carrera elemento = carreraService.findById(id);
		if(elemento==null) {
			return new ResponseEntity("",HttpStatus.NO_CONTENT);
		}
		elemento.setDescripcion(carrera.getDescripcion());
		carreraService.updateCarrera(elemento);
		return new ResponseEntity<Carrera>(elemento,HttpStatus.OK);
	}
	
}
