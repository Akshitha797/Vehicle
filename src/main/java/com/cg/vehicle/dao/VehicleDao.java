package com.cg.vehicle.dao;

import com.cg.vehicle.beans.Vehicle;

public interface VehicleDao {

public boolean insuranceRegistration(Vehicle vehicle);
	
	public Vehicle insuranceValidityCheck(String vehicleNo);

}
