package com.petshop.filters;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class ContentTypeFilter implements Filter {
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		Filter.super.init(filterconfig);
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("X-Content-Type-Options", "nosniff");
					
		
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
