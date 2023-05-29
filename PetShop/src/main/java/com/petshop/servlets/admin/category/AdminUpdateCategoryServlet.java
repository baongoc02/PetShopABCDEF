package com.petshop.servlets.admin.category;

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
import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.entities.Category;

@WebServlet("/admin/category-management/update")
public class AdminUpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryDAO categoryDAO;
	
    public AdminUpdateCategoryServlet() {
        super();
        this.categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = new Category();

		category.setId(Integer.parseInt(request.getParameter("id")));
		
		
		category.setCategoryName(request.getParameter("categoryName"));
		
		
		
		category.setAnimalId(Integer.parseInt(request.getParameter("animalId")));
		
		
		
		this.categoryDAO.updateCategory(category);

		request.setAttribute("success_messages", new String[] { "Cập nhật loại sản phẩm thành công" });
		response.sendRedirect("/PetShop/admin/category-management?page=1&limit=50");
	}
}