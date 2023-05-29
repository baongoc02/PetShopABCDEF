package com.petshop.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import com.petshop.hibernate.daos.UserDAO;
import com.petshop.hibernate.entities.User;

public class AuthorizationFilter extends HttpFilter implements Filter {

	private final UserDAO userDAO;
	
  public AuthorizationFilter() {
      super();
      
      this.userDAO = new UserDAO();
  }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest _request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)_request;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			boolean isAuthenticated = false, isAdmin = false;
			String userName = "";
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login-id")) {
					try {
						int userId = Integer.parseInt(cookie.getValue());
						User user = this.userDAO.getUserById(userId);
						if (user != null) {
							userName = user.getUsername();
							isAuthenticated = true;
							if (user.getRole().equals("ADMIN")) {
								isAdmin = true;
							}
						}
					}
					catch (Exception e) { }
				}
			}
			
			if (isAuthenticated) {
				request.setAttribute("isAuthenticated", true);
				request.setAttribute("username", userName);
				request.setAttribute("isAdmin", isAdmin);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
