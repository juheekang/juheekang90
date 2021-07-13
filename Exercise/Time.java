package Exercise;

public class Time {

	private int hour;
	private int minute;
	private int second;

	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}

	public Time(int hour, int minute, int second) {
		if (hour >= 0 && hour <= 23 ) {
			this.hour = hour;
		}
		if (minute >= 0 && minute <= 59 ) {
			this.minute = minute;
		}
		if (second >= 0 && second <= 59 ) {
			this.second = second;
		}
	}

	public String toString() {
		return String.format ("%02d:%02d:%02d",hour,minute,second);
	}
	

}