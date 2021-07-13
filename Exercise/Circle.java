package Exercise;

public class Circle {
	private double radius, x, y, area;
	
	public Circle( ) {
		
	}
	public double getArea() {
		return getRadius()*getRadius()*Math.PI;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		//radius값이 초기 0이어서 0보다 작으면 if문이 실행되지않아 0으로 결과값이 나옴
		if(radius > 0) {
			this.radius = radius;
			return;
		}
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
