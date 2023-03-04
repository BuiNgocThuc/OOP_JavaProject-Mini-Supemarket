package QUANLI_SIEUTHIMINI;

public class KHThanThiet extends KHACHHANG {

	public KHThanThiet() {
	}

	public KHThanThiet(String maKH, String hoTen, String ngaysinh, String sdt, String sonha, String tduong,
			int sophuong, String tquan, String loaiKH, double ptGiamGia) {
		super(maKH, hoTen, ngaysinh, sdt, sonha, tduong, sophuong, tquan, loaiKH, ptGiamGia);
	}
	
	@Override
	public double giamGia() {
		return 10 * 1.0 / 100;
	}

}
