package org.masud.rest.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@Entity
@JsonAutoDetect
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Department dept;
	
	
	public Employee(int i, String string) {
		this.id = i;
		this.name = string;
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

	public Employee() {
		super();
	}

	public Employee(String string) {
		this.name=string;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
