package application;

import problemdomain.*;
import management.*;

import java.util.*;

public class DriveMastersApp {

	private static List<Vehicle> vehicles = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		vehicles = VehicleFileStore.loadVehicles("vehicles.txt");
		int option = 0;

		do {
			displayMenu();
			option = Integer.parseInt(scanner.nextLine());

			switch (option) {
				case 1:
					purchaseVehicle();
					break;

				case 2:
					displayByType();
					break;

				case 3:
					displayBySubtype();
					break;

				case 4:
					displayRandomVehicles();
					break;

				case 5:
					VehicleFileStore.saveVehicles("vehicles.txt", vehicles);
					System.out.println("\nSaving Vehicles... Done!");
					System.out.println("\nGoodbye!");
					break;
				default:
					System.out.println("Invalid option.");
			}

		} while (option != 5);
	}

	private static void displayMenu() {
		System.out.println("\nWelcome to DriveMasters");
		System.out.println("Please choose any option below");
		System.out.println("---------------------------------");
		System.out.println("1\tPurchase Vehicle");
		System.out.println("2\tDisplay Vehicles by Type");
		System.out.println("3\tDisplay Vehicles by Subtype");
		System.out.println("4\tProduce a Random List of Vehicles");
		System.out.println("5\tSave & Exit");
		System.out.print("\nEnter option: ");
	}

//1. Purchase Vehicle//

	private static void purchaseVehicle() {
		System.out.print("Enter CarId: ");
		String carId = scanner.nextLine().trim();
		Vehicle found = null;

		for (Vehicle v : vehicles) {
			if (String.valueOf(v.getCarID()).equals(carId)) {
				found = v;
				break;
			}
		}

		if (found == null) {
			System.out.println("Vehicle not found.");
			return;
		}

		if (found.getQuantity() > 0) {
			found.setQuantity(found.getQuantity() - 1);
			System.out.println(
					"\nThe Vehicle \"" + found.getVehicleType() + " " + found.getSubType() + "\" has been checked out."
			);
		} else {
			System.out.println("Vehicle is not available.");
		}
	}


//2. Search type of vehicle//
	private static void displayByType() {
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String type = scanner.nextLine().trim();

		System.out.println("\nMatching vehicles:");
		for (Vehicle v : vehicles) {
			if (v.getVehicleType().equalsIgnoreCase(type)) {
				System.out.println(v);
				System.out.println();
			}
		}
	}

    
// 3. Search By Sub-type//
	private static void displayBySubtype() {

		System.out.println("#\tSub Type");
		System.out.println("1\tSedan");
		System.out.println("2\tHatchBack");
		System.out.println("3\tSUV");
		System.out.println("4\tHybrid");
		System.out.println("5\tPickup Truck");

		System.out.print("\nEnter type of vehicle: ");
		int typeChoice = Integer.parseInt(scanner.nextLine());

		System.out.println();
		switch (typeChoice) {

			case 1: // Sedan
				System.out.print("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): ");
				String trunk = scanner.nextLine().trim();

				printMatchingHeader();
				for (Vehicle v : vehicles) {
					if (v instanceof Sedan sedan && sedan.getTrunkCode().equalsIgnoreCase(trunk)) {
						System.out.println(sedan);
						System.out.println();
					}
				}
				break;

			case 2: // Hatchback
				System.out.print("Enter HatchType (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
				String hatch = scanner.nextLine().trim();

				printMatchingHeader();
				for (Vehicle v : vehicles) {
					if (v instanceof Hatchback hatchback && hatchback.getHatchTypeCode().equalsIgnoreCase(hatch)) {
						System.out.println(hatchback);
						System.out.println();
					}
				}
				break;

			case 3: // SUV
				System.out.print("Enter Drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
				String drive = scanner.nextLine().trim();

				printMatchingHeader();
				for (Vehicle v : vehicles) {
					if (v instanceof SUV suv && suv.getDrivetrain().equalsIgnoreCase(drive)) {
						System.out.println(suv);
						System.out.println();
					}
				}
				break;

			case 4: // Hybrid
				System.out.print("Enter a PowerTrain (E for Series Hybrid , A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
				String power = scanner.nextLine().trim();

				printMatchingHeader();
				for (Vehicle v : vehicles) {
					if (v instanceof Hybrid hybrid && hybrid.getPowerTrainCode().equalsIgnoreCase(power)) {
						System.out.println(hybrid);
						System.out.println();
					}
				}
				break;

			case 5: // Pickup Truck
				System.out.print("Enter CargoBeds (SB for Short Beds , EB for Extended Beds, DB for Dump Beds): ");
				String cargo = scanner.nextLine().trim();

				printMatchingHeader();
				for (Vehicle v : vehicles) {
					if (v instanceof Truck truck && truck.getCargoBedCode().equalsIgnoreCase(cargo)) {
						System.out.println(truck);
						System.out.println();
					}
				}
				break;
		}
	}
	
	private static void printMatchingHeader() {
		System.out.println("Matching Vehicles:");
	}

//Random vehicles//
	private static void displayRandomVehicles() {
		System.out.print("Enter number of vehicles to display: ");
		int num = Integer.parseInt(scanner.nextLine());
		Random random = new Random();
		System.out.println("\nRandom Vehicles:");
		for (int i = 0; i < num; i++) {
			Vehicle v = vehicles.get(random.nextInt(vehicles.size()));
			System.out.println(v);
			System.out.println("----------------------------------");
		}
	}
}
