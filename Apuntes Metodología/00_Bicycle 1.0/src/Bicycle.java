/**
 * Clase Bicycle con visibilidad public y private
 * 
 */

class Bicycle {

	private int cadence = 0;
	private int speed = 0;
	private int gear = 1;

	// Constructors
	public Bicycle() {
	}

	public Bicycle(int startCadence, int startSpeed, int startGear) {
		gear = startGear;
		cadence = startCadence;
		speed = startSpeed;
	}
	
	public Bicycle(Bicycle bike) {
		this.gear = bike.getGear();
		this.speed = bike.getSpeed();
		this.cadence = bike.getCadence();
	}

	// Observers
	public int getCadence() {
		return cadence;
	}

	public int getGear() {
		return gear;
	}

	public int getSpeed() {
		return this.speed;
	}

	// Modifiers
	public void setCadence(int newValue) {
		cadence = newValue;
	}

	public void setGear(int newValue) {
		gear = newValue;
	}

	public void applyBrake(int decrement) {
		speed -= decrement;
	}

	public void speedUp(int increment) {
		speed += increment;
	}

	@Override
	public String toString() {
		return "Bicycle [cadence=" + cadence + ", speed=" + speed + ", gear=" + gear + "]";
	}

	// Other observer
	/*
	 * public void printStates() { System.out.println(" -- Bicycle -- ");
	 * System.out.println("cadence: "+cadence+" speed: "+speed+" gear: "+gear); }
	 */

}
