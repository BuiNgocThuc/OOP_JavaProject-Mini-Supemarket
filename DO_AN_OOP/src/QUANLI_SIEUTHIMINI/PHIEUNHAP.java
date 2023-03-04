package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

import QUANLI_SIEUTHIMINI.IDUtil.TypeObject;

public class PHIEUNHAP {
	private String maPN, maNV, maNCC, ngayNhap;
	private int tongTien;

	Scanner sc = new Scanner(System.in);

	public PHIEUNHAP() {
		maPN = null;
		maNV = null;
		maNCC = null;
		ngayNhap = null;
		tongTien = 0;
	}

	public PHIEUNHAP(String maPN, String maNV, String maNCC, String ngayNhap, int tongTien) {
		this.maPN = maPN;
		this.maNV = maNV;
		this.maNCC = maNCC;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
	}

	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String taoPN() {
		boolean IsValid = false;
		String result = "-1";
		maPN = IDUtil.randomeID(TypeObject.PHIEUNHAP);
		System.out.println("Nhap ma nhan vien nhap: ");
		maNV = sc.nextLine();
		while(!IsValid) {
			try {
				IsValid = true;
				if(!DSNhanVien.checkMaNVexist(maNV)) {
					System.out.println("Khong co nhan vien nay ton tai, nhap lai!!");
					maNV = sc.nextLine();
					IsValid = false;
				}
			} catch (Exception e) {
				System.out.println("khong hop le!!");
				IsValid = false;
				result = "-1";
			}
		}
		IsValid = false;
		System.out.println("Nhap ma nha cung cap nhap: ");
		maNCC = sc.nextLine();
		while(!IsValid) {
			try {
				IsValid = true;
				if(!DSNhaCungCap.checkMaNCCexist(maNCC)) {
					System.out.println("Khong co nha cung cap nay ton tai, nhap lai!!");
					IsValid = false;
					maNCC = sc.nextLine();
				}
			} catch (Exception e) {
				System.out.println("khong hop le!!");
				result = "-1";
			}
		}
		System.out.println("Nhap ngay nhap: ");
		ngayNhap = sc.nextLine();
		while(!ngayNhap.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
			System.out.println("Ngay/thang/nam khong hop le, vui long nhap lai:  ");
			ngayNhap = sc.nextLine();
		}
		result = maPN;
		return result;
	}

	public void xuat() {
		System.out.println(
				"|--------------------|--------------------|--------------------|--------------------|--------------------|");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", maPN, maNV, maNCC, ngayNhap, tongTien);
		System.out.print(out1);
	}
	
	@Override
	public String toString() {
		return maPN + ";" + maNV + ";" + maNCC + ";" + ngayNhap
				+ ";" + tongTien + ";";
	}

	public static void main(String[] args) {
		
	}
}
