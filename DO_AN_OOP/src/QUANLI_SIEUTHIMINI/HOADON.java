package QUANLI_SIEUTHIMINI;

import java.text.DecimalFormat;
import java.util.Scanner;

import QUANLI_SIEUTHIMINI.IDUtil.TypeObject;

public class HOADON {
	private String maHD, maNV, maKH, ngaynhap;
	private int tongTien;

	Scanner sc = new Scanner(System.in);

	public HOADON() {
		maHD = null;
		maNV = null;
		maKH = null;
		ngaynhap = null;
		tongTien = 0;
	}

	public HOADON(String maHD, String maKH, String maNV, String ngaynhap, int tongTien) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngaynhap = ngaynhap;
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getmaNV() {
		return maNV;
	}

	public void setmaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public int gettongTien() {
		return tongTien;
	}

	public void settongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String taoHD() {
		boolean IsValid = false;
		String result = "-1";
		maHD = IDUtil.randomeID(TypeObject.HOADON);
		System.out.println("Nhap nhan vien nhap: ");
		maNV = sc.nextLine();
		while (!IsValid) {
			try {
				IsValid = true;
				if (!DSNhanVien.checkMaNVexist(maNV)) {
					System.out.println("Khong co nhan vien nay ton tai, nhap lai!!");
					IsValid = false;
					maNV = sc.nextLine();
				}
			} catch (Exception e) {
				System.out.println("khong hop le!!");
				IsValid = false;
			}
		}
		IsValid = false;
		System.out.println("Nhap ma khach mua hang: ");
		maKH = sc.nextLine();
		while (!IsValid) {
			try {
				IsValid = true;
				if (!DSKhachHang.checkMaKHexist(maKH)) {
					System.out.println("Khong co khach hang nay ton tai, nhap lai!!");
					maKH = sc.nextLine();
				}
			} catch (Exception e) {
				System.out.println("khong hop le!!");
			}
		}
		System.out.println("Nhap ngay xuat: ");
		ngaynhap = sc.nextLine();
		while (!ngaynhap.matches(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
			System.out.println("Ngay/thang/nam khong hop le, vui long nhap lai:  ");
			ngaynhap = sc.nextLine();
		}
		result = maHD;
		return result;
	}

	DecimalFormat formatter = new DecimalFormat("###,###,###");
	public void xuat() {
		System.out.println(
				"|--------------------|--------------------|--------------------|--------------------|--------------------|");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", maHD, maNV, maKH, ngaynhap, tongTien);
		System.out.print(out1);
	}

	@Override
	public String toString() {
		return maHD + ";" + maNV + ";" + maKH + ";" + ngaynhap + ";"
				+ tongTien;
	}
	
	
}
