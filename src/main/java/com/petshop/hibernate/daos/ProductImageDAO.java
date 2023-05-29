package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.ProductImage;

public class ProductImageDAO {
	public ProductImageDAO() {
		
	}
	
	public ProductImage createProductImage(ProductImage productImage) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();

    productImage.setCreatedOn(new Date(System.currentTimeMillis()));
    session.persist(productImage);
    session.flush();
      
    session.getTransaction().commit();
		return productImage;
	}
	
	public ProductImage updateProductImage(ProductImage productImage) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    ProductImage entity = (ProductImage)session.get(ProductImage.class, productImage.getId());

      entity.setOrder(productImage.getOrder());
      entity.setProductImageLink(productImage.getProductImageLink());
      entity.setProductId(productImage.getProductId());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfProductImages() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + ProductImage.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<ProductImage> listProductImages(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductImage.class.getName() + " p where p.deletedOn = null";
        Query<ProductImage> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<ProductImage> productImages = query.list();
        
        session.getTransaction().commit();
        return productImages;
	}
	
	public ProductImage getProductImageById(int productImageId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductImage.class.getName() + " p where id=:productImageId";
        Query<ProductImage> query = session.createQuery(sql);
        query.setParameter("productImageId", productImageId);
        
        List<ProductImage> productImages = query.list();
        
        session.getTransaction().commit();
        
        if (productImages.size() == 0)
        	return null;
        
        return productImages.get(0);
	}
	
	public ProductImage getFirstProductImageByProductId(int productId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductImage.class.getName() + " p where productId=:productId";
        Query<ProductImage> query = session.createQuery(sql);
        query.setParameter("productId", productId);
        
        List<ProductImage> productImages = query.list();
        
        session.getTransaction().commit();
        
        if (productImages.size() == 0)
        	return null;
        
        return productImages.get(0);
	}
	
	public List<ProductImage> listProductImagesByProductId(int productId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductImage.class.getName() + " p where productId=:productId and p.deletedOn = null order by p.order";
        Query<ProductImage> query = session.createQuery(sql);
        query.setParameter("productId", productId);
        
        List<ProductImage> productImages = query.list();
        
        session.getTransaction().commit();
        
        if (productImages.size() == 0)
        	return null;
        
        return productImages;
	}
	
	public void deleteProductImageById(int productImageId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    ProductImage productImage = (ProductImage)session.get(ProductImage.class, productImageId);
	    
	    productImage.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(productImage);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}