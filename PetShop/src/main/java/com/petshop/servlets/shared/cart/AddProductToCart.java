package com.petshop.servlets.shared.cart;

import java.io.IOException;
import java.util.Base64;

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
//					cartValue = cookie.getValue(); 
					
////					Trước khi thêm sp mới vào cart ta cần biết thông tin của các sp đang có trong cart,
////					vì vậy ta cần giải mã chuỗi cookie để lấy giá trị
//					// Giải mã giá trị của cookie bằng Base64
                    String decodedValue = new String(Base64.getDecoder().decode(cookie.getValue()));
                    cartValue = decodedValue;
				}
			}
		}
		
		CartItemManager cartItemManaged = new CartItemManager(cartValue);
		cartItemManaged.addProduct(productId);
		
//		Cookie cookie = new Cookie("CART", cartItemManaged.toCookieValue());
//		cookie.setHttpOnly(true);
//		response.addCookie(cookie);
		
		Cookie cookie = new Cookie("CART", cartItemManaged.toCookieValue());
		String encodedValue = Base64.getEncoder().encodeToString(cookie.getValue().getBytes());
		// Thiết lập giá trị cho cookie đã được mã hóa
        cookie.setValue(encodedValue);
        cookie.setHttpOnly(true);
        // Thêm cookie vào phản hồi
        response.addCookie(cookie);
		
		response.sendRedirect("/PetShop/gio-hang");
	}
}
