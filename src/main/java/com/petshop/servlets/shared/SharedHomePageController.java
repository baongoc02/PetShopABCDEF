package com.petshop.servlets.shared;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.daos.AnimalDAO;
import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Animal;
import com.petshop.hibernate.entities.Category;
import com.petshop.hibernate.entities.Product;

@WebServlet("")
public class SharedHomePageController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
       
    public SharedHomePageController() {
		super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	super.doGet(request, response);
		
    	
		request.getRequestDispatcher("/WEB-INF/templates/shared/index.jsp").forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		response.setStatus(405);
	}

}