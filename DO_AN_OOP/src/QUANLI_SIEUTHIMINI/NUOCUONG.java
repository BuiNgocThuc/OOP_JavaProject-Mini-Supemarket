package QUANLI_SIEUTHIMINI;

public class NUOCUONG extends HANGHOA {
	
	public NUOCUONG() {
		
	}
	public NUOCUONG(String maHH, String tenHH, String loaiHH, String purpose, int gia, int SL) {
		super(maHH,  tenHH,  loaiHH, purpose, gia, SL);
	}


	@Override
	void mucDichTieuThu() {
		// TODO Auto-generated method stub
		System.out.printf("|%-20s|\n","Uong");
	}
}
