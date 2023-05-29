package com.petshop.servlets.shared.cart;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/them-vao-gio-hang")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddProductToCart() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String cartValue = "";
		
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("CART")) {
					cartValue = cookie.getValue(); 
				}
			}
		}
		
		CartItemManager cartItemManaged = new CartItemManager(cartValue);
		cartItemManaged.addProduct(productId);
		
		response.addCookie(new Cookie("CART", cartItemManaged.toCookieValue()));
		
		response.sendRedirect("/PetShop/gio-hang");
	}
}
