package Exercise;

public class Car {

	private double speed;
	private String color;
	private static final double MAX_SPEED = 200.0;
	double speedUp;
	
	public Car(){
	}
	
	public Car(String color){
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

//	public double MAX_SPEED() {
//		return MAX_SPEED;
//	}


	public static double getMaxSpeed() {
		return MAX_SPEED;
	}

	public boolean speedUp (double speed) {
		if (speed > 0 && speed < MAX_SPEED) {
			this.speed = speed;
			return true;
		}
			
		return false;
	}
//	public String toString() {
//		return null;
//	}

	
}
