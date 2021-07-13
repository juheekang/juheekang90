package chapter08.exercise;

public class Shape implements Comparable<Shape> {

	public Shape() {
		
	}
	public double area() {
		return  0.0;
	}
	public double perimeter() {
		return  0.0 ;
	}
	/*20 10 30-> 10 20 30
	 * 비교해서 정렬할때 필요
	 * return이 
	 * 0(=같음)이면 정렬 메소드에서 순서를 바꾸지 않는다.
	 * 1(좌과우를 비교하여 좌가 크면)이면 배열데이터의 순서를 바꿔준다.
	 * -1이면 배열 데이터의 순서를 바꾸지 않는다.
	 * 
	 * 현재 도형의 넓이 (area())와 매개변수로 넘어온 도형의 넓이(o.area())를 비교해서 현재도형의넓이가 크면
	 * 1을 리턴 같으면 0을 리턴 작으면 -1을 리턴
	 */
	@Override
	public int compareTo(Shape o) {
		if(area() > o.area()) {
			return 1;
		}else if (area() < o.area()) {
			return -1;
		} return 0;
	}
}
