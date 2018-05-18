package com.onpe.others;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {
	public String encodePass(String password){
		BCryptPasswordEncoder pe= new BCryptPasswordEncoder();
		String passwordencoded = pe.encode(password);
		return passwordencoded;
	}
}
