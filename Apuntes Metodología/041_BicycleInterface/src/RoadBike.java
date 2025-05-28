/**
 * Clase RoadBike, hereda de Bycicle y sobreescribe el metodo printState
 * 
 */

public class RoadBike extends Bicycle implements Driveable {

	private int tireWidth; // In millimeters (mm)

	public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth) {
		super(startCadence, startSpeed, startGear);
		this.setTireWidth(newTireWidth);
	}

	public int getTireWidth() {
		return this.tireWidth;
	}

	public void setTireWidth(int newTireWidth) {
		this.tireWidth = newTireWidth;
	}

	public void printStates() {
		System.out.println("\n -- RoadBike -- ");
		super.printStates();
		System.out.println("The RoadBike has " + getTireWidth() + " MM tires.");
	}

	public void speedUp(int increment) {
		speed = speed + increment;
	}

	public void slowDown(int decrement) {
		speed = speed - decrement;
	}

	public void turnLeft(int amount) {
		direction = (direction + amount) % 360;
	}

	public void turnRight(int amount) {
		direction = (360 + direction - amount) % 360;
	}

}
