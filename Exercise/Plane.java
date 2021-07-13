package Exercise;

public class Plane {
	private String manufature;
	private String model;
	private int maxNumberOfPassengers;
	private static int numberOfPlanes=0;
	
	Plane(){
		numberOfPlanes++;
	}

	Plane(String manufature, String model, int maxNumberOfPassengers) {
		this.manufature = manufature;
		this.model = model;
		this.maxNumberOfPassengers = maxNumberOfPassengers;
		numberOfPlanes++;

	}

	public String getManufature() {
		return manufature;
	}

	public void setManufature(String manufature) {
		this.manufature = manufature;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxNumberOfPassengers() {
		
		return maxNumberOfPassengers;
	}

	public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
		if(maxNumberOfPassengers > 0) {
			this.maxNumberOfPassengers= maxNumberOfPassengers;
//			return;
		}
	}
		
	public static int getNumberOfPlanes() {
		return numberOfPlanes;
	}
}
