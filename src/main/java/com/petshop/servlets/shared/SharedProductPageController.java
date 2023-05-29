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
import com.petshop.hibernate.daos.ProductDescriptionDAO;
import com.petshop.hibernate.daos.ProductImageDAO;
import com.petshop.hibernate.entities.*;

@WebServlet("/san-pham")
public class SharedProductPageController extends BaseSharedServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	private final CategoryDAO categoryDAO;
	private final ProductImageDAO productImageDAO;
	private final ProductDescriptionDAO productDescriptionDAO;
	
  public SharedProductPageController() {
      super();
      
      this.productDAO = new ProductDAO();
      this.categoryDAO = new CategoryDAO();
      this.productImageDAO = new ProductImageDAO();
      this.productDescriptionDAO = new ProductDescriptionDAO();
  }
    
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		List<Product> products = null;
		List<ProductView> listProductViews = new ArrayList<>();
		
		if (request.getParameter("categoryId") != null) {
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			products = this.productDAO.listProductsByCategoryId(categoryId);
			Category category = this.categoryDAO.getCategoryById(categoryId);
			request.setAttribute("category", category);
		}
		else if (request.getParameter("productName") != null){
			String productName = request.getParameter("productName");
			products = this.productDAO.listProductByProductName(productName, 1, 500);

		}
		else {
			products = this.productDAO.listProducts(1, 20);
		}
		
		for (var product: products) {
			ProductView productView = new ProductView();
			
			productView.setName(product.getProductName());
			productView.setId(product.getId());
			productView.setPrice(product.getPrice());
			productView.setCode(product.getProductCode());
			
			ProductImage productImage = this.productImageDAO.getFirstProductImageByProductId(product.getId());
			productView.setImageLink(productImage.getProductImageLink());
			
			List<ProductDescription> descriptions = this.productDescriptionDAO.listProductDescriptionsByProductId(product.getId());
			productView.setListProductDescriptions(descriptions);
			
			listProductViews.add(productView);
		}
		

		request.setAttribute("listProducts", listProductViews);
		request.getRequestDispatcher("/WEB-INF/templates/shared/product.jsp").forward(request, response);
	}
    
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		response.setStatus(405);
	}
}
