package com.javasampleapproach.springintegration.inbound.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Customer")
public class Customer {
	
	
	private Test t;
	
	@NotNull(message="id cannot be null")
	private Integer id;
	@NotNull(message="name cannot be empty")
	private String name;
	@NotNull(message="age cannot be null")
	private Integer age;
	
	private List<Test> Testlist;
	
	public Customer(){
		super();
	}
	
	
	public Customer(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
		
	}
	
	public Customer(int id, String name, int age,Test t,List<Test> list){
		this.id = id;
		this.name = name;
		this.age = age;
		this.t=t;
		this.Testlist=list;
	}
	
	public int getId() {
		return id;
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

	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		String info = String.format("Customer with id = %d, name = %s, age = %d", id, name, age);
		return info;
	}


	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}

	@XmlElementWrapper(name="TestList")
	@XmlElement(name="test")
	public List<Test> getList() {
		return Testlist;
	}

	public void setList(List<Test> list) {
		this.Testlist = list;
	}
}
