package chapter10;

public class ThrowsExample {

	public static void main(String[] args) throws Exception {
//		try {
//			findClass();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		//직접 개발자가 에러를 만들어 발생시킴
		throw new Exception();
//		나를 호출한 메소드에게 에러를 떠넘김
//		throws
	}

	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
