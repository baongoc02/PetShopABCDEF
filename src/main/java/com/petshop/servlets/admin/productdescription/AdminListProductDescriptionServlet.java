package com.petshop.servlets.admin.productdescription;

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
import com.petshop.hibernate.daos.ProductDescriptionDAO;
import com.petshop.hibernate.entities.ProductDescription;

@WebServlet("/admin/productDescription-management")
public class AdminListProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDescriptionDAO productDescriptionDAO;
       
    public AdminListProductDescriptionServlet() {
        super();
        this.productDescriptionDAO = new ProductDescriptionDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<ProductDescription> productDescriptions = this.productDescriptionDAO.listProductDescriptions(currentPage, limit);
	    long numberOfProductDescriptions = this.productDescriptionDAO.numberOfProductDescriptions();
        
        request.setAttribute("listProductDescriptions", productDescriptions);
        request.setAttribute("pageSize", numberOfProductDescriptions);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/productDescription-management/list-productDescription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}