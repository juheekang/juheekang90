package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class DaedeokHotel {
	HashMap<Integer, Room> DDHMap = new HashMap<Integer, Room>();
	Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		new DaedeokHotel().DaedeokHotelOpen();
	}

	private int displayMenu() {
		System.out.println("--------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인\t2.체크아웃\t3.객실상태\t4.업무종료");
		System.out.println("--------------------------------------");
		System.out.println("선택>> ");
		int choice = scn.nextInt();
		return choice;
	}

	// 프로그램 시작하는 메서드
	public void DaedeokHotelOpen() {
		System.out.println("****************************");
		System.out.println("호텔문을 열었습니다. 어서오십시오.");
		System.out.println("****************************");
		System.out.println();

		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				guestRoom();
				break;
			case 4:
				System.out.println("****************************");
				System.out.println("\t호텔문을 닫습니다.");
				System.out.println("****************************");
				return;
			default:
				System.out.println("다시 입력해주세요.");

			}
		}
	}

	// 1. 체크인 메서드
	public void checkIn() {
		System.out.println("--------------------");
		System.out.println("체크인 작업");
		System.out.println("--------------------");
		System.out.println("* 201~209 : 싱글룸\n* 301~309 : 더블룸\n* 401~409 : 스위트룸");
		System.out.print("방 번호 입력>> ");
		int roomNum = scn.nextInt();
		if (!DDHMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			return;
		} else if (DDHMap.get(roomNum).getName() == "-") {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력>> ");
			String name = scn.next();
			DDHMap.put(roomNum, new Room(roomNum, name));
			System.out.println("체크인이 완료되었습니다.");
		} else {
			System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
		}
	}

	// 3. 객실 상태
	public void guestRoom() {
		System.out.println("---------------------------");
		System.out.println("\t현재 객실 상태");
		System.out.println("---------------------------");
		System.out.println("방번호 \t방종류 \t투숙객이름");
		System.out.println("---------------------------");
		
	}e

	// 2. 체크아웃
	public void checkOut() {
		System.out.println("---------------------------");
		System.out.println("\t체크아웃 작업");
		System.out.println("---------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요");
		System.out.print("방번호 입력>> ");
		int roomNum = scn.nextInt();
		if (!DDHMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재 하지 않습니다.");
		} else if (DDHMap.get(roomNum).getName() == "-") {
			System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
		} else {
			System.out.println(roomNum + "호 객실의 " + DDHMap.get(roomNum).getName() + "님 체크아웃을 완료하였습니다.");
		}
	}

	// 객실 생성
	public void creatRoom() {
		for (int i = 2; i <= 4; i++) {
			String roomName = null;
			switch (i) {
			case 2:
				roomName = "싱글룸";
				break;
			case 3:
				roomName = "더블룸";
				break;
			case 4:
				roomName = "스위트룸";
				break;
			}
			for (int j = 1; j <= 9; j++) {
				int roomNum = i * 100 + j;
				DDHMap.put(roomNum, new Room(roomNum, roomName));
			}
		}
	}

	class Room {
		int roomNum;
		String roomName;
		String name;

		public Room(int roomNum, String roomName) {
			super();
			this.roomNum = roomNum;
			this.roomName = roomName;
//			this.name = name;
		}

		public int getRoomNum() {
			return roomNum;
		}

		public void setRoomNum(int roomNum) {
			this.roomNum = roomNum;
		}

		public String getRoomName() {
			return roomName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return roomNum + "\t" + roomName + "\t" + name;
		}

	}
}
