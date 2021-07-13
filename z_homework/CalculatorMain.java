package z_homework;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		double result = cal.add(123456, 654321);
		System.out.println(result);
		result = cal.multiply(result, 123456);
		System.out.println(result);
		result = cal.divide(result, 123456);
		System.out.println(result);
		result = cal.subtract(result, 654321);
		System.out.println(result);
		result = cal.remainder(result, 123456);
		System.out.println(result);
	}

}
