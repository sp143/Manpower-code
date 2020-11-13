package com.sp.manpwr.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {
		// Authentication failed, send error response.
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Authenticate", "Basic realm= MY_TEST_REALM");

		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 : " + authException.getMessage());
	}

}