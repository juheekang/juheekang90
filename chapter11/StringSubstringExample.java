package chapter11;

import java.util.regex.Pattern;

public class StringSubstringExample {

	public static void main(String[] args) {
		String ssn = "880815-1234567";
		String ssn1 = "010-1234-5678";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
		Pattern.matches([0-9]{3}-[0-9]{4}-[0-9]{4}, input)
	}

}
