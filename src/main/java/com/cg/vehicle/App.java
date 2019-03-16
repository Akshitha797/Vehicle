package com.cg.vehicle;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.cg.vehicle.beans.Vehicle;
import com.cg.vehicle.exception.AadharException;
import com.cg.vehicle.exception.DoesNotExistException;
import com.cg.vehicle.exception.MobileNoException;
import com.cg.vehicle.exception.RegistrationException;
import com.cg.vehicle.service.VehicleService;
import com.cg.vehicle.service.VehicleServiceImpl;

/**
 * Hello world!
 *
 */
public class App {

	static Scanner s;
	static Vehicle vehicle = new Vehicle();
	static VehicleService vehicleService = new VehicleServiceImpl();
	static VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();

	public static void main(String[] args) {

		System.out.println("=====Vehicle Insurance=====");
		s = new Scanner(System.in);
		while (true) {
			System.out.println("------MAIN MENU------");
			System.out.println("Enter your choice: ");
			System.out.println("1.Vehicle Insurance Registration \n 2.Insurance Validity Check \n 3.Exit");
			int ch = s.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter Vehicle Number :");
				vehicle.setVehicleNo(s.next());
				System.out.println("Enter Vehicle Type : ");
				vehicle.setVehicleType(s.next());
				System.out.println("Enter Insurance Period :");
				vehicle.setInsurancePeriod(s.nextInt());
				System.out.println("Enter Aadhar Card Number: ");
				vehicle.setAadharNo(s.nextLong());
				if (vehicleServiceImpl.validateAadhar(vehicle.getAadharNo())) {
					System.out.println("Enter Mobile Number: ");
					vehicle.setMobileNo(s.nextLong());
					if (vehicleServiceImpl.validateMobileNo(vehicle.getMobileNo())) {

						if (vehicleService.insuranceRegistration(vehicle))
							System.out.println("-----Registered Successfully !!-----");
						else {
							try {
								throw new RegistrationException();
							} catch (RegistrationException e) {

							}
						}
					} else {
						try {
							throw new MobileNoException();
						} catch (MobileNoException e) {

						}
					}
				} else {
					try {
						throw new AadharException();
					} catch (AadharException e) {

					}
				}
				break;

			case 2:
				System.out.println("Enter Vehicle Number: ");
				String vehicleNo = s.next();

				vehicle = vehicleService.insuranceValidityCheck(vehicleNo);
				if (vehicle != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String strDate = formatter.format(vehicle.getExpiryDate());

					System.out.println("Expiry Date is " + strDate);
					System.out.println("No of days for renewal are " + vehicle.getDaysLeft());
				} else {
					try {
						throw new DoesNotExistException();
					} catch (DoesNotExistException e) {

					}
				}
				break;

			case 3:
				System.exit(0);

			default:
				System.err.println("Wrong Choice !!");
			}
		}
	}
}
