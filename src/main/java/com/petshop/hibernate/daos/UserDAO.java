package com.petshop.hibernate.daos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.Product;
import com.petshop.hibernate.entities.User;

public class UserDAO {
	public UserDAO() {
		
	}
	
	public User createUser(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    user.setPassword(this.getMd5FromString(user.getPassword()));
    
    session.persist(user);
    session.flush();
      
    session.getTransaction().commit();
		return user;
	}
	
	public boolean checkUserExistedByUsername(String username) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    
    session.getTransaction().begin();
    
    String sql = "select p from " + User.class.getName() + " p where username=:username";
    Query<User> query = session.createQuery(sql);
    query.setParameter("username", username);
    
    List<User> users = query.list();
    
    session.getTransaction().commit();
    
    return users.size() > 0;
	}

	public boolean checkUserExistedByPhoneNumber(String phoneNumber) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    
    session.getTransaction().begin();
    
    String sql = "select p from " + User.class.getName() + " p where phoneNumber=:phoneNumber";
    Query<User> query = session.createQuery(sql);
    query.setParameter("phoneNumber", phoneNumber);
    
    List<User> users = query.list();
    
    session.getTransaction().commit();
    
    return users.size() > 0;
	}	
	
	private static String convertByteToHex1(byte[] data) {
	  BigInteger number = new BigInteger(1, data);
	  String hashtext = number.toString(16);
	  while (hashtext.length() < 32) {
	    hashtext = "0" + hashtext;
	  }
	  return hashtext;
	}

	
	private String getMd5FromString(String input) {
	 try {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] messageDigest = md.digest(input.getBytes());
	    return convertByteToHex1(messageDigest);
	  } catch (NoSuchAlgorithmException e) {
	    throw new RuntimeException(e);
	  }
	}
	
	public User updateUser(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    User entity = (User)session.get(User.class, user.getId());

      entity.setUsername(user.getUsername());
      entity.setPassword(user.getPassword());
      entity.setFullName(user.getFullName());
      entity.setRole(user.getRole());
      entity.setAddress(user.getAddress());
      entity.setPhoneNumber(user.getPhoneNumber());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public User updatePasswordByUserId(int id, String password) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    User entity = (User)session.get(User.class, id);
	    
	    entity.setPassword(this.getMd5FromString(password));
	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfUsers() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + User.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public long numberOfUserByFullName(String fullName) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + User.class.getName() + " p where p.deletedOn = null and p.fullName like :fullName";
        Query query = session.createQuery(sql);
        query.setParameter("fullName","%" + fullName + "%");
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		String hashedPassword = this.getMd5FromString(password);
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    
    session.getTransaction().begin();
    
    String sql = "select p from " + User.class.getName() + " p where username=:username and password=:password";
    Query<User> query = session.createQuery(sql);
    query.setParameter("username", username);
    query.setParameter("password", hashedPassword);
    
    List<User> users = query.list();
    
    session.getTransaction().commit();
    
    if (users.size() == 0)
    	return null;
    
    return users.get(0);
	}
	
	public List<User> listUsers(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + User.class.getName() + " p where p.deletedOn = null";
        Query<User> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<User> users = query.list();
        
        session.getTransaction().commit();
        return users;
	}
	
	public List<User> listUserByFullName(String fullName, int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + User.class.getName() + " p where p.deletedOn = null and p.fullName like :fullName";
        Query<User> query = session.createQuery(sql);
        query.setParameter("fullName","%" + fullName + "%");
        		
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<User> users = query.list();
        
        session.getTransaction().commit();
        return users;
	}
	
	public User getUserById(int userId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + User.class.getName() + " p where id=:userId";
        Query<User> query = session.createQuery(sql);
        query.setParameter("userId", userId);
        
        List<User> users = query.list();
        
        session.getTransaction().commit();
        
        if (users.size() == 0)
        	return null;
        
        return users.get(0);
	}
	
	public void deleteUserById(int userId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    User user = (User)session.get(User.class, userId);
	    
	    user.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(user);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}