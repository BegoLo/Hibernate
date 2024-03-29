/**
 * 
 */
package org.lopezbastero.hibernate.airlines.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lopezbastero.hibernate.airlines.HibernateSession;
import org.lopezbastero.hibernate.airlines.models.Pilot;


/**
 * implementation of PilotDAOInterface
 * @author Begoña López Bastero
 * @email bego.lopez.bastero@gmail.com
 */
public class PilotDAO implements PilotDAOInterface {

	/* 
	 * selects one Pilot by Id
	 * @param id
	 * @return President
	 */
	public Pilot selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Pilot pilot = (Pilot) session.get(Pilot.class, id);
	    
	    session.close();
	    return pilot;
	}

	/*
	 * retrieves all Pilot from db
	 * @return List of Pilots
	 */
	public List<Pilot> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Pilot> pilots = session.createQuery("from President").list();
	    
	    session.close();
	    return pilots;
	}
	

	/*
	 * inserts a new Pilot in database
	 * retrieves generated id and sets to Pilot instance
	 * @param new Pilot
	 */
	public void insert(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(pilot);
	         
	    session.getTransaction().commit();
	    session.close();

	}
	

	/*
	 * updates Pilot
	 * @param Pilot to update
	 */
	public void update(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(pilot);
		 
		    session.getTransaction().commit();
		    session.close();
	}
	

	/*
	 * delete given Pilot
	 * @param Pilot to delete
	 */
	public void delete(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(pilot);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
