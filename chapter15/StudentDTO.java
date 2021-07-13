package chapter15;
/*
 * DTO(Date Transfer Object)
 * ****VO(value Object)****가장많이 사용
 * Model ==> Date
 * Item ==> StudentItem
 * Bean :자바에서 객체를 가리킬때 사용, StudentBean
 */
public class StudentDTO {

	private String id;
	private String name;
	private String email;
	private String mobileNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public StudentDTO(String id, String name, String email, String mobileNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
}
