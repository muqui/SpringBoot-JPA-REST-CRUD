package com.crud.alberto.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crud.alberto.repository.*;
import com.crud.alberto.model.*;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	  PersonRepository personRepository;
	
	 @GetMapping("/people")
	  public ResponseEntity<List<Person>> getAllTutorials() {
	    try {
	      List<Person> persons = new ArrayList<Person>();	 
	      personRepository.findAll().forEach(persons::add);
	      return new ResponseEntity<>(persons, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 }
	 
	 @GetMapping("/person/{id}")
	  public ResponseEntity<Person> getTutorialById(@PathVariable("id") Integer id) {
	    Optional<Person> tutorialData = personRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PostMapping("/person")
	  public ResponseEntity<Person> createTutorial(@RequestBody Person person) {
	    try {
	      Person p = personRepository
	          .save(new  Person(person.getName(), person.getEmail(), person.getNationality()));
	      return new ResponseEntity<>(p, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 }
	 
	 @PutMapping("/person/{id}")
	  public ResponseEntity<Person> updateTutorial(@PathVariable("id") Integer id, @RequestBody Person tutorial) {
	    Optional<Person> tutorialData = personRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      Person _tutorial = tutorialData.get();
	      _tutorial.setName(tutorial.getName());
	      _tutorial.setEmail(tutorial.getEmail());
	      _tutorial.setNationality(tutorial.getNationality());
	      return new ResponseEntity<>(personRepository.save(_tutorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @DeleteMapping("/person/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
	    try {
	      personRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @DeleteMapping("/people")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    try {
	      personRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }
}
