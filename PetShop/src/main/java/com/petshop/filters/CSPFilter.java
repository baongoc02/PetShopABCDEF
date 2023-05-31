package com.petshop.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class CSPFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
    		throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (httpResponse.getHeader("Content-Security-Policy") == null) {
            httpResponse.setHeader("Content-Security-Policy", "default-src 'self'; script-src 'self' "
                    + "ajax.googleapis.com code.jquery.com cdn.jsdelivr.net 'unsafe-inline'; "
                    + "style-src 'self' *.googleapis.com cdn.jsdelivr.net 'unsafe-inline'; font-src 'self' data: *.googleapis.com "
                    + "cdn.jsdelivr.net "
                    + "fonts.gstatic.com 'unsafe-inline'; frame-ancestors 'none'; worker-src 'self'; form-action 'self'; "
                    + "img-src 'self' phukienpet.vn lorempixel.com 'unsafe-inline'");	
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
