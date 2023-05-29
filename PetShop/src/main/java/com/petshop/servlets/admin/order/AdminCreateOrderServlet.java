package com.petshop.servlets.admin.order;

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
import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.entities.Order;

@WebServlet("/admin/order-management/create")
public class AdminCreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDAO orderDAO;
       
    public AdminCreateOrderServlet() {
        super();
        this.orderDAO = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
		
		
		
		order.setDeliveredAt(Date.valueOf(request.getParameter("deliveredAt")));
		
		
		
		order.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		
		
		this.orderDAO.createOrder(order);
		
		request.setAttribute("success_messages", new String[] { "Tạo giỏ hàng thành công" });
		response.sendRedirect("/PetShop/admin/order-management?page=1&limit=50");
	}
}