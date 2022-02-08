package com.justintime.service;

/**
 * @author Sagnik
 *
 */

public interface BookingSystem{
	
	//void addCab(Cab newCab) throws Exception;
	Integer requestCab() throws Exception;
	Integer getNoOfAvailableCabs() throws Exception;
	

}
