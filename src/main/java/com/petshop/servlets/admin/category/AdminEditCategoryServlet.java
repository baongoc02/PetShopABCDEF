package com.petshop.servlets.admin.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.entities.Category;

@WebServlet("/admin/category-management/edit")
public class AdminEditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryDAO categoryDAO;
       
    public AdminEditCategoryServlet() {
        super();
  			this.categoryDAO = new CategoryDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(categoryId);
		Category category = this.categoryDAO.getCategoryById(categoryId);
		
		request.setAttribute("category", category);	
		request.getRequestDispatcher("/WEB-INF/templates/admin/pages/product-management/edit-catgory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
		//doGet(request, response);
	}

}
