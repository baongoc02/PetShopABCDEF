package com.petshop.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public AdminFilter() {
        super();
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		boolean isAuthenticated = false, isAdmin = false;
		HttpServletRequest request = (HttpServletRequest)_request;
		
		if (request.getAttribute("isAuthenticated") != null)
			isAuthenticated = (boolean)request.getAttribute("isAuthenticated");
		if (request.getAttribute("isAdmin") != null)
			isAdmin = (boolean)request.getAttribute("isAdmin");
		
		if (!isAuthenticated) {
			HttpServletResponse response = (HttpServletResponse)(_response);
			request.setAttribute("error_messages", new String[] { "Vui lòng đăng nhập" });
			request.getRequestDispatcher("/WEB-INF/templates/shared/login.jsp")
				.forward(request, response);
		}
		else if (!isAdmin) {
			request.setAttribute("error_messages", new String[] { "Bạn không có quyền truy cập vào trang này" });
			HttpServletResponse response = (HttpServletResponse)(_response);
			request.getRequestDispatcher("/WEB-INF/templates/shared/index.jsp").forward(request, response);
		}
		else {
			chain.doFilter(request, _response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
