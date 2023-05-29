package com.petshop.servlets.admin.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.daos.CategoryDAO;
import com.petshop.hibernate.daos.CategoryProductDAO;
import com.petshop.hibernate.daos.ProductDAO;
import com.petshop.hibernate.daos.ProductDescriptionDAO;
import com.petshop.hibernate.daos.ProductImageDAO;
import com.petshop.hibernate.entities.Category;
import com.petshop.hibernate.entities.CategoryProduct;
import com.petshop.hibernate.entities.Product;
import com.petshop.hibernate.entities.ProductDescription;
import com.petshop.hibernate.entities.ProductImage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product-management/edit")
public class AdminEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDAO productDAO;
	private final ProductImageDAO productImageDAO;
	private final ProductDescriptionDAO productDescriptionDAO;
	private final CategoryProductDAO categoryProductDAO;
	private final CategoryDAO categoryDAO;

    public AdminEditProduct() {
    	super();
    	this.productDAO = new ProductDAO();
    	this.productImageDAO = new ProductImageDAO();
    	this.productDescriptionDAO = new ProductDescriptionDAO();
		this.categoryProductDAO = new CategoryProductDAO();
		this.categoryDAO = new CategoryDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = this.productDAO.getProductById(productId);
		if (product == null) {
			response.setStatus(404);
			return;
		}
		
		List<ProductImage> productImages = this.productImageDAO.listProductImagesByProductId(productId);
		List<ProductDescription> productDescriptions = this.productDescriptionDAO.listProductDescriptionsByProductId(productId);
		List<CategoryProduct> categoryProducts = this.categoryProductDAO.listCategoryProductByProductId(productId);
		List<Category> categoryByProductIds = new ArrayList<Category>();
		List<Category> categories = this.categoryDAO.listCategorys(1, 9000);
		
		for (var categoryProduct: categoryProducts)
		{
			Category category = this.categoryDAO.getCategoryById(categoryProduct.getCategoryId());
			categoryByProductIds.add(category);
		}
		
		request.setAttribute("productImages", productImages);
		request.setAttribute("productDescriptions", productDescriptions);
		request.setAttribute("product", product);	
		request.setAttribute("listCategoryByProductIds", categoryByProductIds);
		request.setAttribute("listCategories", categories);
		request.getRequestDispatcher("/WEB-INF/templates/admin/pages/product-management/edit-product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(405);
		//doGet(request, response);
		
	}

}
