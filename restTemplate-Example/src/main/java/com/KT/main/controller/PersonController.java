package com.KT.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KT.main.entity.Person;
import com.KT.main.service.PersonService;

@RestController
@RequestMapping(path = "persons")
public class PersonController {

	@Autowired
	PersonService personService;
	
	public PersonController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/addPerson")
	public String addPerson(@RequestBody Person person){
		return personService.createPerson(person);
	}
	
	@GetMapping("/getPersons")
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	@GetMapping("/personById/{Id}")
	public Person getPersonById(@PathVariable("Id") Long id) {
		return personService.getPersonById(id);
	}
	
	@DeleteMapping("/deletePersonById/{Id}")
	public String deletePersonById(@PathVariable("Id") Long id) {
		return personService.deletePerson(id);
	}
}
