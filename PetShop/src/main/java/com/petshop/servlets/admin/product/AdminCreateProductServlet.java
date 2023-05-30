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
import com.petshop.xss.XSSHelper;

@WebServlet("/admin/product-management/create")
public class AdminCreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
       
    public AdminCreateProductServlet() {
        super();
        this.productDAO = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		
		product.setProductName(request.getParameter("productName"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setProductCode(request.getParameter("productCode"));
		
		if (XSSHelper.checkStringContainXSS(product.getProductName())) {
			response.sendRedirect("/PetShop/admin/product-management?page=1&limit=50");
			return;
		}
		
		if (XSSHelper.checkStringContainXSS(product.getProductCode())) {
			response.sendRedirect("/PetShop/admin/product-management?page=1&limit=50");
			return;
		}
		
		this.productDAO.createProduct(product);
		
		request.setAttribute("success_messages", new String[] { "Tạo sản phẩm thành công" });
		response.sendRedirect("/PetShop/admin/product-management?page=1&limit=50");
	}
}