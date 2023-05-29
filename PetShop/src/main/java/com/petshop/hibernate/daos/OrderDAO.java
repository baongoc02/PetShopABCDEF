package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.Order;

public class OrderDAO {
	public OrderDAO() {
		
	}
	
	public Order createOrder(Order order) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    order.setCreatedOn(new Date(System.currentTimeMillis()));
	    int lastId = (int)session.save(order);
	    session.flush();
	    
	    order.setId(lastId);
	    session.getTransaction().commit();
		return order;
	}
	
	public Order updateOrder(Order order) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Order entity = (Order)session.get(Order.class, order.getId());

	    entity.setDeliveredAt(order.getDeliveredAt());
	    entity.setUserId(order.getUserId());
      	    
	    session.update(entity);
	    
	    session.flush();
	    session.getTransaction().commit();
	    return entity;
	}
	
	public void updateStatus(int orderId, String status) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Order entity = (Order)session.get(Order.class, orderId);

	    entity.setStatus(status);
      	    
	    session.update(entity);
	    
	    session.flush();
	    session.getTransaction().commit();
	}
	
	public void updateDeliveredAt(int orderId, Date deliveredAt) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Order entity = (Order)session.get(Order.class, orderId);

	    entity.setDeliveredAt(deliveredAt);
      	    
	    session.update(entity);
	    
	    session.flush();
	    session.getTransaction().commit();		
	}
	
	public long numberOfOrders() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + Order.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<Order> listOrders(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Order.class.getName() + " p where p.deletedOn = null order by p.id desc";
        Query<Order> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<Order> orders = query.list();
        
        session.getTransaction().commit();
        return orders;
	}
	
	public List<Order> listOrderByUserId(int UserId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Order.class.getName() + " p where p.deletedOn = null and p.userId=:userId order by p.id desc";
        Query<Order> query = session.createQuery(sql);
        
        query.setParameter("userId", UserId);
        
        
        List<Order> orders = query.list();
        
        session.getTransaction().commit();
        return orders;
	}
	
	public Order getOrderById(int orderId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Order.class.getName() + " p where id=:orderId";
        Query<Order> query = session.createQuery(sql);
        query.setParameter("orderId", orderId);
        
        List<Order> orders = query.list();
        
        session.getTransaction().commit();
        
        if (orders.size() == 0)
        	return null;
        
        return orders.get(0);
	}
	
	public void deleteOrderById(int orderId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Order order = (Order)session.get(Order.class, orderId);
	    
	    order.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(order);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}