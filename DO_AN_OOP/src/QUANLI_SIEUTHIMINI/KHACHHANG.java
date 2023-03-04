package QUANLI_SIEUTHIMINI;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import QUANLI_SIEUTHIMINI.IDUtil.TypePeople;

public class KHACHHANG extends CONNGUOI {
	protected String maKH;
	protected double phanTramGiamGia;
	private String loaiKH;

	Scanner sc = new Scanner(System.in);

	public KHACHHANG() {
		maKH = null;
		loaiKH = null;
		phanTramGiamGia = 0;
	}

	public KHACHHANG(String maKH, String hoTen, String ngaysinh, String sdt, String sonha, String tduong, int sophuong,
			String tquan, String loaiKH, double phanTramGiamGia) {
		super(hoTen, ngaysinh, sdt, new DIACHI(sonha, tduong, sophuong, tquan));
		this.maKH = maKH;
		this.loaiKH = loaiKH;
		this.phanTramGiamGia = phanTramGiamGia;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(String loaiKH) {
		this.loaiKH = loaiKH;
	}
	

	public double getPhanTramGiamGia() {
		return phanTramGiamGia;
	}

	public void setPhanTramGiamGia(double phanTramGiamGia) {
		this.phanTramGiamGia = phanTramGiamGia;
	}

	private void menu() {
		System.out.println("Loai Khach Hang:");
		System.out.println("1.KHACH HANG THAN THIET");
		System.out.println("2.KHACH HANG THUONG");
	}

	public void nhap() {
		super.nhapThongTin();
		boolean isValid = false;
		do {
			menu();
			try {
				System.out.println("Nhap loai khach hang: (1 or 2)");
				double c = Integer.parseInt(sc.nextLine());
				if (c < 1 || c > 2) {
					System.out.println("lua chon khong hop le");
					isValid = false;
				} else {
					isValid = true;
					if (c == 1) {
						DSKhachHang.countVIP++;
						this.maKH = IDUtil.randomeID(TypePeople.KH_THANTHIET);
						loaiKH = "KH THAN THIET";
						KHACHHANG VIP = new KHThanThiet();	
						phanTramGiamGia = VIP.giamGia();
					} else if (c == 2) {
						DSKhachHang.countNOR++;
						this.maKH = IDUtil.randomeID(TypePeople.KH_THUONG);
						loaiKH = "KH BINH THUONG";
						KHACHHANG NOR = new KHThuong();
						NOR.nhap();
						phanTramGiamGia = NOR.giamGia();
					}
				}
			} catch (Exception e) {
				System.out.println("lua chon khong hop le");
				isValid = false;
			}
		}while(!isValid);
	}

	public void xuat() {
		System.out.println(
				"|---------------|---------------|---------------|---------------|----------------------------------------|--------------------|---------------|");
		System.out.print(String.format("|%-15s", maKH));
		super.xuat();
		Locale lc = new Locale("nv","VN");
		NumberFormat pf = NumberFormat.getPercentInstance(lc);
		System.out.println(String.format("%-20s|%-15s|", loaiKH, pf.format(phanTramGiamGia)));
	}

	@Override
	public String toString() {
		return maKH + ";" + ";" + super.toString() + ";" + loaiKH + ";" + phanTramGiamGia;
	}

	public double giamGia() {
		return 5 * 1.0 /100;
	}

	public static void main(String[] args) {
		KHACHHANG A = new KHACHHANG();
		A.nhap();
		A.xuat();
	}
}
