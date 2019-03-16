package com.cg.vehicle.beans;

import java.util.Date;

public class Vehicle {
	
	private String vehicleNo;
	private String vehicleType;
	private int insurancePeriod;
	private long aadharNo;
	private long mobileNo;
	private Date registeredDate;
	private Date expiryDate;
	private int daysLeft;
	
	public Vehicle(String vehicleType2, int insurancePeriod2, long aadharNo2, long mobileNo2, Date registeredDate2,Date expiryDate2) {

		vehicleType=vehicleType2;
		insurancePeriod=insurancePeriod2;
		aadharNo=aadharNo2;
		mobileNo=mobileNo2;
		registeredDate=registeredDate2;
		expiryDate=expiryDate2;
	}
	
	public Vehicle() {
		
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getInsurancePeriod() {
		return insurancePeriod;
	}
	public void setInsurancePeriod(int insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
