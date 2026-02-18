package problemdomain;

public class Hatchback extends Vehicle {
	private String hatchType;

	public Hatchback(long carID, String vehicleType, String subType, int speed, double fuel, 
			int seats, int year, String drivetrain, int price, int quantity, String hatchType) {
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		this.hatchType = hatchType;
	}
	
	public String getHatchTypeLabel() {
		switch(hatchType.toUpperCase()) {
		case "T": return "Split Liftgate";
		case "S": return "Standard Liftgate";
		case "P": return "Power Liftgate";
		default: return "Unknown";
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nHatch Type: " + getHatchTypeLabel();
	}
}
