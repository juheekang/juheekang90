package chapter09;

public class Anonymous2Example {
	public static void main(String[] args) {
		Anonymous2 anony = new Anonymous2();
		anony.field.start();
		anony.method1();
		anony.method2(
				new Worker() {
				@Override
				public void start() {
					System.out.println("테스트를 합니다.");
				}
				}
			);
	}
}
