package com.petshop.servlets.shared;

import java.io.IOException;

import com.petshop.hibernate.daos.UserDAO;
import com.petshop.hibernate.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SharedSignupController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final UserDAO userDAO;

    public SharedSignupController() {
    	super();
    	
    	this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		request.getRequestDispatcher("/WEB-INF/templates/shared/signup.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String username = request.getParameter("userName");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		
		if (this.userDAO.checkUserExistedByUsername(username)) {
			request.setAttribute("error_messages", new String[] { "Tên đăng nhập đã tồn tại" });
			request.getRequestDispatcher("/WEB-INF/templates/shared/signup.jsp").forward(request, response);
			return;
		}
		
		if (this.userDAO.checkUserExistedByPhoneNumber(phoneNumber)) {
			request.setAttribute("error_messages", new String[] { "Số điện thoại này đã được sử dụng" });
			request.getRequestDispatcher("/WEB-INF/templates/shared/signup.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		
		user.setUsername(username);
		user.setFullName(fullName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		user.setRole("NORMAL");
		
		this.userDAO.createUser(user);
		
		request.getRequestDispatcher("/WEB-INF/templates/shared/login.jsp").forward(request, response);
	}

}
