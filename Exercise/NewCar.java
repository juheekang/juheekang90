package Exercise;

public class NewCar {

	private double speed;
	private String color;
	private static final double MAX_SPEED = 200.0 / 1.6; //마일 125
	double speedUp;
	
	NewCar(){
	}
	
	NewCar(String color){
		this.color = color;
		this.mileToKillo(speed);
	}

	public double getSpeed() {
		return mileToKillo(speed);
	}

	public void setSpeed(double speed) {
		this.killoToMile(speed);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

//	public Double MAX_SPEED() {
//		return MAX_SPEED;
//	}


	public static double getMaxSpeed() {
		return mileToKillo(MAX_SPEED);
	}

	public boolean speedUp (double speed) {
		if (speed > 0 && speed < mileToKillo(MAX_SPEED)) {
			this.speed = killoToMile(speed);
			return true;
		}
			
		return false;
	}
	private static double killoToMile (double distance) {
		return distance / 1.6;
	}
	private static double mileToKillo (double distance) {
		return distance * 1.6;
	}
	public String toString( ) {
		return null;
	
	}

}
