package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Product;
import com.petshop.servlets.shared.cart.CartItemManager;

@WebServlet("/gio-hang")
public class SharedCartController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;

    public SharedCartController() {
    	super();
    	this.productDAO = new ProductDAO();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		request.getRequestDispatcher("/WEB-INF/templates/shared/cart.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		CartItemManager cartItemManaged = this.getCartItemManager(request, response);
		List<CartItem> deletedCart = new ArrayList<>();
		for (CartItem cartItem : cartItemManaged.toListCartsItems()) {
			String productNameFromRequest = "productId-" + cartItem.getProductId();
			int num = Integer.parseInt(request.getParameter(productNameFromRequest));
			if (num <= 0) {
				deletedCart.add(cartItem);
			}
			cartItem.setNum(num);
		}
		for (CartItem cartItem : deletedCart) {
			cartItemManaged.removeProduct(cartItem.getProductId());
		}
//		response.addCookie(new Cookie("CART", cartItemManaged.toCookieValue()));
//		response.sendRedirect("/PetShop/thanh-toan");
		
		 // Mã hóa giá trị của cookie bằng Base64
		Cookie cookie = new Cookie("CART", cartItemManaged.toCookieValue());
		String encodedValue = Base64.getEncoder().encodeToString(cookie.getValue().getBytes());
		// Thiết lập giá trị cho cookie đã được mã hóa
        cookie.setValue(encodedValue);
        System.out.print("encodedValue:"+ encodedValue);
        // Thêm cookie vào phản hồi
        response.addCookie(cookie);
        response.sendRedirect("/PetShop/thanh-toan");
		
	}
}
