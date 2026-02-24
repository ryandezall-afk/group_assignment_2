package problemdomain;

public class Truck extends Vehicle {
	private String cargoBed;
	private String cargoCapacity;
	
	public Truck(long carID, String vehicleType, String subType, int speed, double fuel, 
			int seats, int year, String drivetrain, int price, int quantity, String cargoBed, String cargoCapacity) {
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		this.cargoBed = cargoBed;
		this.cargoCapacity = cargoCapacity;
	}
	
	public String getCargoBedCode() {
		return cargoBed;
	}
	
	public String getCargoCapacity() {
		return cargoCapacity;
	}
	
	public String getCargoBedType() {
		switch(cargoBed.toUpperCase()) {
		case "SB": return "Short Bed";
		case "EB": return "Extended Bed";
		case "DB": return "Dump Bed";
		default: return "Unknown";
		}
	}
		
	@Override
	public String toString() {
		return super.toString() + "\nCargo Capacity: " + cargoCapacity + "\nCargo Beds: " + getCargoBedType();
		}
	}
