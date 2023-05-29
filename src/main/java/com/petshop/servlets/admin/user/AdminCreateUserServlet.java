package com.petshop.servlets.admin.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.daos.UserDAO;
import com.petshop.hibernate.entities.User;

@WebServlet("/admin/user-management/create")
public class AdminCreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserDAO userDAO;
       
    public AdminCreateUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		
		
		user.setUsername(request.getParameter("username"));
		
		
		
		user.setPassword(request.getParameter("password"));
		
		
		
		user.setFullName(request.getParameter("fullName"));
		
		
		
		user.setRole(request.getParameter("role"));
		
		
		
		user.setAddress(request.getParameter("address"));
		
		
		
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		
		
		
		this.userDAO.createUser(user);
		
		request.setAttribute("success_messages", new String[] { "Tạo người dùng thành công" });
		response.sendRedirect("/PetShop/admin/user-management?page=1&limit=50");
	}
}