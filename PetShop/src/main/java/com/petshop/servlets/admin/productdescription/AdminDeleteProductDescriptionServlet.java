package com.petshop.servlets.admin.productdescription;

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
import com.petshop.hibernate.daos.ProductDescriptionDAO;
import com.petshop.hibernate.entities.ProductDescription;

@WebServlet("/admin/productDescription-management/delete")
public class AdminDeleteProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDescriptionDAO productDescriptionDAO;
	
    public AdminDeleteProductDescriptionServlet() {
        super();
        this.productDescriptionDAO = new ProductDescriptionDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productDescriptionId = Integer.parseInt(request.getParameter("descriptionId"));
		
		this.productDescriptionDAO.deleteProductDescriptionById(productDescriptionId);
		
        request.setAttribute("success_messages", new String[] { "Tạo thông tin sản phẩm thành công" });
        
        //RequestDispatcher rd = request.getRequestDispatcher("/admin/productDescription-management");
        //rd.include(request, response);
        
		response.sendRedirect("/PetShop/admin/product-management/edit?productId=3");
	}
}