package com.cg.vehicle.exception;

public class DoesNotExistException extends Exception{

	public DoesNotExistException() {
		System.err.println("Vehicle Does Not Exist !");
	}
}
