package com.crud.alberto.model;

import javax.persistence.*;


@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "name")
	String name;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "nationality")
	String nationality;
	
	public Person() {
		
	}

	public int getId() {
		return id;
	}
	
	
	public Person(String name, String email, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.nationality = nationality;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", nationality=" + nationality + "]";
	}
	
}
