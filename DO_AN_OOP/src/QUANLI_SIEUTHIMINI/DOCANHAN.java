package QUANLI_SIEUTHIMINI;

public class DOCANHAN extends HANGHOA {
	public DOCANHAN() {
		
	}
	
	public DOCANHAN(String maHH, String tenHH, String loaiHH, String purpose, int gia, int SL) {
		super(maHH,  tenHH,  loaiHH, purpose, gia, SL);
	}

	@Override
	void mucDichTieuThu() {
		System.out.printf("|%-20s|\n","Nhu cau thiet yeu");
	}
}
