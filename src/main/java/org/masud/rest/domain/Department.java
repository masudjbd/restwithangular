package org.masud.rest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@Entity
@JsonAutoDetect
public class Department {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	public Department() {
		super();
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department(String string) {
		this.name=string;
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
	
	
	
}
