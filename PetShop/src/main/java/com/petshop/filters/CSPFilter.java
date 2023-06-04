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
                    + "https://ajax.googleapis.com https://code.jquery.com https://cdn.jsdelivr.net js 'unsafe-inline'; "
                    + "style-src 'self' *.googleapis.com cdn.jsdelivr.net css 'unsafe-inline'; font-src 'self' data: *.googleapis.com "
                    + "cdn.jsdelivr.net "
                    + "fonts.gstatic.com 'unsafe-inline'; frame-ancestors 'self'; form-action 'self'; "
                    + "img-src 'self' phukienpet.vn lorempixel.com http://theartmad.com 'unsafe-inline';"
                    + "frame-src 'self' https://www.google.com/");	
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
