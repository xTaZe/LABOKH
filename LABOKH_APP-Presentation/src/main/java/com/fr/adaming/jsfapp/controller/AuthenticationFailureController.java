package com.fr.adaming.jsfapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationFailureController extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String idAuth = request.getParameter("submit");

		if (idAuth != null && !idAuth.isEmpty()) {
			if (idAuth.equals("2")) {
				response.sendRedirect("login.jsf?state=failure");

			} else {
				response.sendRedirect("login.jsf?state=failure");

			}

		} else {
			response.sendRedirect("login.jsf?state=failure");

		}
	}

}
