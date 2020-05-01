package com.luv2code.boot.thymeleaf.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.luv2code.boot.thymeleaf.entity.Employee;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

		String userName = authentication.getName();

		System.out.println("userName=" + userName);

		Employee theEmployee = new Employee();
		theEmployee.setFirstName(userName);
		theEmployee.setLastName("lastName");
		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("employee", theEmployee);

		// forward to home page

		response.sendRedirect(request.getContextPath() + "/");
	}

}
