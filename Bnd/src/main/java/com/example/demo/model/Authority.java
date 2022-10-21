package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	
	private String authority1;
		
	public Authority(String authority1) {
		super();
		this.authority1 = authority1;
	}

	@Override
	public String getAuthority() {
		return this.authority1;
	}
	

}
