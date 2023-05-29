package com.petshop.servlets.admin.product;

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
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.entities.Category;
import com.petshop.hibernate.entities.Product;

@WebServlet("/admin/product-management")
public class AdminListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	
    public AdminListProductServlet() {
        super();
        this.productDAO = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1, limit = 20, animalId = -1;
		List<Product> products = null;
		
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		long numberOfProducts = 0;
		
		if (request.getParameter("productName") != null) {
			String productName = request.getParameter("productName");
			products = this.productDAO.listProductByProductName(productName, currentPage, limit);

			numberOfProducts = this.productDAO.numberOfProductByProductName(productName);
		}
		else {
			products = this.productDAO.listProducts(currentPage, limit);
			numberOfProducts = this.productDAO.numberOfProducts();
		}
		
        request.setAttribute("productName", request.getParameter("productName"));
        request.setAttribute("listProducts", products);
        request.setAttribute("pageSize", numberOfProducts);
        request.setAttribute("numberOfRowsPerPage", limit);
        request.setAttribute("currentPage", currentPage);
        
        request.getRequestDispatcher("/WEB-INF/templates/admin/pages/product-management/list-products.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
		String productNameSearch = request.getParameter("productName");
		System.out.println(productNameSearch);
		request.setAttribute("success_messages", new String[] { "Tìm sản phẩm thành công" });
    
    //RequestDispatcher rd = request.getRequestDispatcher("/admin/product-management");
    //rd.include(request, response);
    
		response.sendRedirect("/PetShop/admin/product-management");
		
	}

}