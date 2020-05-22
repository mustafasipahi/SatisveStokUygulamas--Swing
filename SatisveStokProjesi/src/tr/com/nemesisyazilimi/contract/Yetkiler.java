package tr.com.nemesisyazilimi.contract;

public class Yetkiler {

	private int id;
	private String adi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	@Override
	public String toString() {
		return adi;
	}
	
	
}
