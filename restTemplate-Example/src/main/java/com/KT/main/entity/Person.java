package com.KT.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id @GeneratedValue
	private Long id;

	private String name;

	private String prenom;

	private int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String prenom, int age) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.age = age;
	}

}
