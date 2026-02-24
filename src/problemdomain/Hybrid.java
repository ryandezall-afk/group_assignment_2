package problemdomain;

public class Hybrid extends Vehicle {
	private String powerTrain;
	private int electricRange;
	
	public Hybrid(long carID, String vehicleType, String subType, int speed, double fuel, 
			int seats, int year, String drivetrain, int price, int quantity, String powerTrain, int electricRange) {
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		this.powerTrain = powerTrain;
		this.electricRange = electricRange;
	}

	public String getPowerTrainCode() {
		return powerTrain;
	}
	
	public int getElectricRange() {
		return electricRange;
	}

	public String getPowerTrainType() {
		switch(powerTrain.toUpperCase()) {
		case "E": return "Series Hybrid";
		case "A": return "Parallel Hybrid";
		case "PHEV": return "Plug-in Hybrid";
		default: return "Unknown";
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nPower Train: " + getPowerTrainType() + "\nElectric Range: " + electricRange;
	}
}
