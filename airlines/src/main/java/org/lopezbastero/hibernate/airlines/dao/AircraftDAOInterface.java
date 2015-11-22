package org.lopezbastero.hibernate.airlines.dao;

import java.util.List;

import org.lopezbastero.hibernate.airlines.models.Aircraft;


/**
 * interface for AircraftDAO class
 * @author Begoña López Bastero
 * @email bego.lopez.bastero@gmail.com
 */
public interface AircraftDAOInterface {
	
	public Aircraft selectById(Long id);
	public List<Aircraft> selectAll ();
	public void insert (Aircraft aircraft);
	public void update (Aircraft aircraft);
	public void delete (Aircraft aircraft);

}
