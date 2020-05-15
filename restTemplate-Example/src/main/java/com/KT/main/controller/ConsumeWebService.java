package com.KT.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.KT.main.entity.Person;
import com.KT.main.entity.PersonList;

/**
 * @author younes.rabi
 *
 */
@RestController
public class ConsumeWebService {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/template/addPerson")
	public ResponseEntity<String> addPerson(@RequestBody Person person) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);
		return restTemplate.exchange("http://localhost:8080/persons/addPerson", HttpMethod.POST, entity, String.class);
	}

	@DeleteMapping("/template/deletePerson/{Id}")
	public ResponseEntity<String> deletePerson(@PathVariable("Id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8080/persons/deletePersonById/" + id, HttpMethod.DELETE, entity,
				String.class);
	}

	// Find all persons using Rest Template
	@RequestMapping(value = "/template/persons", method = RequestMethod.GET)
	public List<Person> getPersons() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// Mapping the response Using Object ( type of return List<Person> )
		PersonList response = restTemplate.getForObject("http://localhost:8080/persons/getPersons", PersonList.class);
		return response.getPersons();

		// Using Arrays (method getForEntity) ( type of return ResponseEntity<Person[]>
		// )
//		ResponseEntity<Person[]> listPerson = restTemplate.getForEntity(
//				  "http://localhost:8080/persons/getPersons",
//				  Person[].class);
//		return listPerson;
	}

	// Find Person By Id using Rest Template
	@RequestMapping(value = "/template/persons/{Id}", method = RequestMethod.GET)
	public Person getPersonById(@PathVariable("Id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Person response = restTemplate.getForObject("http://localhost:8080/persons/personById/" + id, Person.class);
		return response;

//	 Person p1 = restTemplate
//				.exchange("http://localhost:8080/persons/personById/" + id, HttpMethod.GET, entity, Person.class)
//				.getBody();
//	 return p1;
	}

	public ConsumeWebService() {
		// TODO Auto-generated constructor stub
	}

}
