package com.travelapp.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.vo.Trip;

public interface TripDAO {
	
	public ArrayList<Trip> getAllTrips() throws SQLException;
	public Trip getTripById(int id)throws SQLException; 
	public void deleteTrip(Trip trip)throws SQLException;
	public void addTrip(Trip trip)throws SQLException;
	public void updateTrip(Trip trip)throws SQLException;

}
