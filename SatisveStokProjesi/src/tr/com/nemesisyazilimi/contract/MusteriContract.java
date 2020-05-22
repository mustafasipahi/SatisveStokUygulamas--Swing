package tr.com.nemesisyazilimi.contract;

public class MusteriContract {

	private int id;
	private String adiSoyadi;
	private String telefon;
	private String adres;
	private String sehir;
	
	public int getId() {
		return id ;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdiSoyadi() {
		return adiSoyadi;
	}
	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehirId(String sehir) {
		this.sehir = sehir;
	}
	@Override
	public String toString() {
		return id + " " + adiSoyadi + " " + telefon + " " + adres + " " + sehir; 
	}
	
}
