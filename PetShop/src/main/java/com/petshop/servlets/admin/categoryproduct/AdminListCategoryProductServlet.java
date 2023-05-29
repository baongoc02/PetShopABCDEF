package com.petshop.servlets.admin.categoryproduct;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.daos.CategoryProductDAO;
import com.petshop.hibernate.entities.CategoryProduct;

@WebServlet("/admin/categoryProduct-management")
public class AdminListCategoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryProductDAO categoryProductDAO;
       
    public AdminListCategoryProductServlet() {
        super();
        this.categoryProductDAO = new CategoryProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<CategoryProduct> categoryProducts = this.categoryProductDAO.listCategoryProducts(currentPage, limit);
	    long numberOfCategoryProducts = this.categoryProductDAO.numberOfCategoryProducts();
        
        request.setAttribute("listCategoryProducts", categoryProducts);
        request.setAttribute("pageSize", numberOfCategoryProducts);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/categoryProduct-management/list-categoryProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}