package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.petshop.hibernate.daos.UserDAO;
import com.petshop.hibernate.entities.User;

@WebServlet("/login")
public class SharedLoginController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final UserDAO userDAO;
       
    public SharedLoginController() {
        super();
        this.userDAO = new UserDAO();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		if (request.getAttribute("isAuthenticated") != null && (boolean)request.getAttribute("isAuthenticated")) {
			response.sendRedirect("/PetShop");
		}
		else
			request.getRequestDispatcher("/WEB-INF/templates/shared/login.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = this.userDAO.getUserByUsernameAndPassword(username, password);
		
		if (user != null) {
			Cookie cookie = new Cookie("login-id", Integer.toString(user.getId()));
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
			response.sendRedirect("/PetShop");
		}
		else {
			request.setAttribute("error_messages", new String[] { "Tên đăng nhập hoặc mật khẩu không đúng" });
			request.getRequestDispatcher("/WEB-INF/templates/shared/login.jsp").forward(request, response);
		}
	}
}
