package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaedeokHotel2 {
	Map<Integer, Room> DDHMap = new HashMap<Integer, Room>();
	Scanner scn = new Scanner(System.in);
	
	// 생성자 - 호텔 객실 초기화
	public DaedeokHotel2() {
		DDHMap = new HashMap<Integer, Room>();
		scn = new Scanner(System.in);
		
		for (int i = 2; i <= 4; i++) {
			String roomType = null;
			switch(i) {
			case 2 : roomType = "싱글룸"; break;
			case 3 : roomType = "더블룸"; break;
			case 4 : roomType = "스위트룸"; break;
			}
			for (int j = 1; j <= 9; j++) {
				int roomNum = i * 100 + j;
				DDHMap.put(roomNum, new Room(roomNum, roomType));
			}
		}
	}
	
	public static void main(String[] args) {
		new DaedeokHotel2().DaedeokHotelOpen();
	}

	// 메뉴를 출력하고 작업번호를 입력받아서 반환하는 메서드
	private int displayMenu() {
		System.out.println("--------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인\t2.체크아웃\t3.객실상태\t4.업무종료");
		System.out.println("--------------------------------------");
		System.out.print("선택>> ");
		int num = scn.nextInt();
		return num;
	}
	 
	 //프로그램 시작하는 메서드
	 public void DaedeokHotelOpen() {
			System.out.println("****************************");
			System.out.println("호텔문을 열었습니다. 어서오십시오.");
			System.out.println("****************************");
			System.out.println();
			
			while(true) {
				int choice = displayMenu();
			switch(choice) {
			case 1:
				checkIn(); break;
			case 2:
				checkOut(); break;
			case 3:
				guestRoom(); break;
			case 4:
				System.out.println("****************************");
				System.out.println("\t호텔문을 닫습니다.");
				System.out.println("****************************");
				return;
			default : System.out.println("다시 입력해주세요.");
				
			}
		}
	 }
	
	 // 1. 체크인 메서드
	 private void checkIn() {
		 System.out.println("--------------------");
		 System.out.println("체크인 작업");
		 System.out.println("--------------------");
		 System.out.println("* 201~209 : 싱글룸\n* 301~309 : 더블룸\n* 401~409 : 스위트룸");
		 System.out.print("방 번호 입력>> ");
		 int roomNum = scn.nextInt();
		 
		 // 객실의 존재여부 검사
		 if(!DDHMap.containsKey(roomNum)) {
			 System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			 return;
		 } 
		 // 해당 객실에 다른 투숙객이 있는지 검사
		 if(DDHMap.get(roomNum).getGuestName() != null){
			 System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
		 }
			 System.out.println("누구를 체크인 하시겠습니까?");
			 System.out.print("이름 입력>> ");
			 String name = scn.next();
			 
			 // 입력받은 투숙객 이르을 해당 객실의 투숙객 명단에 저장한다.
			 DDHMap.get(roomNum).setGuestName(name);
			 System.out.println("체크인이 완료되었습니다.");
	 }
	 
	 //3. 객실 상태
	 private void guestRoom() {
		
		 // 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		 ArrayList<Integer> roomNumList = new ArrayList<>(DDHMap.keySet());
		 Collections.sort(roomNumList); //방번호의 오름차순 정렬 
		 
		 System.out.println("---------------------------");
		 System.out.println("\t현재 객실 상태");
		 System.out.println("---------------------------");
		 System.out.println("방번호 \t방종류 \t투숙객이름");
		 System.out.println("---------------------------");
		 
		 //List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 대한 Room객체를 구해서 출력한다.
		 for (int num : roomNumList) {
			Room r = DDHMap.get(num);
			
			//이름이 null이면 '-'를 출력 아니면 이름을 출력
			String name = r.getGuestName();
			if(name == null) name = "-";
			
//			System.out.println(num);
			System.out.println(r.getRoomNum() + "\t" + r.getRoomType() + "\t" + name);
		}
		 
	 }
	 
	 //2. 체크아웃
	 private void checkOut() {
		 System.out.println("---------------------------");
		 System.out.println("\t체크아웃 작업");
		 System.out.println("---------------------------");
		 System.out.println("체크아웃 할 방 번호를 입력하세요");
		 System.out.print("방번호 입력>> ");
		 int num = scn.nextInt();
		if (!DDHMap.containsKey(num)) {
			 System.out.println(num + "호 객실은 존재 하지 않습니다.");
			 return;
		}
		//해당객실에 투숙객이 없는지 검사
		if(DDHMap.get(num).getGuestName() == null){
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
	 	}
		//해당 객실의 현재 투숙객 이름을 구한다.
		String name = DDHMap.get(num).getGuestName();
		//체크아웃 작업은 해당 객실의 투숙객이름을 null로 변경한다.
		DDHMap.get(num).setGuestName(null);
		System.out.println(num + "호 객실의 " + name + "님 체크아웃을 완료하였습니다.");
	 	
	}
	 
	 
	 class Room {
		 int roomNum;
		 String roomType;
		 String guestName;
		public Room(int roomNum, String roomType) {
			super();
			this.roomNum = roomNum;
			this.roomType = roomType;
			
		}
		public int getRoomNum() {
			return roomNum;
		}
		public void setRoomNum(int roomNum) {
			this.roomNum = roomNum;
		}
		public String getRoomType() {
			return roomType;
		}
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
		public String getGuestName() {
			return guestName;
		}
		public void setGuestName(String guestName) {
			this.guestName = guestName;
		}
		@Override
		public String toString() {
			return roomNum + "\t" + roomType + "\t" + guestName;
		}
		 
	 }
}
