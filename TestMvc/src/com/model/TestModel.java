package com.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class TestModel {

	@NotBlank(message="name cant be empty")
	String name;
	//@NotEmpty(message="age cant be empty")
	//@Min(value=18)
	///@Max(value=59)
	int age;
	int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TestModel(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public TestModel() {
		super();
	}
	
}
