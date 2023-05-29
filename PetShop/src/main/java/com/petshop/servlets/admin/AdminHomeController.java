package com.petshop.servlets.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.petshop.hibernate.daos.FeedBackDAO;
import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.daos.ProductDAO;

@WebServlet("/admin")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	private final OrderDAO orderDAO;
	private final FeedBackDAO feedbackDAO;
       
    public AdminHomeController() {
		super();
        this.productDAO = new ProductDAO();
		this.orderDAO = new OrderDAO();
		this.feedbackDAO = new FeedBackDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long numberOfProduct = productDAO.numberOfProducts();
		long numberOfOrder = orderDAO.numberOfOrders();
		long numberOfFeedback = feedbackDAO.numberOfFeedbacks();
		
		request.setAttribute("numberOfProduct", numberOfProduct);
		request.setAttribute("numberOfOrder", numberOfOrder);
		request.setAttribute("numberOfFeedback", numberOfFeedback);
		
		request.getRequestDispatcher("/WEB-INF/templates/admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
