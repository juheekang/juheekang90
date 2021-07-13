package Exercise;

public class Human {

//	필드
	private String name;
	private int age;
//	생성자
	public Human() {
	}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
		
//  메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	//객체가 가지고 있는 주소값을 재정의
	public String toString() {
		return "이름: " + name + ",나이: " + age;
	}
}
