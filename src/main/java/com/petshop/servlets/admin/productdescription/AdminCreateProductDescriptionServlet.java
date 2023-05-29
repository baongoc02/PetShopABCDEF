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

@WebServlet("/admin/productDescription-management/create")
public class AdminCreateProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDescriptionDAO productDescriptionDAO;
       
    public AdminCreateProductDescriptionServlet() {
        super();
        this.productDescriptionDAO = new ProductDescriptionDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDescription productDescription = new ProductDescription();
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productDesType = request.getParameter("descriptionType");
		String productDesContent = request.getParameter("descriptionContent");
		int productDesOrder = Integer.parseInt(request.getParameter("descriptionOrder"));
		
		productDescription.setType(productDesType);
		productDescription.setOrder(productDesOrder);
		productDescription.setContent(productDesContent);
		productDescription.setProductId(productId);
		
		this.productDescriptionDAO.createProductDescription(productDescription);
		
		request.setAttribute("success_messages", new String[] { "Tạo thông tin sản phẩm thành công" });
		response.sendRedirect("/PetShop/admin/product-management/edit?productId="+productId);
	}
}