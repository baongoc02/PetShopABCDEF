package com.petshop.servlets.admin.order;

import java.io.IOException;

import com.petshop.hibernate.daos.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/order-management/update-detail-status")
public class UpdateOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDAO orderDAO;

    public UpdateOrderStatusServlet() {
    	super();
    	this.orderDAO = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String newStatus = request.getParameter("status");
		
		System.out.println(newStatus);
		
		if (newStatus.equals("1"))
			newStatus = "OK";
		else
			newStatus = null;
		
		this.orderDAO.updateStatus(orderId, newStatus);
		
		response.sendRedirect("/PetShop/admin/order-management/details?orderId=" + orderId);
	}

}
