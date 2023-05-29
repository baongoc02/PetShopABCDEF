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

@WebServlet("/admin/product-management/delete")
public class AdminDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	
    public AdminDeleteProductServlet() {
        super();
        this.productDAO = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("productId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		this.productDAO.deleteProductById(productId);
		
        request.setAttribute("success_messages", new String[] { "Tạo sản phẩm thành công" });
        
        //RequestDispatcher rd = request.getRequestDispatcher("/admin/product-management");
        //rd.include(request, response);
        
		response.sendRedirect("/PetShop/admin/product-management");
	}
}