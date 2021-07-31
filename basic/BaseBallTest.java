package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * 문제) Set을 이용하여 숫자 야구게임 프로그램을 작성하시오.
 * 컴퓨터의 숫자는 난수를 이용하여 구한다.
 * (스트라이크 S, 볼은 B로 나타낸다.)
 * 
 * 예시) 컴퓨터의 난수 ==> 9 5 7
 * 
 * 실행 예시)
 * 숫자 입력 ==> 3 5 6
 * 3 5 6 ==> 1S 0B
 * 숫자입력 ==> 7 8 9
 * 7 8 9 ==> 0S 2B
 * 숫자입력 ==> 9 7 5
 * 9 7 5 ==> 1S 2B
 * 숫자입력 ==> 9 5 7
 * 9 5 7 ==> 3S 0B
 * 
 * 축하합니다. 당신은 4번째만에 맞췄습니다.
 */
public class BaseBallTest {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Random rnd = new Random();
		while (set.size() < 3) {
			set.add(rnd.nextInt(10) + 1);
		}
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		System.out.println("컴퓨터의 난수: " + list);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Scanner scn = new Scanner(System.in);
		int cnt = 0;

		while (true) {
			int b = 0;
			int s = 0;
			cnt++;
			System.out.println("숫자 입력>>");
			list2.add(scn.nextInt());
			list2.add(scn.nextInt());
			list2.add(scn.nextInt());
			
//			System.out.println(list2);
			for (int i = 0; i < list.size(); i++) {
				if (list2.get(i) == list.get(i)) {
					s++;
				}
			}

			for (int i = 0; i < list.size(); i++) {
				if (list2.get(i) != list.get(i) && list.contains(list2.get(i))) {
					b++;
				}
			}

			System.out.println(s + "s" + b + "b");
			list2.clear();
			
			if(s==3) {
				System.out.println(" 축하합니다. 당신은 "+ cnt + " 번째만에 맞췄습니다.");
				break;
			}
		}

	}
}
