package com.petshop.hibernate.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.Category;
import com.petshop.hibernate.entities.FeedBack;
import com.petshop.hibernate.entities.Order;

public class FeedBackDAO {
	public FeedBackDAO() {
		
	}
	
	public FeedBack createFeedBack(FeedBack feedBack) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    session.persist(feedBack);
    session.flush();
      
    session.getTransaction().commit();
		return feedBack;
	}
	
	public long numberOfFeedbacks() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + FeedBack.class.getName() + " p";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<FeedBack> listFeedBacks(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
  
    session.getTransaction().begin();
    
    String sql = "select p from " + FeedBack.class.getName() + " p order by p.id desc";
    Query<FeedBack> query = session.createQuery(sql);
    
    if ((page - 1) * limit >= 0) {
    	query.setFirstResult((page - 1) * limit);
    	query.setMaxResults(limit);
    }
    
    List<FeedBack> feedBacks = query.list();
    
    session.getTransaction().commit();
    return feedBacks;
	}
}
