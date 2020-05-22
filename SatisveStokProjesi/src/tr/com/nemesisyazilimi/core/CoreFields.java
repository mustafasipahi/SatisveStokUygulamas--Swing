package tr.com.nemesisyazilimi.core;

public class CoreFields {

	private String userName = "root";
	private String passwordString = "";
	private String url = "jdbc:mysql://localhost:3306/satisvestok";
	
	public String getUserName() {
		return userName;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public String getUrl() {
		return url;
	}
	
}
