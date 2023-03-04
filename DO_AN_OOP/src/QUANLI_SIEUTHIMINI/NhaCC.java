package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

import QUANLI_SIEUTHIMINI.IDUtil.TypePeople;

public class NhaCC {
	private String maNCC, tenNCC, sdtNCC, email;
	private DIACHI diachiNCC;
	Scanner sc = new Scanner(System.in);
	
	public NhaCC() {
		maNCC = null;
		sdtNCC = null;
		tenNCC = null;
		email = null;
		diachiNCC = new DIACHI();
	}
	
	public NhaCC(String maNCC, String tenNCC, String sdtNCC, String email, String soNha,String tenDuong , int soPhuong, String quan) {
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.sdtNCC = sdtNCC;
		this.email = email;
		this.diachiNCC = new DIACHI(soNha, tenDuong, soPhuong, quan);
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getSdtNCC() {
		return sdtNCC;
	}

	public void setSdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public DIACHI getDiachiNCC() {
		return diachiNCC;
	}

	public void setDiachiNCC(DIACHI diachiNCC) {
		this.diachiNCC = diachiNCC;
	}
	
	public void nhap() {
		DSNhaCungCap.countNCC++;
		maNCC = IDUtil.randomeID(TypePeople.NHACUNGCAP);
		System.out.println("Nhap ten nha cung cap: ");
		tenNCC = sc.nextLine();
		while(!tenNCC.matches("[a-zA-Z\s]+")){
			System.out.println("Ten khong hop le, nhap lai: ");
			tenNCC=sc.nextLine();
		}
		System.out.println("Nhap sdt nha cung cap: ");
		sdtNCC = sc.nextLine();
		while(!sdtNCC.matches("^\\d{10}$")) {
			System.out.println("So dien thoai khong hop le, nhap lai: ");
			sdtNCC = sc.nextLine();
		}
		System.out.println("Nhap email nha cung cap: ");
		email = sc.nextLine();
		while(!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
			System.out.println("Email khong hop le, nhap lai: ");
			email = sc.nextLine();
		}
		
		diachiNCC.nhapDiaChi();
	}
	
	public void xuat() {
		System.out.println(
				"|--------------------|--------------------|--------------------|--------------------|----------------------------------------|");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|", maNCC, tenNCC, sdtNCC, email);
		System.out.print(out1);
		diachiNCC.xuat();
	}
	
	
	@Override
	public String toString() {
		return maNCC + ";" + tenNCC + ";" + sdtNCC + ";" + email
				+ ";" + diachiNCC.toString();
	}

	public static void main(String[] args) {
		NhaCC A = new NhaCC();
		A.nhap();
		A.xuat();
	}
}
