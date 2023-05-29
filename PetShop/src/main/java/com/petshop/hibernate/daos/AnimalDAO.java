package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.Animal;

public class AnimalDAO {
	public AnimalDAO() {
		
	}
	
	public Animal createAnimal(Animal animal) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    session.persist(animal);
    session.flush();
      
    session.getTransaction().commit();
		return animal;
	}
	
	public Animal updateAnimal(Animal animal) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Animal entity = (Animal)session.get(Animal.class, animal.getId());

      entity.setAnimalName(animal.getAnimalName());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfAnimals() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + Animal.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<Animal> listAnimals(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Animal.class.getName() + " p where p.deletedOn = null";
        Query<Animal> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<Animal> animals = query.list();
        
        session.getTransaction().commit();
        return animals;
	}
	
	public Animal getAnimalById(int animalId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Animal.class.getName() + " p where id=:animalId";
        Query<Animal> query = session.createQuery(sql);
        query.setParameter("animalId", animalId);
        
        List<Animal> animals = query.list();
        
        session.getTransaction().commit();
        
        if (animals.size() == 0)
        	return null;
        
        return animals.get(0);
	}
	
	public void deleteAnimalById(int animalId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Animal animal = (Animal)session.get(Animal.class, animalId);
	    
	    animal.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(animal);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}