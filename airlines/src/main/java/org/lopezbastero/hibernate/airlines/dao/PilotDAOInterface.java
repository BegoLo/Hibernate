package org.lopezbastero.hibernate.airlines.dao;

import java.util.List;

import org.lopezbastero.hibernate.airlines.models.Pilot;


/**
 * interface for PilotDAO class
 * @author Begoña López Bastero
 * @email bego.lopez.bastero@gmail.com
 */
public interface PilotDAOInterface {
	
	public Pilot selectById(Long id);
	public List<Pilot> selectAll ();
	public void insert (Pilot pilot);
	public void update (Pilot pilot);
	public void delete (Pilot pilot);

}
