package chapter15;

public class StringBuilderExample {

	public static void main(String[] args) {
//		문자열을 빈번하게 이어붙일때 append를 사용
//		String 보다는 StringBuilder(싱글스레드) 와 StringBuffer(멀티)를 사용하는게 좋다
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("	MEM_ID,");
		builder.append("	MEM_NAME,");
		builder.append("	MEM_MAIL,");
		builder.append("	MEM_HP,");
		builder.append("	MEM_ADD1");
		builder.append("FROM");
		builder.append("	MEMBER");
		builder.append("WHERE");
		builder.append("	MEM_ADD1 LIKE '대전%'");
		System.out.println(builder.toString());
	}

}
