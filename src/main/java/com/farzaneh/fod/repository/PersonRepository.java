package com.farzaneh.fod.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.farzaneh.fod.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	Optional<Person> findByPrincipalNameAndEmailAddress(String principalName, String emailAddress);

}
