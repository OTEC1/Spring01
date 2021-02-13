package com.strip.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String  generateUserid() {
		return UUID.randomUUID().toString();
	}
	
}
