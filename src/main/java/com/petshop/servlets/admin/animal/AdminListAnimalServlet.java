package com.petshop.servlets.admin.animal;

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
import com.petshop.hibernate.entities.Animal;

@WebServlet("/admin/animal-management")
public class AdminListAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AnimalDAO animalDAO;
       
    public AdminListAnimalServlet() {
        super();
        this.animalDAO = new AnimalDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<Animal> animals = this.animalDAO.listAnimals(currentPage, limit);
	    long numberOfAnimals = this.animalDAO.numberOfAnimals();
        
        request.setAttribute("listAnimals", animals);
        request.setAttribute("pageSize", numberOfAnimals);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/animal-management/list-animals.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}