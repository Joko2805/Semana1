package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario =  repository.findUserByEmail(email);
		if(usuario == null) 
			throw new UsernameNotFoundException("Email no encontrado: "+email);
		else {
			Usuario userData = repository.findById(usuario.get().getId()).get();
			List<Rol> roles = (List<Rol>) userData.getRoles();
			Set<GrantedAuthority> ga = new HashSet<>();
			for(Rol item : roles)
				ga.add(new SimpleGrantedAuthority(item.getName()));
			User springSessionuser = new User(email, userData.getPassword(),ga);
			return springSessionuser;
		}	
	}
	
	public Integer saveUser(Usuario user) {
		String passWs = user.getPassword();
		String encondedPassword = passwordEncoder.encode(passWs);
		user.setPassword(encondedPassword);
		user = repository.save(user);
		return user.getId();
	}

}
