package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.ProductDescription;

public class ProductDescriptionDAO {
	public ProductDescriptionDAO() {
		
	}
	
	public ProductDescription createProductDescription(ProductDescription productDescription) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();

    productDescription.setCreatedOn(new Date(System.currentTimeMillis()));
    session.persist(productDescription);
    session.flush();
      
    session.getTransaction().commit();
		return productDescription;
	}
	
	public ProductDescription updateProductDescription(ProductDescription productDescription) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    ProductDescription entity = (ProductDescription)session.get(ProductDescription.class, productDescription.getId());

      entity.setType(productDescription.getType());
      entity.setOrder(productDescription.getOrder());
      entity.setContent(productDescription.getContent());
      entity.setProductId(productDescription.getProductId());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfProductDescriptions() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + ProductDescription.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<ProductDescription> listProductDescriptions(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductDescription.class.getName() + " p where p.deletedOn = null orderby p.order";
        Query<ProductDescription> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<ProductDescription> productDescriptions = query.list();
        
        session.getTransaction().commit();
        return productDescriptions;
	}
	
	public List<ProductDescription> listProductDescriptionsByProductId(int productId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductDescription.class.getName() + " p where p.deletedOn = null and p.productId=:productId order by p.order";
        Query<ProductDescription> query = session.createQuery(sql);
        
        query.setParameter("productId", productId);
        
        List<ProductDescription> productDescriptions = query.list();
        
        session.getTransaction().commit();
        return productDescriptions;
	} 
	
	public ProductDescription getProductDescriptionById(int productDescriptionId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + ProductDescription.class.getName() + " p where id=:productDescriptionId";
        Query<ProductDescription> query = session.createQuery(sql);
        query.setParameter("productDescriptionId", productDescriptionId);
        
        List<ProductDescription> productDescriptions = query.list();
        
        session.getTransaction().commit();
        
        if (productDescriptions.size() == 0)
        	return null;
        
        return productDescriptions.get(0);
	}
	
	public void deleteProductDescriptionById(int productDescriptionId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    ProductDescription productDescription = (ProductDescription)session.get(ProductDescription.class, productDescriptionId);
	    
	    productDescription.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(productDescription);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}