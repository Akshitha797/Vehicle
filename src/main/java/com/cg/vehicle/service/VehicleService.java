package com.cg.vehicle.service;

import com.cg.vehicle.beans.Vehicle;

public interface VehicleService {
	
	public boolean insuranceRegistration(Vehicle vehicle);
	
	public Vehicle insuranceValidityCheck(String vehicleNo);

}
