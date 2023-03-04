package QUANLI_SIEUTHIMINI;

public class KHThuong extends KHACHHANG {
	private int soLanMua;

	public KHThuong() {
		soLanMua = 0;
	}

	public KHThuong(String maKH, String hoTen, String ngaysinh, String sdt, String sonha, String tduong, int sophuong,
			String tquan, String loaiKH,double ptGiamGia, int soLanMua) {
		super(maKH, hoTen, ngaysinh, sdt, sonha, tduong, sophuong, tquan, loaiKH, ptGiamGia);
		this.soLanMua = soLanMua;
	}

	public int getSoLanMua() {
		return soLanMua;
	}

	public void setSoLanMua(int soLanMua) {
		this.soLanMua = soLanMua;
	}
	
	public void nhap() {
		boolean isValid = false;
		do {
			try {
				System.out.println("Nhap so lan mua cua khach hang: ");
				soLanMua = Integer.parseInt(sc.nextLine());
				isValid = true;
				if (soLanMua < 0) {
					System.out.println("so lan mua khong hop le, nhap lai: ");
					isValid = false;
				}
			} catch (Exception e) {
				System.out.println("so lan mua khong hop le, nhap lai: ");
				isValid = false;
			}
		}while(!isValid);
	}
	@Override
	public double giamGia() {
		if(soLanMua > 50) {
			return 5 * 1.0 /100;
		}
		else {
			return 0;
		}
	}

}
