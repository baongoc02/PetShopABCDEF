package com.petshop.servlets.admin.product;

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
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Product;

@WebServlet("/admin/product-management/update")
public class AdminUpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	
    public AdminUpdateProductServlet() {
        super();
        this.productDAO = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));

		product.setId(productId);
		product.setProductName(productName);
		product.setPrice(productPrice);
		product.setProductCode(productCode);
		
		this.productDAO.updateProduct(product);

		request.setAttribute("success_messages", new String[] { "Cập nhật sản phẩm thành công" });
		response.sendRedirect("/PetShop/admin/product-management/edit?productId="+productId);
	}
}