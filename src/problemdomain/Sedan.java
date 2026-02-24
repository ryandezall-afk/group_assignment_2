package problemdomain;

public class Sedan extends Vehicle {
	private String trunkSize;
	
	public Sedan(long carID, String vehicleType, String subType, int speed, double fuel, 
			int seats, int year, String drivetrain, int price, int quantity, String trunkSize) {
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		this.trunkSize = trunkSize;
	}
	
	public String getTrunkCode() {
		return trunkSize;
	}
	
	public String getTrunkLabelSize() {
		switch(trunkSize.toUpperCase()) {
		case "L": return "Large/spacious Trunk";
		case "S": return "Small Trunk";
		case "M": return "Moderate Trunk";
		default: return "Unknown";
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nTrunk Size: " + getTrunkLabelSize();
	}
}
