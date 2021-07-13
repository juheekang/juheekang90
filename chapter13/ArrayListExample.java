package chapter13;

import java.util.List;
import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
//		generic은 1.5부터 나옴
//		jdk 1.7부터는  생성시  generic type을 선언하지 않아도 된다
//		type inference(타입추론)
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
//		2번째 인덱스에넣음, 3번부터 뒤로 밀림
		list.add(2,"Database");
		list.add("myBatis");
		
		int size = list.size();//배열의 length 속석과 유사
		System.out.println("총 객체수: "+ size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: "+ skill);
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : "+ str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("myBatis");
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : "+ str);
		}
	}

}
