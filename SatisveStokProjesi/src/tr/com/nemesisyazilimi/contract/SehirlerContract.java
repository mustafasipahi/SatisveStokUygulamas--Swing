package tr.com.nemesisyazilimi.contract;

public class SehirlerContract {

	private int id;
	private String isim;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	@Override
	public String toString() {
		return isim;
	}
	
	
}
