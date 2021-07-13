package Exercise;

import chapter08.exercise.Rectangle;
import chapter08.exercise.Shape;
import chapter08.exercise.Triangle;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle2(1.0);
		shapes[1] = new Triangle(2.0);
		shapes[2] = new Rectangle(2.0,3.0);
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
		
	}

}
