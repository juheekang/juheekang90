package chapter04;

import java.util.Random;

public class looping03 {

	public static void main(String[] args) {
		Random random = new Random();
	
		while(true) {
			int x = random.nextInt(6)+1;
			int y = random.nextInt(6)+1;
			System.out.println("(" + x + "," + y + ")");
			if((x+y) == 5) {
				break;
			}
		}
	
		/*
		 * while (true) {
		 * 
		 * int num1 = random.nextInt(6)+1; int num2 = random.nextInt(6)+1;
		 * System.out.println("("+num1+","+num2+")"); if ((num1 + num2) == 5) { break; }
		 * }
		 */	  
	}
}