package com.petshop.servlets.admin.categoryproduct;

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
import com.petshop.hibernate.daos.CategoryProductDAO;
import com.petshop.hibernate.entities.CategoryProduct;

@WebServlet("/admin/categoryProduct-management/update")
public class AdminUpdateCategoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryProductDAO categoryProductDAO;
	
    public AdminUpdateCategoryProductServlet() {
        super();
        this.categoryProductDAO = new CategoryProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryProduct categoryProduct = new CategoryProduct();

		categoryProduct.setId(Integer.parseInt(request.getParameter("id")));
		
		
		//categoryProduct.setAnimalId(Integer.parseInt(request.getParameter("animalId")));
		
		
		
		categoryProduct.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		
		
		this.categoryProductDAO.updateCategoryProduct(categoryProduct);

		request.setAttribute("success_messages", new String[] { "Cập nhật CategoryProduct thành công" });
		response.sendRedirect("/PetShop/admin/categoryProduct-management?page=1&limit=50");
	}
}