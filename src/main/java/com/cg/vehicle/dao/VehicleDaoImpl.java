package com.cg.vehicle.dao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.cg.vehicle.beans.Vehicle;

public class VehicleDaoImpl implements VehicleDao {

	Map<String, Vehicle> vehicleDetails = new HashMap<String, Vehicle>();
	Vehicle vehicle = new Vehicle();
	SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

	public boolean insuranceRegistration(Vehicle vehicle) {

		if (vehicleDetails.containsKey(vehicle.getVehicleNo())) {
			return false;
		} else {
			Calendar cal = Calendar.getInstance();
			vehicle.setRegisteredDate((Date) cal.getTime());
			cal.add(Calendar.YEAR, vehicle.getInsurancePeriod());
			cal.add(Calendar.DAY_OF_YEAR, -1);
			vehicle.setExpiryDate((Date) cal.getTime());

			vehicleDetails.put(vehicle.getVehicleNo(),
					new Vehicle(vehicle.getVehicleType(), vehicle.getInsurancePeriod(), vehicle.getAadharNo(),
							vehicle.getMobileNo(), vehicle.getRegisteredDate(), vehicle.getExpiryDate()));
			return true;
		}
	}

	public Vehicle insuranceValidityCheck(String vehicleNo) {
		int c = 0;
		for (Map.Entry<String, Vehicle> m : vehicleDetails.entrySet()) {
			if (m.getKey().equals(vehicleNo)) {
				vehicle = m.getValue();
				
					long difference = vehicle.getExpiryDate().getTime() - vehicle.getRegisteredDate().getTime();
					vehicle.setDaysLeft((int) (difference / (1000 * 60 * 60 * 24)));
				
				c++;
			}
		}
		if (c == 0)
			return null;
		else
			return vehicle;
	}

}
