package Exercise;

import chapter08.exercise.Shape;

public class Circle2 extends Shape{
	private double radius;
	
	public Circle2(double radius) {
		this.radius = radius;
	}
	@Override
	public double area (){ 
		return radius*radius*Math.PI;
	}
	@Override
	public double perimeter (){ 
		return radius*2*Math.PI;
	}
	@Override
	public String toString() {
		return "도형의 종류: 원, 둘레: "+ perimeter()+ "cm " + "넓이: "+ area() + "㎠"; 
	}
}
