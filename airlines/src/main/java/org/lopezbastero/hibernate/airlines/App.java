package org.lopezbastero.hibernate.airlines;

import org.lopezbastero.hibernate.airlines.dao.AircraftDAO;
import org.lopezbastero.hibernate.airlines.dao.PilotDAO;
import org.lopezbastero.hibernate.airlines.models.Aircraft;
import org.lopezbastero.hibernate.airlines.models.Pilot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Aircraft aircraft1 = new Aircraft();
        aircraft1.setModel("X Wind");
        aircraft1.setAutonomy(1000f);
        Aircraft aircraft2 = new Aircraft();
        aircraft2.setModel("Falcon Milennary");
        aircraft2.setAutonomy(2000f);
        
        Pilot  pilot1 = new Pilot();
        pilot1.setName("Luke Skywalker");
        pilot1.setLicense(1);
        Pilot  pilot2 = new Pilot();
        pilot2.setName("Han Solo");
        pilot1.setLicense(2);
        
        aircraft1.setPilot(pilot1);
        aircraft2.setPilot(pilot2);
        
        Aircraft aircraft3 = new Aircraft();
        aircraft3.setModel("Death Star");
        aircraft3.setAutonomy(200000f);
        
        AircraftDAO aircraftDAO = new AircraftDAO();
        PilotDAO pilotDAO = new PilotDAO();
        
        aircraftDAO.insert(aircraft3);
        
        aircraftDAO.insert(aircraft1);
        aircraftDAO.insert(aircraft2);
        
        aircraftDAO.delete(aircraft1);
        
    }
}
