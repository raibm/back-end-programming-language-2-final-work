package com.lp2.lp2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/pessoas"})
public class Controlador {
	
	@Autowired
	PessoaRepositorio service;
	
	@GetMapping
	public List<Pessoa>listar(){
		return service.findAll();
	}
	
	//Adicionando uma nova pessoa.
	@PostMapping
	public Pessoa salvar(@RequestBody Pessoa p) {
		return service.save(p);
	}
	
	@GetMapping(path = {"/{id}"})
	public Pessoa listarId(@PathVariable("id") int id) {
		return service.findOne(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public Pessoa editar(@RequestBody Pessoa p, @PathVariable("id") int id) {
		p.setId(id);
		return service.save(p);
	}
	
	@DeleteMapping(path= {"/{id}"})
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
	
}
