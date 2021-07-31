package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 		(Map의 구조는 key값으로 '이름'을 사용하고 value값으로는 'Phone클래스의 인스턴스'로 한다.)
 * 		HashMap<String, Phone> 변수명 ;
 * 
 * 		아래 메뉴 및 예시에 맞는 기능을 구현하시오
 * 		==> 삭제, 검색은 '이름'을 입력받아서 처리한다.
 * 
 * 	실행예시) 1. 전화번호 등록
 * 			2. 전화번호 수정
 * 			3. 전화번호 삭제
 * 			4. 전화번호 검색
 * 			5. 전화번호 전체 출력
 * 			0. 프로그램 종료
 * -----------------------------
 * 			번호입력 >> 1
 * 
 * 	새롭게 등록할 전화번호 정보를 입력하세요
 * 	이름 >> 홍길동
 * 	전화번호 >> 010-1234-5678
 * 	주 소 >> 대전시 중구 대흥동
 * 	
 * 	'홍길동'전화번호 등록 완료!!
 * 
 * 		 1. 전화번호 등록
 * 		 2. 전화번호 수정
 * 		 3. 전화번호 삭제
 * 		 4. 전화번호 검색
 * 		 5. 전화번호 전체 출력
 * 		 0. 프로그램 종료
 * -----------------------------
 * 		번호입력 >> 1
 * 새롭게 등록할 전화번호 정보를 입력하세요
 * 	이름 >> 홍길동
 * 
 * '홍길동'은 이미 등록된 사람입니다.
 * 
 * 		 1. 전화번호 등록
 * 		 2. 전화번호 수정
 * 		 3. 전화번호 삭제
 * 		 4. 전화번호 검색
 * 		 5. 전화번호 전체 출력
 * 		 0. 프로그램 종료
 * -----------------------------
 * 		번호입력 >> 5
 * 
 * -----------------------------
 * 번호   이름    전화번호           주소
 * -------------------------------------------
 *  1   홍길동   010-1234-5678   대전시 중구 대흥동
 *  ~~~~~
 * -------------------------------------------
 * 출력완료!
 * 
 * 		 1. 전화번호 등록
 * 		 2. 전화번호 수정
 * 		 3. 전화번호 삭제
 * 		 4. 전화번호 검색
 * 		 5. 전화번호 전체 출력
 * 		 0. 프로그램 종료
 * -----------------------------
 * 		번호입력 >> 0
 * 
 * 프로그램을 종료합니다.
 */
public class PhoneBookTest {
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<String, Phone> map = new HashMap<String, Phone>();
		PhoneBookTest phoneBookTest = new PhoneBookTest();
		Scanner scn = new Scanner(System.in);
		new PhoneBookTest().PhoneBookStart();
	}
	
	
	
	private int displayMenu() {

		System.out.println("1. 전화번호 등록\n2. 전화번호 수정\n3. 전화번호 삭제\n4. 전화번호 검색\n5. 전화번호 전체 출력\n0. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.print("번호입력 >> ");
		int num = scn.nextInt();
		return num;
	}

	int count = 1;

	// 프로그램 시작하는 메서드
	public void PhoneBookStart() {
		System.out.println("===========================");
		System.out.println("\t전화번호 정보 관리프로그램");
		System.out.println("===========================");
		System.out.println();
		while (true) {
			int choice = displayMenu();

			switch (choice) {

			case 1:
				inputInfo(); break;
			case 2:
				modifyInfo(); break;
			case 3:
				delete(); break;
			case 4:
				search(); break;
			case 5:
				displayAll(); break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public void inputInfo() {
//		HashMap<String, Phone> map = new HashMap<String, Phone>();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = scn.next();

		if (map.containsKey(name)) {
			System.out.println(name + "님은 이미 등록된 사람입니다.");
			return;// 메서드를 끝내고 자기를 호출한곳으로 돌아간다
		} else {
			System.out.print("전화번호 >> ");
			String inputPhoneNum = scn.next(); //띄어쓰기 전까지만 읽고 뒤의값은 뒤로넘어감
			scn.nextLine(); // Line 명령이 아닌 다른입력받는 명령을 사용했을때는 입력 버퍼 비우기 ,엔터값을 가져가서 버리는 작업을 해준다
			System.out.print("주 소 >> ");
			String inputAdd = scn.nextLine();// 띄어쓰기까지 가능
			// 입력받은 데이터를 Phone객체에 저장한후 Map에 추가한다.
			Phone phone = new Phone(name, inputPhoneNum, inputAdd);
			map.put(name, phone);
//			 map.put(inputName, new Phone(inputName, inputPhoneNum, inputAdd));

			System.out.println(name + "님 전화번호 등록 완료!!");
		}
	}

	public void modifyInfo() {
		System.out.println("수정할 전화번호의 이름을 입력하세요");
		System. out.print("이름 >> ");
		String name = scn.next();

		if (map.containsKey(name)) {
			System.out.println("수정할 전화번호를 입력하세요");
			String modifyPhoneNum = scn.next();
			map.put(name, new Phone(name, modifyPhoneNum, map.get(name).getAdd()));
			System.out.println(modifyPhoneNum + "님의 전화번호를 변경했습니다.");
			return;
		} else {
			System.out.println("등록되지 않은 사람입니다. 정보를 등록해주세요.");
		}
	}
	
	private void search() {
		System.out.println("전화번호 검색을 원하는 이름을 입력하세요");
		System.out.println("이름 >> ");
		String name = scn.next();
		if(!map.containsKey(name)) {
			System.out.println(name +"님의 전화번호 정보가 없습니다");
			System.out.println("검색작업을 마칩니다.");
			return;
		}
		Phone p = map.get(name);
		System.out.println("검색한" + name + "님의 전화번호 정보");
		System.out.println("================================");
		System.out.println(" 이름 : " + p.getName());
		System.out.println(" 전화번호 : " + p.getPhoneNum());
		System.out.println(" 주소 : " + p.getAdd());
		System.out.println("================================");
		System.out.println("검색작업 완료!");
//		if (map.containsKey(searchName) == true) {
//			map.get(searchName);

		}
	
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호의 이름을 입력하세요");
		System.out.println("이름>> ");
		String name = scn.next();
		if(!map.containsKey(name)) {
			System.out.println(name +"님의 전화번호 정보가 없습니다");
			System.out.println("삭제작업을 마칩니다.");
			return;
		}
		map.remove(name);
		System.out.println(name + "님의 전화번호 정보를 삭제했습니다.");
		
//		if (map.containsKey(name) == true) {
//			map.remove(name);
//			System.out.println(name + "전화번호 삭제 완료!");
//		} else {
//			System.out.println("등록되지 않은 사람입니다. 정보를 등록해주세요.");
//		}
	}
	

	private void displayAll() {
		System.out.println();

		Set<String> phoneKeySet = map.keySet();
		System.out.println("----------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t주소" + "\n");
		System.out.println("----------------------------------");

		if (phoneKeySet.size() == 0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		} else {
			int cnt = 0;// 번호 출력용
			for (String name : map.keySet()) {
				cnt++;
				Phone value = map.get(name);
				System.out.println(" " + count + "\t" + value.toString() + "\n");
			}
//		count=1;
		}
		System.out.println("----------------------------");
		System.out.println("출력끝");

	}

}

class Phone {
	private String name;
	private String phoneNum;
	private String add;

	public Phone(String name, String phoneNum, String add) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.add = add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return name + "\t" + phoneNum + "\t" + add;
	}
}