package com.petshop.servlets.admin.category;

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
import com.petshop.hibernate.daos.AnimalDAO;
import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.entities.Animal;
import com.petshop.hibernate.entities.Category;

@WebServlet("/admin/category-management")
public class AdminListCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryDAO categoryDAO;
	public final AnimalDAO annimalDAO;
       
    public AdminListCategoryServlet() {
        super();
        this.categoryDAO = new CategoryDAO();
				this.annimalDAO = new AnimalDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<Category> categorys = this.categoryDAO.listCategorys(currentPage, limit);
	    List<Animal> animals = this.annimalDAO.listAnimals(1, 9000);
	    
	    long numberOfCategorys = this.categoryDAO.numberOfCategorys();
        
        request.setAttribute("listCategorys", categorys);
        request.setAttribute("listAnimals", animals);
        request.setAttribute("pageSize", numberOfCategorys);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/category-management/list-Categorys.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}