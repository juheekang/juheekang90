package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
	10마리의 말들이 경주하는 프로그램을 작성하시오
	
	말은 Horse라는 이름의 스레드 클래스로 작성하는데 
	이 클래스는 말이름(String), 현재위치-말이 뛰는구간(int), 등수(int)를 멤버변수로 갖는다.
	그리고 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
	(Comparable인터페이스 구현)
	
	경기구간은 1 ~ 50구간으로 되어있다.
	
	경기 중 중간중간에 각 말들의 위치를 나타낸다.
	예)
	01번말 ---->-------------------------
	02번말 ---------->-------------------
	...
	10번말 ------->----------------------
	
	경기가 끝나면 등수 순으로 줄력한다.
 */
public class ThreadTest14 {

	public static void main(String[] args) {
		
//		Horse[] horses = new Horse[] {
//				new Horse("1번말"), new Horse("2번말"), new Horse("3번말"),
//				new Horse("4번말"), new Horse("5번말"), new Horse("6번말"),
//				new Horse("7번말"), new Horse("8번말"), new Horse("9번말"), new Horse("10번말")};
		
		
//		GameStatThread gst = new GameStatThread(horses);
//		for (Horse h : horses) {
//			h.start();		//말의 경주 시작
//		}
//		
//		gst.start();		//말들의 현재 위치를 출력하는 스레드 시작
		
		
		ArrayList<Horse> horList = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			horList.add(new Horse(i + "번말"));
		}
		for (Horse h : horList) {
			h.start();
		}
		
		
		for (Horse h : horList) {
			try {
//				for(Horse h : horses) {
				h.join();
//				}
//				gst.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		// 등수의 오름차순으로 정렬하여 출력
//		Arrays.sort(horses);
		Collections.sort(horList);
		for (Horse horse : horList) {
			System.out.println(horse);
		}
//		System.out.println(Horse.currentRank);
	}

	public int Rank() {
		return 0;
	}

}

class Horse extends Thread implements Comparable<Horse> {
	private String horseName;
	private int horseLocation;
	private int horseRank;

	public static int currentRank = 0; // 각각의 말이 경기가 끝나면 1씩 증가한다., 말의 등수 구하는데 사용

	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getHorseLocation() {
		return horseLocation;
	}

	public void setHorseLocation(int horseLocation) {
		this.horseLocation = horseLocation;
	}

	public int getHorseRank() {
		return horseRank;
	}

	public void setHorseRank(int horseRank) {
		this.horseRank = horseRank;
	}

	@Override
	public String toString() {
		return "경주마 " + horseName + "은(는)" + horseRank + "등 입니다.";
	}

	// 스레드에서 달리기 기능 구현.. 경기 구간은 1 ~ 50 구간으로 되어 있다.
	@Override
	public void run() {
		Random rnd = new Random();
		for (int n = 1; n <= 50; n++) {
//			System.out.println(horseName + "의 위치: " + n + "구간");
			this.horseLocation = n; // 말의 현재 위치 저장
			setHorseRank(n);
			for (int i = 0; i < n; i++) {
				System.out.print("-");
			}
			System.out.print(">");
			for (int j = 49; j > n; j--) {
				System.out.print("-");
			}
			System.out.println();
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
			}
		}
		// 한마리의 말이 경주가 끝나면 등수를 구해서 저장
		currentRank++;
		System.out.println(horseName + "도착");
		this.horseRank = currentRank;
	}

	// 등수의 오름차순
	@Override
	public int compareTo(Horse o) {
		if (this.horseRank > o.horseRank) {
			return -1;
		} else if (this.horseRank < o.horseRank) {
			return 1;
		} else {
			return 0;
		}
	}
}

//// 경기중 말의 위치를 표시하는 스레드
//class GameStatThread extends Thread {
//	private Horse[] horses; // 경기에 참가한 말들을 저장할 배열
//
//	public GameStatThread(Horse[] horses) {
//		this.horses = horses;
//	}
//
//	@Override
//	public void run() {
//		while (true) {
//			// 모든 말들의 경기가 종료되었을 때 이 스레드도 종료되게 한다.
//			if(Horse.currentRank == horses.length) {
//				break;
//			}
//			
//			// i 번말
//			for (int i = 0; i < horses.length; i++) {
//				System.out.print(horses[i].getHorseName() + ":");
//				for (int j = 1; j <= 50; j++) {
//					if (j == horses[i].getHorseLocation()) {
//						System.out.println(">");
//					} else {
//						System.out.println("-");
//					}
//				}
//				System.out.println(); // 줄바꿈
//			}
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}
