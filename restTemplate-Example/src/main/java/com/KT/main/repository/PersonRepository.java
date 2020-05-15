package com.KT.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.KT.main.entity.Person;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long>{

}
