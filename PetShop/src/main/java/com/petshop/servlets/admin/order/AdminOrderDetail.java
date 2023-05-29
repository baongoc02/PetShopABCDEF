package com.petshop.servlets.admin.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.daos.OrderDAO;
import com.petshop.hibernate.daos.OrderDetailDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Order;
import com.petshop.hibernate.entities.OrderDetail;
import com.petshop.hibernate.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/order-management/details")
public class AdminOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderDetailDAO orderDetailDAO;
	private final ProductDAO productDAO;
	private final OrderDAO orderDAO;

    public AdminOrderDetail() {
    	super();
    	
    	this.orderDetailDAO = new OrderDetailDAO();
    	this.productDAO = new ProductDAO();
    	this.orderDAO = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = -11, limit = -1, orderId = -1;
		
		if (request.getParameter("orderId") != null)
			orderId = Integer.parseInt(request.getParameter("orderId"));
		
		List<OrderDetail> rawOrderDetails = this.orderDetailDAO.listOrderDetailsByOrderId(orderId);
		List<OrderDetailViewItem> orderDetails = new ArrayList<>();
		
		int totalPrice = 0;
		
		for (OrderDetail orderDetail : rawOrderDetails) {
			OrderDetailViewItem item = new OrderDetailViewItem();
			
			item.setId(orderDetail.getId());
			
			item.setOrderId(orderDetail.getOrderId());
			item.setProductId(orderDetail.getProductId());
			item.setQuantity(orderDetail.getQuantity());
			
			Product product = this.productDAO.getProductById(orderDetail.getProductId());
			
			item.setProductName(product.getProductName());
			item.setPrice(product.getPrice());
			
			orderDetails.add(item);
			
			totalPrice += item.getPrice() * item.getQuantity();
		}
		
		Order order = this.orderDAO.getOrderById(orderId);
		
		request.setAttribute("order", order);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("listOrderDetails", orderDetails);
		request.getRequestDispatcher("/WEB-INF/templates/admin/pages/order-management/order-details.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setStatus(405);
	}

}
