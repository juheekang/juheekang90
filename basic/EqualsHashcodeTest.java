package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashcodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("일지매");
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
		System.out.println(p1.equals(p2));//p1 == p2과 같다
		System.out.println();
		System.out.println(p1);//변수뒤에 .toString()생략되어있다. 
		System.out.println(p2.toString());
		
		System.out.println("=====================================");
		
		HashSet<Person> testSet = new HashSet<Person>();
			testSet.add(p1);
			testSet.add(p2);
//			hashcode : 객체를 구별하기 위한 참조 값, 주민등록번호같은 값 
			System.out.println("set의 크기 : " + testSet.size());
			
			System.out.println("p1 hashcode : " + p1.hashCode());
			System.out.println("p1 hashcode : " + p2.hashCode());
	}

}

class Person{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person 데이터 : id=" + id + ", name=" + name;
	}
/*	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		//현재의 나와 Object와 비교
		if(this == obj) {
			return true;
		}
		//같은 유형의 클래스인지 검사
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		// 매개변수의 값을 현재 객체유형으로 형변환한다.
		Person temp = (Person) obj;
		
		if(this.name == null && temp.name != null) {
			return false;
		}
		if(this.id == temp.id && this.name == temp.name) {
			return true;
		}
		if(this.id == temp.id && this.name.equals(temp.name)) {
			return true;
		}
		return false;
	}
	@Override
	//두개의 값이 같으면 해시코드의 값을 같게 
	public int hashCode() {
		if(name != null) {
		return ("" + id + name).hashCode();
		}else {
			return ("" + id).hashCode();
		}
	}*/

}