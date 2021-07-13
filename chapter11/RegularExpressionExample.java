package chapter11;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpressionExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("아이디를 입력하세요");
			String id = scanner.next();
//		휴대전화번호 패턴 \\d{3}-[0-9]{4}-[0-9]{4}
//			   (id.matches("[a-z]\\w{7,}"))
			if (Pattern.matches("[a-z]\\w{7,}", id)) {
				System.out.println("올바른 아이디를 입력하셨습니다.");
				break;
			} else {
				System.out.println("아이디는 영문자로 시작하고 8글자 이상이어야합니다.");
			}
		}
		scanner.close();
	}
}
// 동일한패턴의 값을 일괄변경시 ctrl+ F -> (print|println)\(" 또는 (print(ln)?)\(" =====> \1\("a
// \1=>1번째()그룹부터, ()로 그룹을 묶음