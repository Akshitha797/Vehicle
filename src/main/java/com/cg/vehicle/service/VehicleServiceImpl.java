package com.cg.vehicle.service;

import com.cg.vehicle.beans.Vehicle;
import com.cg.vehicle.dao.VehicleDao;
import com.cg.vehicle.dao.VehicleDaoImpl;

public class VehicleServiceImpl implements VehicleService {

	VehicleDao vehicleDao=new VehicleDaoImpl();
	public boolean insuranceRegistration(Vehicle vehicle) {
		return vehicleDao.insuranceRegistration(vehicle);
	}

	public Vehicle insuranceValidityCheck(String vehicleNo) {
		return vehicleDao.insuranceValidityCheck(vehicleNo);
	}
	
	public boolean validateMobileNo(long mobileNo) {
		String mobile=String.valueOf(mobileNo);
		if(mobile.length()==10)
			return true;
		else 
			return false;
	}
	
	public boolean validateAadhar(long aadharCardNo) {
		String aadhar=String.valueOf(aadharCardNo);
		if(aadhar.length() == 12)
			return true;
		else
			return false;
	}

}
