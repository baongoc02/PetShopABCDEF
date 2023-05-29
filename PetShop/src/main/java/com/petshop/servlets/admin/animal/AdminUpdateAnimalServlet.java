package com.petshop.servlets.admin.animal;

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
import com.petshop.hibernate.daos.AnimalDAO;
import com.petshop.hibernate.entities.Animal;

@WebServlet("/admin/animal-management/update")
public class AdminUpdateAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AnimalDAO animalDAO;
	
    public AdminUpdateAnimalServlet() {
        super();
        this.animalDAO = new AnimalDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Animal animal = new Animal();

		animal.setId(Integer.parseInt(request.getParameter("id")));
		
		
		animal.setAnimalName(request.getParameter("animalName"));
		
		
		
		this.animalDAO.updateAnimal(animal);

		request.setAttribute("success_messages", new String[] { "Cập nhật động vật thành công" });
		response.sendRedirect("/PetShop/admin/animal-management?page=1&limit=50");
	}
}