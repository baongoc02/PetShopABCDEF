package com.petshop.servlets.admin.productimage;

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
import com.petshop.hibernate.daos.ProductImageDAO;
import com.petshop.hibernate.entities.ProductImage;

@WebServlet("/admin/productImage-management")
public class AdminListProductImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductImageDAO productImageDAO;
       
    public AdminListProductImageServlet() {
        super();
        this.productImageDAO = new ProductImageDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		
	    List<ProductImage> productImages = this.productImageDAO.listProductImages(currentPage, limit);
	    long numberOfProductImages = this.productImageDAO.numberOfProductImages();
        
        request.setAttribute("listProductImages", productImages);
        request.setAttribute("pageSize", numberOfProductImages);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/productImage-management/list-productImage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

}