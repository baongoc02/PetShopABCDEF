package com.petshop.servlets.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.entities.Order;

@WebServlet("/admin/order-management")
public class AdminListOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDAO orderDAO;
       
    public AdminListOrderServlet() {
        super();
        this.orderDAO = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<Order> orders = this.orderDAO.listOrders(currentPage, limit);
	    long numberOfOrders = this.orderDAO.numberOfOrders();
        
        request.setAttribute("listOrders", orders);
        request.setAttribute("pageSize", numberOfOrders);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/order-management/list-Orders.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}