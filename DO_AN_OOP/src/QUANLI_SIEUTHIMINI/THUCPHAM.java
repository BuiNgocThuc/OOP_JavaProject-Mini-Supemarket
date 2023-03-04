package QUANLI_SIEUTHIMINI;

public class THUCPHAM extends HANGHOA {
	public THUCPHAM() {
		
	}
	public THUCPHAM(String maHH, String tenHH, String loaiHH, String purpose,int gia, int SL) {
		super( maHH,  tenHH,  loaiHH, purpose, gia, SL);
	}

	@Override
	void mucDichTieuThu() {
		// TODO Auto-generated method stub
		System.out.printf("|%-20s|\n","An");
	}
}
