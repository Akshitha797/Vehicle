package com.cg.vehicle.exception;

public class RegistrationException extends Exception{

	public RegistrationException() {
		System.err.println("Vehicle already exists");
	}
}
