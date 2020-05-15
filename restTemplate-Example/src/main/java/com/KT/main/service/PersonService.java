package com.KT.main.service;

import java.util.List;

import com.KT.main.entity.Person;

/**
 * @author younes.rabi
 *
 */
public interface PersonService {

	Person getPersonById(Long Id);
	
	List<Person> getPersons();
	
	String deletePerson(Long id);
	
	String createPerson(Person person);
}
