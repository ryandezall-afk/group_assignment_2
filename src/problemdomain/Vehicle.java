package problemdomain;

public abstract class Vehicle {
	private long carID;
	private String vehicleType;
	private String subType;
	private int speed;
	private double fuel;
	private int seats;
	private int year;
	private String drivetrain;
	private int price;
	private int quantity;
	
	public Vehicle(long carID, String vehicleType, String subType, int speed, double fuel, 
			int seats, int year, String drivetrain, int price, int quantity) {
		this.carID = carID;
		this.vehicleType = vehicleType;
		this.subType = subType;
		this.speed = speed;
		this.fuel = fuel;
		this.seats = seats;
		this.year = year;
		this.drivetrain = drivetrain;
		this.price = price;
		this.quantity = quantity;
	}
	
	public boolean isAvailable() {
		return quantity > 0;
	}
	
	public void checkout() {
		if (quantity > 0) {
			quantity--;
		}
	}

	//getters
	public long getCarID() {
		return carID;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getSubType() {
		return subType;
	}

	public int getSpeed() {
		return speed;
	}

	public double getFuel() {
		return fuel;
	}

	public int getSeats() {
		return seats;
	}

	public int getYear() {
		return year;
	}

	public String getDrivetrain() {
		return drivetrain;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Car ID: " + carID + "\nVehicle Type: " + vehicleType + "\nSub Type: " + subType + "\nSpeed=" + speed
				+ "\nFuel=" + fuel + "\nSeats: " + seats + "\nYear: " + year + "\nDriveTrain: " + drivetrain + "\nPrice: "
				+ price + "\nAvailable: " + quantity;
	}
	
	

}
