package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
//	로또를 구매하는 프로그램 작성하기
//	 
//	 사용자는 로또를 구매할 때 구매할 금액을 입력하고
//	 입력한 금액에 맞게 로또번호를 출력한다.
//	 (단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
//	      거스름돈도 계산하여 출력한다.)
//
//		==========================
//	         Lotto 프로그램
//		--------------------------
//		 1. Lotto 구입
//		 2. 프로그램 종료
//		==========================		 
//		메뉴선택 : 1  <-- 입력
//				
//		 Lotto 구입 시작
//			 
//		(1000원에 로또번호 하나입니다.)
//		금액 입력 : 2500  <-- 입력
//				
//		행운의 로또번호는 아래와 같습니다.
//		로또번호1 : 2,3,4,5,6,7
//		로또번호2 : 20,21,22,23,24,25
//				
//		받은 금액은 2500원이고 거스름돈은 500원입니다.
//
//		==========================
//	         Lotto 프로그램
//		--------------------------
//		 1. Lotto 구입
//		 2. 프로그램 종료
//		==========================		 
//		메뉴선택 : 1  <-- 입력
//				
//		 Lotto 구입 시작
//			 
//		(1000원에 로또번호 하나입니다.)
//		금액 입력 : 900  <-- 입력
//		
//		입력 금액이 너무 적습니다. 로또번호 구입 실패!!!
//
//		==========================
//	         Lotto 프로그램
//		--------------------------
//		 1. Lotto 구입
//		 2. 프로그램 종료
//		==========================		 
//		메뉴선택 : 1  <-- 입력
//				
//		 Lotto 구입 시작
//			 
//		(1000원에 로또번호 하나입니다.)
//		금액 입력 : 101000  <-- 입력
//		
//		입력 금액이 너무 많습니다. 로또번호 구입 실패!!!
//				
//	   	 ==========================
//	         Lotto 프로그램
//		--------------------------
//		  1. Lotto 구입
//		  2. 프로그램 종료
//		==========================		 
//		메뉴선택 : 2  <-- 입력
//			
//		감사합니다
//	private final int MONEY = 1000;
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Random ran = new Random();
		while(set.size() < 6) {
			set.add(ran.nextInt(45) + 1);
		}
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Scanner sca = new Scanner(System.in);
		while(true) {
		System.out.println("============================");
		System.out.println("Lotto 프로그램");
		System.out.println("----------------------------");
		System.out.println("1.Lotto 구입\n2.프로그램 종료");
		System.out.println("============================");
		System.out.print("메뉴선택: ");
		int num1 = sca.nextInt();

		switch (num1) {
			case 1:
				System.out.println("Lotto 구입 시작");
				System.out.println();
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력: ");
				int money = sca.nextInt();
				System.out.println();
				while (true) {
					if (money < 1000) {
						System.out.println("입력 금액에 너무 적습니다. 로또번호 구입 실패!!!");
						break;
					} else if (money > 100000) {
						System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
						break;
					} else {
						int nextnum = ran.nextInt();
						int leftMoney = money % 1000;
						int spentMoney = money / 1000;
						System.out.println("행운의 로또번호는 아래와 같습니다.");
						for (int i = 0; i < spentMoney; i++) {
							System.out.print("로또번호"+ (i+1) + ":" + getRandomLottoNum() + "\n");
							getRandomLottoNum().clear();// 숫자가 1개만나오거나 똑같은 숫자가 6개나올수있다.
							System.out.println();
						}
						System.out.println("받은 금액은 "+ money + "원이고 거스름돈은" + leftMoney + "원입니다.");
						break;
					}
				}
				break;
			case 2:
				System.out.println("감사합니다");
				break;	
			default : 
				System.out.println("번호를 잘못입력했습니다. 다시입력하세요.");
			}
		}
	}
	public static List<Integer> getRandomLottoNum() {
		HashSet<Integer> rndLotto = new HashSet<Integer>();
		Random rnd = new Random();
		
		while(rndLotto.size() < 6) {
			rndLotto.add(rnd.nextInt(45)+1);
		}
		ArrayList<Integer> rndLottoNumList = new ArrayList<Integer>(rndLotto);
		Collections.shuffle(rndLottoNumList);
		
		return rndLottoNumList;
	}
}


