package com.petshop.servlets.admin.productimage;

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
import com.petshop.hibernate.daos.ProductImageDAO;
import com.petshop.hibernate.entities.ProductImage;

@WebServlet("/admin/productImage-management/update")
public class AdminUpdateProductImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductImageDAO productImageDAO;
	
    public AdminUpdateProductImageServlet() {
        super();
        this.productImageDAO = new ProductImageDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductImage productImage = new ProductImage();

		productImage.setId(Integer.parseInt(request.getParameter("id")));
		
		
		productImage.setOrder(Integer.parseInt(request.getParameter("order")));
		
		
		
		productImage.setProductImageLink(request.getParameter("productImageLink"));
		
		
		
		productImage.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		
		
		this.productImageDAO.updateProductImage(productImage);

		request.setAttribute("success_messages", new String[] { "Cập nhật hình ảnh sản phẩm thành công" });
		response.sendRedirect("/PetShop/admin/productImage-management?page=1&limit=50");
	}
}