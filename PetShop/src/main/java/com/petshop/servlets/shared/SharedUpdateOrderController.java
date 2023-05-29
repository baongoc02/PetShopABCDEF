package com.petshop.servlets.shared;

import java.io.IOException;

import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.entities.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/don-hang/update")
public class SharedUpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDAO orderDAO;

    public SharedUpdateOrderController() {
    	super();
        this.orderDAO = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Order order = this.orderDAO.getOrderById(orderId);
		this.orderDAO.updateStatus(orderId, "Đã nhận hàng");
		response.sendRedirect("/PetShop/don-hang");
	}

}
