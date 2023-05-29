package com.petshop.servlets.admin.categoryproduct;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.daos.CategoryProductDAO;
import com.petshop.hibernate.entities.CategoryProduct;

@WebServlet("/admin/categoryProduct-management/create")
public class AdminCreateCategoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryProductDAO categoryProductDAO;
       
    public AdminCreateCategoryProductServlet() {
        super();
        this.categoryProductDAO = new CategoryProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryProduct categoryProduct = new CategoryProduct();
		
		
		
		//categoryProduct.setProductId(Integer.parseInt(request.getParameter("productId")));
		int productId = (Integer.parseInt(request.getParameter("productId")));
		
		int categoryId = (Integer.parseInt(request.getParameter("categorys-add")));
				
		categoryProduct.setProductId(productId);
		System.out.println(categoryProduct.getProductId());
		categoryProduct.setCategoryId(categoryId);
		System.out.println(categoryProduct.getCategoryId());
		
		this.categoryProductDAO.createCategoryProduct(categoryProduct);
		
		request.setAttribute("success_messages", new String[] { "Tạo CategoryProduct thành công" });
		response.sendRedirect("/PetShop/admin/product-management/edit?productId="+productId);
		
	}
}