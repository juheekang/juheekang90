package kr.or.ddit.basic;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 * 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 설정해서
 * 데이터를 초기화처리 한다.
 * 
 * 이 Student객체는 List에 저장하여 관리한다.
 * 
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 * 총점의 역순(총점의 내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부정렬 기준 클래스를
 * 작성하여 정렬한 결과를 출력하시오.
 * 
 * (등수는 List에 전체 데이터가 추가된 후에 구한다.)
 */ //공유폴더
public class StudentTest {
//	//등수를 구하는 메서드
//	public void setRanking(List<Student> stdLIst) {
//		for (Student std1 : stdList) {//기준이 ㅚ는 ㅔ이터 갯수만큼 반복
//			int rank = 1;//등수가 저장될 변수 (처음에는 1등으로 셋팅한다.
//			for (Student std2 : stdList) {
//				//기준보다 큰 값을 만나면 등수를 증가시킨다.
//				if (std1.getTotalScore() < std2.getTotalScore()) {
//					rank++;
//				}
//			}
//			//구해진 등수를 Student 객체의 rank변수에 저장한다.
//			std1.setRank(rank);
//		}
//	}
	public static void main(String[] args) {

		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1, "홍길동", 85, 95, 75));
		list.add(new Student(3, "강감찬", 75, 80, 95));
		list.add(new Student(4, "일지매", 100, 75, 80));
		list.add(new Student(6, "이순신", 90, 80, 88));
		list.add(new Student(2, "변학도", 80, 65, 75));
		list.add(new Student(5, "성춘향", 85, 78, 75));
//		//등수를 구하는 메서드를 호출하여 등수를 구한다.
//		stdTest.setRanking(stdList;)
		System.out.println("<< 정렬전 >>");
		for (Student student : list) {
			System.out.println(student);
		}
		Collections.sort(list);
		System.out.println("<< 학번의 오름차순 정렬후 >>");
		for (Student student : list) {
			System.out.println(student);
		}
//		외부정렬 기준을 사용해서 정렬하기
		for (int i = 0; i < list.size(); i++) {
	         for (int j = 0; j < list.size(); j++) {
	            if (list.get(i).getTotalScore() < list.get(j).getTotalScore()) {
	            	list.get(i).setRank(list.get(i).getRank()+1);
	            }
	         }
	      }
		Collections.sort(list, new sortTotalScore());
		System.out.println("<< 총점의 역순 정렬후 >>");
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
}

class Student implements Comparable<Student> {
	private int studentId;
	private String studentName;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	private int totalScore;
	private int rank;
	
	public Student(int studentId, String studentName, int koreanScore, int englishScore, int mathScore) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		this.totalScore = koreanScore + englishScore + mathScore;
		rank = 1;
	}
	//studentId 값의 오름차순
	@Override
	public int compareTo(Student stu) {
//		if(this.getStudentId() > stu.getStudentId()) {
//			return 1;
//		}else if(this.getStudentId() < stu.getStudentId()) {
//			return -1;
//		}else {
//			return 0;
//		}
		return Integer.compare(this.getStudentId(), stu.getStudentId()) * 1;
	}
	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", koreanScore=" + koreanScore
				+ ", englishScore=" + englishScore + ", mathScore=" + mathScore + ", totalScore=" + totalScore
				+ ", rank=" + rank + "]";
	}

	
	
}
class sortTotalScore implements Comparator<Student>{

//totalScore 값의 내림차순
	@Override
	public int compare(Student total1, Student total2) {
		if(total1.getTotalScore() > total2.getTotalScore()) {
			return -1;
		}else if(total1.getTotalScore() < total2.getTotalScore()) {
			return 1;
		}else {
			return total1.getStudentName().compareTo(total2.getStudentName());
		}
	}
	
}