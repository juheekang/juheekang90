package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
	Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	(Map의 구조는 key값으로 '이름'을 사용하고
		value값으로는 'Phone클래스의 인스턴스'로 한다.)
		
	HashMap<String, Phone> 변수명 ;
	
	아래 메뉴 및 예시에 맞는 기능을 구현하시오.
	==> 삭제, 검색은 '이름'을 입력받아서 처리한다.
	
	- 추가 조건)
	1) '6. 전화번호 저장' 메뉴를 추가하고 해당 기능을 구현한다.
	 	(저장파일명은 'phoneData.dat'로 한다.)
	2) 프로그램을 시작할 때 저장된 파일이 있으면 그 데이터를 읽어와
	   Map에 셋팅한다.
	3) 프로그램을 종료할 때 Map의 데이터가 변경되거나 추가 또는 삭제되었으면
	   저장 후 종료되도록 한다.
	
실행 예시)
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
--------------------------
번호입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이 름 >> 홍길동
전화번호 >> 010-1234-5678
주 소 >> 대전시 중구 대흥동

'홍길동'전화번호 등록 완료!!

	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
--------------------------
번호입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이 름 >> 홍길동

'홍길동'은 이미 등록된 사람입니다.

	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
--------------------------
번호입력 >> 5

------------------------------------------------
번호    이름      전화번호            주소
------------------------------------------------
 1    홍길동    010-1234-5678  대전시 중구 대흥동
~~~~
~~~~
------------------------------------------------
출력 완료...

	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
--------------------------
번호입력 >> 0

프로그램을 종료합니다.

*/
public class PhoneBookTest {
	private HashMap<String, Phone> phoneBookMap;
	private Scanner scan;
	private String fileName = "d:/d_other/phoneData.dat";
	
	// 데이터의 변경 여부를 나타내는 변수 선언
	// 이 변수 값이 true이면 데이터가 변경된 것으로 한다.
	private boolean dataChange;
	
	public PhoneBookTest() {
		// 저장된 파일을 읽어와서 Map에 셋팅한다.
		phoneBookMap = load(); 
		
			if(phoneBookMap == null) {	// 파일이 없거나 잘못되었을때 새로운 객체를 생성하도록 한다. 
				phoneBookMap = new HashMap<String, Phone>();
			}	
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new PhoneBookTest().phoneBookStart();
	}
	
	// 프로그램을 시작하는 메서드
	public void phoneBookStart() {
		System.out.println("==============================");
		System.out.println("     전화번호 정보 관리 프로그램");
		System.out.println("==============================");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
				case 1 :	// 등록
					insert();	break;
				case 2 :	// 수정
					update();	break;
				case 3 :	// 삭제
					delete();	break;
				case 4 :	// 검색
					search();	break;
				case 5 :	// 전체 출력
					displayAll(); break;
				case 6 :	// 저장(
					save(); break;
				case 0 :	// 프로그램 종료
					if(dataChange == true) { //데이터가 변경되었으면 ..
						System.out.println("변경된 데이터를 저장합니다.");
						save();
					}
					
					System.out.println("프로그램을 종료합니다.");
					//System.exit(0);
					return;
				default :
					System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 입력하세요.");
					break;
			}
			
		}
	}
	
	// 전화번호 정보가 저장되 파일을 읽어오는 메소드
	private HashMap<String, Phone> load(){
		HashMap<String, Phone> pMap = null;	//읽어온 데이터가 저장될 변수
		
		File file = new File(fileName);
		if(!file.exists()) {  //저장된 파일이 없으면..
			return null;
		}
		
		ObjectInputStream ois = null;
		try {
			// 객체 입력용 스트림 객체 생성
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			pMap = (HashMap<String, Phone>) ois.readObject();
			
		} catch (IOException e) {
			return null;
			//e.printStackTrace(); // 에러가 나면 프로그램 종료
		} catch (ClassNotFoundException e) {
			return null;
			//e.printStackTrace();
		} finally {
			// 사용했던 스트리 객체 닫기
			if(ois != null) try {ois.close();}catch(IOException e) {}
		}
		
		return pMap;
	}
	
	
	
	
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 해당 사람이 없으면 검색작업을 끝낸다.
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("검색 작업을 마칩니다.");
			return;
		}
		
		Phone p = phoneBookMap.get(name);
		
		System.out.println("검색한 " + name + "씨 전화번호 정보");
		System.out.println("=====================");
		System.out.println(" 이   름 : " + p.getName());
		System.out.println(" 전화번호 : " + p.getTel());
		System.out.println(" 주   소 : " + p.getAddr());
		System.out.println("=====================");
		System.out.println("검색작업 완료...");
		
	}
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 해당 사람이 없으면 삭제작업을 끝낸다.
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("삭제 작업을 마칩니다.");
			return;
		}
		
		phoneBookMap.remove(name);
		System.out.println(name + "씨 전화번호 정보를 삭제했습니다.");
		dataChange = true;
	}
	
	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 해당 사람이 없으면 수정작업을 끝낸다.
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("수정 작업을 마칩니다.");
			return;
		}
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();
		
		scan.nextLine();  // 입력 버퍼 비우기
		System.out.print("새로운 주소 >> ");
		String newAddr = scan.nextLine();
		
		// 방법1 ==> get()메서드로 value값을 구해서 처리하기
