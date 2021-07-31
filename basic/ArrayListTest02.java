package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 이들중
 * 		'김'씨 성의 이름을 모두 출력하시오
 * 		(입력은 Scanner를 이용한다)
 */
public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("5명의 이름을 입력하세요");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).indexOf("김") == 0) {
				System.out.println(list.get(i));
			}
		}
		list.add(scanner.next());
		list.add(scanner.next());
		list.add(scanner.next());
		list.add(scanner.next());
		list.add(scanner.next());
//--------------------		
//		for (int i = 1; i <=5 ; i++) {
//			System.out.println(i + "번째 이름: ");
//			String name = scanner.next();
//			list.add(name);
//		}
		System.out.println();
		System.out.println("김씨성을 가진 사람들");
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			//김아무개
//			if(name.substring(0, 1).equals("김")) {
//				System.out.println(name);
//			}
//			if (name.charAt(0)=='김') {// 맨앞의 한글자만 꺼내옴, charAt은 문자형 
//				System.out.println(name);
//			}
//			if (name.indexOf("김")==0) {
//				System.out.println(name);
//			}
			if (name.startsWith("김")) { 
				System.out.println(name);
			}
			// contain은 김씨성을 찾는게 아니라 이름중 김을 찾는다.
		}
//		System.out.println("김씨성: "+ list.indexOf(scanner.nextLine()));
	}
}
