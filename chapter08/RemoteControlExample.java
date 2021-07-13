package chapter08;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl control = new Televisoin();
		control = new Audio();
		control.turnOn();
		control.setVolume(8);
		control.turnOff();
		
	}

}
