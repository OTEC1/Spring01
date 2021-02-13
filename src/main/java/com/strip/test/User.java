package com.strip.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class User {
	
	private String id;
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String rsaPublicKey;
	
	@JsonIgnore
	private String rsaPrivateKey;
	
	@JsonIgnore
	private String aesKey;

	
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
