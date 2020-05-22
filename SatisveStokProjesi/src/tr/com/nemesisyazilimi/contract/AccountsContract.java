package tr.com.nemesisyazilimi.contract;

public class AccountsContract {

	private int id;
	private int yetkiId;
	private int personelId;
	private String sifre;
	
	public int getId() {		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYettkiId() {
		return yetkiId;
	}
	public void setYettkiId(int yettkiId) {
		this.yetkiId = yettkiId;
	}
	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	@Override
	public String toString() {
		return id + " " + yetkiId + " " + personelId + " " + sifre;
	}
	
	
}
