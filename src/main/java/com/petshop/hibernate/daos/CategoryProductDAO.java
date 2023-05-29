package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.CategoryProduct;

public class CategoryProductDAO {
	public CategoryProductDAO() {
		
	}
	
	public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    categoryProduct.setCreatedOn(new Date(System.currentTimeMillis()));
    session.persist(categoryProduct);
    session.flush();
      
    session.getTransaction().commit();
		return categoryProduct;
	}
	
	public CategoryProduct updateCategoryProduct(CategoryProduct categoryProduct) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    CategoryProduct entity = (CategoryProduct)session.get(CategoryProduct.class, categoryProduct.getId());

      entity.setCategoryId(categoryProduct.getCategoryId());
      entity.setProductId(categoryProduct.getProductId());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfCategoryProducts() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + CategoryProduct.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<CategoryProduct> listCategoryProducts(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + CategoryProduct.class.getName() + " p where p.deletedOn = null";
        Query<CategoryProduct> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<CategoryProduct> categoryProducts = query.list();
        
        session.getTransaction().commit();
        return categoryProducts;
	}
	
	public List<CategoryProduct> listCategoryProductByProductId(int productId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + CategoryProduct.class.getName() + " p where p.deletedOn = null and p.productId=:productId";
        Query<CategoryProduct> query = session.createQuery(sql);
        
        query.setParameter("productId", productId);
        List<CategoryProduct> categoryProducts = query.list();
        
        session.getTransaction().commit();
        return categoryProducts;
	}
	
	public CategoryProduct getCategoryProductById(int categoryProductId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + CategoryProduct.class.getName() + " p where id=:categoryProductId";
        Query<CategoryProduct> query = session.createQuery(sql);
        query.setParameter("categoryProductId", categoryProductId);
        
        List<CategoryProduct> categoryProducts = query.list();
        
        session.getTransaction().commit();
        
        if (categoryProducts.size() == 0)
        	return null;
        
        return categoryProducts.get(0);
	}
	
	public CategoryProduct getCategoryProductByProductIdAndCategoryId(int productId, int categoryId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + CategoryProduct.class.getName() + " p where p.productId=:productId and p.categoryId=:categoryId";
        Query<CategoryProduct> query = session.createQuery(sql);
        query.setParameter("productId", productId);
        query.setParameter("categoryId", categoryId);
        
        List<CategoryProduct> categoryProducts = query.list();
        
        session.getTransaction().commit();
        
        if (categoryProducts.size() == 0)
        	return null;
        
        return categoryProducts.get(0);
	}
	
	public void deleteCategoryProductById(int categoryProductId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    CategoryProduct categoryProduct = (CategoryProduct)session.get(CategoryProduct.class, categoryProductId);
	    
	    categoryProduct.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(categoryProduct);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}