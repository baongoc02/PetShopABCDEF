package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.Category;

public class CategoryDAO {
	public CategoryDAO() {
		
	}
	
	public Category createCategory(Category category) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    session.persist(category);
    session.flush();
      
    session.getTransaction().commit();
		return category;
	}
	
	public Category updateCategory(Category category) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Category entity = (Category)session.get(Category.class, category.getId());

      entity.setCategoryName(category.getCategoryName());
      entity.setAnimalId(category.getAnimalId());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfCategorys() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + Category.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<Category> listCategorys(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Category.class.getName() + " p where p.deletedOn = null";
        Query<Category> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<Category> categorys = query.list();
        
        session.getTransaction().commit();
        return categorys;
	}
	
	public Category getCategoryById(int categoryId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Category.class.getName() + " p where id=:categoryId";
        Query<Category> query = session.createQuery(sql);
        query.setParameter("categoryId", categoryId);
        
        List<Category> categorys = query.list();
        
        session.getTransaction().commit();
        
        if (categorys.size() == 0)
        	return null;
        
        return categorys.get(0);
	}
	
	public void deleteCategoryById(int categoryId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Category category = (Category)session.get(Category.class, categoryId);
	    
	    category.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(category);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}