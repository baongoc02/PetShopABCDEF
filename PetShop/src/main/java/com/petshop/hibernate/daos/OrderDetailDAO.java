package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.OrderDetail;

public class OrderDetailDAO {
	public OrderDetailDAO() {
		
	}
	
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    orderDetail.setCreatedOn(new Date(System.currentTimeMillis()));
    session.persist(orderDetail);
    session.flush();
      
    session.getTransaction().commit();
		return orderDetail;
	}
	
	public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    OrderDetail entity = (OrderDetail)session.get(OrderDetail.class, orderDetail.getId());

      entity.setQuantity(orderDetail.getQuantity());
      entity.setOrderId(orderDetail.getOrderId());
      entity.setProductId(orderDetail.getProductId());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfOrderDetails() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + OrderDetail.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<OrderDetail> listOrderDetails(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + OrderDetail.class.getName() + " p where p.deletedOn = null";
        Query<OrderDetail> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<OrderDetail> orderDetails = query.list();
        
        session.getTransaction().commit();
        return orderDetails;
	}
	
	public List<OrderDetail> listOrderDetailsByOrderId(int orderId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + OrderDetail.class.getName() + " p where p.deletedOn = null and p.orderId=:orderId";
        Query<OrderDetail> query = session.createQuery(sql);
        query.setParameter("orderId", orderId);
        
        List<OrderDetail> orderDetails = query.list();
        
        session.getTransaction().commit();
        return orderDetails;
	}
	
	public OrderDetail getOrderDetailById(int orderDetailId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + OrderDetail.class.getName() + " p where id=:orderDetailId";
        Query<OrderDetail> query = session.createQuery(sql);
        query.setParameter("orderDetailId", orderDetailId);
        
        List<OrderDetail> orderDetails = query.list();
        
        session.getTransaction().commit();
        
        if (orderDetails.size() == 0)
        	return null;
        
        return orderDetails.get(0);
	}
	
	public void deleteOrderDetailById(int orderDetailId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    OrderDetail orderDetail = (OrderDetail)session.get(OrderDetail.class, orderDetailId);
	    
	    orderDetail.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(orderDetail);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}