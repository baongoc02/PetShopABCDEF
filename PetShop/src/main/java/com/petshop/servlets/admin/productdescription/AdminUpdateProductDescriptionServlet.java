package com.petshop.servlets.admin.productdescription;

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
import com.petshop.hibernate.daos.ProductDescriptionDAO;
import com.petshop.hibernate.entities.ProductDescription;
import com.petshop.xss.XSSHelper;

@WebServlet("/admin/productDescription-management/update")
public class AdminUpdateProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDescriptionDAO productDescriptionDAO;
	
    public AdminUpdateProductDescriptionServlet() {
        super();
        this.productDescriptionDAO = new ProductDescriptionDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDescription productDescription = new ProductDescription();

		productDescription.setId(Integer.parseInt(request.getParameter("id")));
		
		
		productDescription.setType(request.getParameter("type"));
		
		
		
		productDescription.setOrder(Integer.parseInt(request.getParameter("order")));
		
		
		
		productDescription.setContent(request.getParameter("content"));
		
		
		
		productDescription.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		if (XSSHelper.checkStringContainXSS(productDescription.getType())) {
			response.sendRedirect("/PetShop/admin/product-management");
			return;
		}
		
		if (XSSHelper.checkStringContainXSS(productDescription.getContent())) {
			response.sendRedirect("/PetShop/admin/product-management");
			return;
		}
		
		
		
		this.productDescriptionDAO.updateProductDescription(productDescription);

		request.setAttribute("success_messages", new String[] { "Cập nhật thông tin sản phẩm thành công" });
		response.sendRedirect("/PetShop/admin/productDescription-management?page=1&limit=50");
	}
}