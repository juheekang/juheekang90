package Exercise;

public class StudentTest {

	public static void main(String[] args) {
		Human man = new Human("Steve", 30);
		System.out.println(man);//man뒤에 .toString()이 생략되어있다
		
		Student student = new Student("Parker", 23, "Physics");
		System.out.println(student);
		
		student.setName("Peter");
		student.setAge(19);
		student.setMajor("Computer Science");
		
		System.out.print("이름: " + student.getName() + ", ");
		System.out.print("나이: " + student.getAge() + ", ");
		System.out.print("전공: " + student.getMajor());
	}

}
