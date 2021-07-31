package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 별명중에 
 * 		볆명의 길이가 제일 긴 별명을 출력하시오
 * 		(단, 각 별명의 길이는 모두 다르게 입력한다.)
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("5명의 별명을 입력하시오");
		
		String longest= list.get(0);// 또는 "" 을 사용해도 되지만 반복문을 최소하하기위해
		for (String nicName : list) {
			String name = scanner.next();
			list.add(name);
			// 제일 긴 별명이 저정될수 있는 변수 선언하고 이변수에는 List의 첫번째 
			//데이터로 초기화한다.
			if (nicName.length() > longest.length()) {
				longest = nicName;
			}
		}
		
		for (String nicName : list) {
			if(nicName.length() == longest.length()) {
				System.out.println(nicName);
		
			}
		}
//문제2) 문제1에서 별명의 길이가 같은것을 입력할 수 있을 경우에 대해 처리하시오 
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 별명:");
			String alias = scanner.next();
			list.add(alias);
		}
		//제일 긴 별명의 길이가 저장될 변수를 선언하고 
		//이변수에 첫번쨰 데이터의 길이를 저장한다.
		int maxLen= list.get(0).length();
		
		for (int i = 1; i < list.size(); i++) {
			if (maxLen < list.get(i).length()) {
				maxLen = list.get(i).length();
			}
		}
		System.out.println("제일긴 별명들");
		for (String alias : list) {
			if(maxLen == alias.length()) {
				System.out.println(alias);
			}
		}
		scanner.close();	
	}
}

		