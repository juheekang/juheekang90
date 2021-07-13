package chapter08;

public interface RemoteControl {

	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
}
