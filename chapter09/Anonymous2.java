package chapter09;

public class Anonymous2 {
	Worker field = new Worker() {
	@Override		
	public void start() {
		System.out.println("디자인을 합니다.");
	}
};
	void method1() {
		Worker localVal = new Worker() {
		@Override
		public void start() {
			System.out.println("개발을 합니다.");
		}
		};
				localVal.start();
	}

	void method2(Worker worker)	{
		worker.start();
	}
}
