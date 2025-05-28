/**
 * Clase MountainBike, hereda de Bycicle
 * y sobreescribe el metodo printState
 * 
 */

public class MountainBike extends Bicycle implements Driveable{
	
  private String suspension;

  public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType){
    super(startCadence, startSpeed, startGear);
    this.setSuspension(suspensionType);
  }

  public String getSuspension(){
    return this.suspension;
  }

  public void setSuspension(String suspensionType){
    this.suspension = suspensionType;
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

  public void printStates(){
	System.out.println("\n -- MountainBike -- ");  
    super.printStates();
    System.out.println("The MountainBike has a " + getSuspension()
            + " suspension.");
  }
} 





