package com.crud.alberto.repository;

import com.crud.alberto.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer>{

}
