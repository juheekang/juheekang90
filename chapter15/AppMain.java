package chapter15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.logging.annotations.StringBlinder;

public class AppMain {
	public static void main(String[] args) throws Exception {
		StudentDAO dao = new StudentDAO();
		Scanner scanner = new Scanner(System.in);
		menu: while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("1.조회 | 2.선택 | 3.수정 | 4. 삭제 | 5. 종료");
			System.out.print("메뉴를 선택하세요: ");
			int menuNum = scanner.nextInt();
			switch (menuNum) {
			case 1:
				List<StudentDTO> list = dao.selectStudent();
//				System.out.println("아이디\t이름\t이메일\t\전화번호");
				for (StudentDTO dto : list) {
					System.out.println(String.format("%s\t%s\t%s\t%s", dto.getId(), dto.getName(), dto.getEmail(), dto.getMobileNumber()));
				}
				break;
			case 2:
				System.out.print("아이디: ");
				String id = scanner.next();
				System.out.print("이름: ");
				String name = scanner.next();
				System.out.print("이메일: ");
				String email = scanner.next();
				System.out.print("전화번호: ");
				String mobileNumber = scanner.next();
				int executeUpdate = dao.intsertStudent(new StudentDTO(id, name, email, mobileNumber));
				if (executeUpdate > 0) {
					System.out.println("정상 등록되었습니다.");
				}else {
					System.out.println("등록되지 않았습니다");
				}
				break;
			case 3:
				System.out.print("수정할 아이디: ");
				String updateId = scanner.next();
				System.out.print("수정할 이메일: ");
				String updateEmail = scanner.next();
				System.out.print("수정할 휴대전화번호: ");
				String updateMobileNumber = scanner.next();
				int updateStudent = dao.updateStudent(new StudentDTO(updateId, null, updateEmail, updateMobileNumber));
				if (updateStudent > 0) {
					System.out.println("정상 수정되었습니다.");
				}else {
					System.out.println("수정되지 않았습니다");
				}
				break;
			case 4:
				System.out.println("삭제할 아이디: ");
				String deleteId = scanner.next();
				int deleteStudent = dao.deleteStudent(deleteId);
				if (deleteStudent > 0) {
					System.out.println("삭제되었습니다.");
				}else {
					System.out.println("삭제되지 않았습니다.");
				}
				break;
			case 5:
				System.out.println("프로그램 종료");
				break menu;

			}
		}
		scanner.close();
	}

}
