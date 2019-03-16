package com.cg.vehicle.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.vehicle.beans.Vehicle;

class VehicleDaoImplTest {
	
	static Vehicle vehicle;
	static VehicleDaoImpl vehicleDao;
	
	@BeforeAll
	public static void init() {
		vehicle=new Vehicle();
		vehicleDao=new VehicleDaoImpl();
	}
	@Test
	void testInsuranceRegistration() {
		vehicle.setVehicleNo("1234");
		vehicle.setVehicleType("2 wheeler");
		vehicle.setInsurancePeriod(1);
		vehicle.setAadharNo(654789321456L);
		vehicle.setMobileNo(7095625581L);
		assertEquals(true,vehicleDao.insuranceRegistration(vehicle));
		
	}

	@Test
	void testInsuranceValidityCheck() {
		vehicle.setVehicleNo("123");
		vehicle.setVehicleType("2 wheeler");
		vehicle.setInsurancePeriod(1);
		vehicle.setAadharNo(654789321456L);
		vehicle.setMobileNo(7095625581L);
		vehicleDao.insuranceRegistration(vehicle);
		assertEquals(365,vehicleDao.insuranceValidityCheck("123").getDaysLeft());
	}

}
