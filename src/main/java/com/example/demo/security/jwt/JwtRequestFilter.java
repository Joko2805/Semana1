package com.example.demo.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.UsuarioService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsuarioService userDetailService;

	public JwtRequestFilter() {

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("Filtro que intercepta el request");
		String uri = request.getRequestURI();
		System.out.println(request);

		if (!uri.contains("/authenticate") && !uri.contains("/instructor/listar_public")) {
			final String requestTokenHeader = request.getHeader("Authorization");
			String username = null;
			String jwtToken = null;

			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				// Token esta presente
				jwtToken = requestTokenHeader.substring(7);
				username = jwtTokenUtil.getUsernameFromToken(jwtToken); // autentica el token
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailService.loadUserByUsername(username);
					if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
						UsernamePasswordAuthenticationToken userPasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
								userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
						userPasswordAuthenticationToken
								.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(userPasswordAuthenticationToken);
					} else {
						System.out.println("Token invalido");
						throw new ExpiredJwtException(null, null, jwtToken);
					}
				}
			} else {
				// No esta el token
				System.out.println("El token de autenticación no está presente");
				throw new IllegalArgumentException("Token de autenticación invalida");
			}
		}
		filterChain.doFilter(request, response);
	}
}
