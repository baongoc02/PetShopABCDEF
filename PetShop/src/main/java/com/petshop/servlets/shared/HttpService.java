package com.petshop.servlets.shared;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class HttpService {
  
    public static void addCookie(HttpServletResponse response, Cookie cookie, String sameSite) {

        StringBuilder c = new StringBuilder(64+cookie.getValue().length());

        c.append(cookie.getName());
        c.append('=');
        c.append(cookie.getValue());

        append2cookie(c,"domain",   cookie.getDomain());
        append2cookie(c,"path",     cookie.getPath());
        append2cookie(c,"SameSite", sameSite);

        if (cookie.getSecure()) {
            c.append("; secure");
        }
        if (cookie.isHttpOnly()) {
            c.append("; HttpOnly");
        }
        response.addHeader("Set-Cookie", c.toString());
    }

    private static void append2cookie(StringBuilder cookie, String key, String value) {
        if (key==null || 
                value==null || 
                key.trim().equals("") 
                || value.trim().equals("")) {
            return;
        }

        cookie.append("; ");
        cookie.append(key);
        cookie.append('=');
        cookie.append(value);
    }

}
