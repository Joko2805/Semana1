package com.example.demo.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.jwt.JwtRequest;
import com.example.demo.security.jwt.JwtResponse;
import com.example.demo.security.jwt.JwtTokenUtil;
import com.example.demo.service.UsuarioService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UsuarioService usuarioDetailService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public JwtAuthenticationController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
		authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		final UserDetails userDeils = usuarioDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDeils);
		return new ResponseEntity<>(new JwtResponse(token),HttpStatus.OK);
	}


	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
