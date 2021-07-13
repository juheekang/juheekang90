package chapter15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chapter07.Driver;

public class StudentDAO {

	public List<StudentDTO> selectStudent() throws Exception {
		//1.JDBC 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.로딩된 드라이버를 통해 DBMS 접속 준비
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJH90","java");// 구글에 oracle jdbc driver url 검색하여 주소 가져오기
	 	//3.Query문장을 접속할 객체(sql developer에서 쿼리 작성 화면 보여줌) 생성
		Statement statement = connection.createStatement();
		//4.SQL문장을 Statement 객체를 이용하여 실행 , 
		ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT"); // 문장끝에 ; 을 반드시 제거/ executeQuery로 insert,update, delete를 모두 쓸수있다
		List<StudentDTO> list = new ArrayList<>();
		//5.조회결과 가져오기
		//6.사용된 자원 반납
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String mobile_number = resultSet.getString("mobile_number");
			
			list.add(new StudentDTO(id, name, email, mobile_number));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	public int intsertStudent(StudentDTO dto) throws Exception {
	
		//DB 접속해서 데이터입력
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJH90","java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO STUDENT(");
		builder.append("ID,");
		builder.append("NAME,");
		builder.append("EMAIL,");
		builder.append("MOBILE_NUMBER");
		builder.append(") VALUES (");
		builder.append("'"+dto.getId()+ "',");
		builder.append("'"+dto.getName()+ "',");
		builder.append("'"+dto.getEmail()+ "',");
		builder.append("'"+ dto.getMobileNumber() + "'");
		builder.append(")");
		int executeUpdate = statement.executeUpdate(builder.toString());
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public int updateStudent(StudentDTO dto) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJH90","java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE STUDENT");
		builder.append("    SET");
		builder.append("        EMAIL = ?,");
		builder.append("        MOBILE_NUMBER = ?");
		builder.append("WHERE");
		builder.append("    ID = ?");
		// 미리 sql문장을 준비하는 객체 사용
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, dto.getEmail());
		statement.setString(2, dto.getMobileNumber());
		statement.setString(3, dto.getId());
		
		int executeUpdate = statement.executeUpdate();//위에 쿼리가 있기때문에 ()안에 builder.toString()하지 않음
		
//		Statement statement = connection.createStatement();
//		StringBuilder builder = new StringBuilder();
//		builder.append("UPDATE STUDENT");
//		builder.append("    SET");
//		builder.append("        EMAIL = '"+dto.getEmail()+"',");
//		builder.append("        MOBILE_NUMBER = '"+dto.getMobileNumber()+"'");
//		builder.append("WHERE");
//		builder.append("    ID = '"+dto.getId()+"'");
//		int executeUpdate = statement.executeUpdate(builder.toString());
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public int deleteStudent(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJH90","java");
		PreparedStatement statement = connection.prepareStatement("DELETE FROM STUDENT WHERE ID = ?");
		statement.setString(1, id);
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
	}
}
