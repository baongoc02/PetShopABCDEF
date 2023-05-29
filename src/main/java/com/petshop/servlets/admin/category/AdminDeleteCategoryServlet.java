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

@WebServlet("/admin/category-management/delete")
public class AdminDeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryDAO categoryDAO;
	
    public AdminDeleteCategoryServlet() {
        super();
        this.categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		this.categoryDAO.deleteCategoryById(categoryId);
		
        request.setAttribute("success_messages", new String[] { "Tạo loại sản phẩm thành công" });
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin/category-management");
        rd.include(request, response);
        
		response.sendRedirect("/PetShop/admin/category-management");
	}
}