package com.KT.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KT.main.entity.Person;
import com.KT.main.repository.PersonRepository;
import com.KT.main.service.PersonService;

/**
 * @author younes.rabi
 *
 */
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;
	
	public PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Person getPersonById(Long Id) {
		// TODO Auto-generated method stub
		 Optional<Person> person = personRepository.findById(Id);
		 return person.get();
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public String deletePerson(Long id) {
		// TODO Auto-generated method stub
		if(personRepository.existsById(id)) 
		personRepository.deleteById(id);
		else
			return "User doesn't exist";
		boolean result = personRepository.existsById(id);
		return (result) ? "User not deleted" : "User deleted succesfully";
	}

	@Override
	public String createPerson(Person person) {
		// TODO Auto-generated method stub
		Person addedPerson = personRepository.save(new Person(person.getName(), person.getPrenom(), person.getAge()));
		return (addedPerson!=null) ? "User Added Successfully" : "User Not Added Successfully";
	}

}
