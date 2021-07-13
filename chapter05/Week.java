package chapter05;

public enum Week {
//	상수 자체도 하나의 객체
	MONDAY("월"),
	TUESDAY("화"),
	WEDNESDAY("수"),
	THURSDAY("목"),
	FRIDAY("금"),
	SATURDAY("토"),
	SUNDAY("일");

	String korOfWeek;
	
	Week(String korOfWeek) {
		this.korOfWeek = korOfWeek;
	}
	public String getKorOfWeek() {
		return korOfWeek;
	}
}
