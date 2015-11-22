/**
 * 
 */
package org.lopezbastero.hibernate.airlines.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lopezbastero.hibernate.airlines.HibernateSession;
import org.lopezbastero.hibernate.airlines.models.Aircraft;


/**
 * implementation of AircraftDAOInterface
 * @author Begoña Lopez
 * @email bego.lopez.bastero@gmail.com
 */
public class AircraftDAO implements AircraftDAOInterface {

	/* 
	 * selects one Aircraft by Id
	 * @param id
	 * @return Country
	 */
	public Aircraft selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Aircraft aircraft = (Aircraft) session.get(Aircraft.class, id);
	    
	    session.close();
	    return aircraft;
	}

	/*
	 * retrieves all Aircraft from db
	 * @return List of Aircraft
	 */
	public List<Aircraft> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Aircraft> aircrafts = session.createQuery("from Aircraft").list();
	    
	    session.close();
	    return aircrafts;
	}
	

	/*
	 * inserts a new Aircraft in database
	 * Aircraft must come with the id set 
	 * @param new Aircraft
	 */
	public void insert(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(aircraft);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates Aircraft
	 * @param Aircraft to update
	 */
	public void update(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(aircraft); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}
	

	/*
	 * delete given Aircraft
	 * @param Aircraft to delete
	 */
	public void delete(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(aircraft);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