//		Phone p = phoneBookMap.get(name);
//		p.setTel(newTel);
//		p.setAddr(newAddr);
		
		// 방법2 ==> 같은 key값에 새로운 전화번호 정보를 추가한다.
		//			==> 나중의 데이터로 변경된다.
		phoneBookMap.put(name, new Phone(name, newAddr, newTel));
		
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다.");
		dataChange = true;
	}
	
	
	
	// 전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		
		Set<String> phoneKeySet = phoneBookMap.keySet();
		
		System.out.println("---------------------------------");
		System.out.println(" 번호    이름     전화번호    주소");
		System.out.println("---------------------------------");
		
		if(phoneKeySet.size()==0) {
			System.out.println("   등록된 전화번호 정보가 하나도 없습니다.");
		}else {
			int cnt = 0;  // 번호 출력용
			for(String name : phoneKeySet ) {
				cnt++;
				Phone p = phoneBookMap.get(name);
				System.out.println(" " + cnt + "\t" + p.getName() +
						"\t" + p.getTel() + "\t" + p.getAddr());
			}
		}
		
		System.out.println("-------------------------------------");
		System.out.println("출력 끝...");
		
	}
	
	
	
	// 새로운 전화번호 정보를 등록하는 메서드
	// 이미 등록된 사람을 등록되지 않는다.
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 이미 등록된 사람인지 검사
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		scan.nextLine();  // 입력 버퍼 비우기
		System.out.print("주 소 >> ");
		String addr = scan.nextLine();
		
		// 입력받은 데이터를 Phone객체에 저장한 후 Map에 추가한다.
//		Phone p = new Phone(name, addr, tel);
//		phoneBookMap.put(name, p);
		
		phoneBookMap.put(name, new Phone(name, addr, tel));
		System.out.println(name + "씨 전화번호 등록 완료!!!");
		dataChange = true;
	}
	
	
//	- 추가 조건)
//	1) '6. 전화번호 저장' 메뉴를 추가하고 해당 기능을 구현한다.
//	 	(저장파일명은 'phoneData.dat'로 한다.)
//	2) 프로그램을 시작할 때 저장된 파일이 있으면 그 데이터를 읽어와
//	   Map에 셋팅한다.
//	3) 프로그램을 종료할 때 Map의 데이터가 변경되거나 추가 또는 삭제되었으면
//	   저장 후 종료되도록 한다.	
	
	
	// 전화번호 정보를 파일로 저장하는 메서드
	private void save() {
		ObjectOutputStream oos = null;
		try {
			// 객체 출력용 스트림 객체 생성
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
			// Map 객체를 파일로 저장한다.
			oos.writeObject(phoneBookMap);
			
			System.out.println("저장이 완료되었습니다.");
			dataChange = false;
			
		} catch (IOException e) {
			System.out.println("파일 저장 실패 : " + e.getMessage());
		} finally { 
			//사용했던 스트림 객체 닫기
			if(oos != null)try { oos.close(); } catch(IOException e) {}
		}
	}
	
	
	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 6. 전화번호 저장");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("----------------------");
		System.out.print("번호입력 >> ");
		int num = scan.nextInt();
		return num;
	}
	
	

}



// 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String addr;
	private String tel;
	
	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
}





