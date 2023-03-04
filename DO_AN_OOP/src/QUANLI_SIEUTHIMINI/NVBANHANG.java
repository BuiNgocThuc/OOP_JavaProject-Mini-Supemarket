package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class NVBANHANG extends NHANVIEN{
	private double gioLT;
	private int luong1h = 20000;
	Scanner sc = new Scanner(System.in);
	
	public NVBANHANG() {
		
	}

	public NVBANHANG(String manv, String chucvu, int luongCB, double hsLuong, double tongLuong, String hoten,
			String ngaysinh, String dienthoai, DIACHI diachi, double gioLT) {
		super(manv, chucvu, luongCB, hsLuong, tongLuong, hoten, ngaysinh, dienthoai, diachi);
		this.gioLT = gioLT;
	}

	public double getGioLT() {
		return gioLT;
	}

	public void setGioLT(double gioLT) {
		this.gioLT = gioLT;
	}
	
	public int getLuong1h() {
		return luong1h;
	}

	public void setLuong1h(int luong1h) {
		this.luong1h = luong1h;
	}
	
	public void nhap() {
		boolean error = true;
		do {
			try {
				System.out.println("nhap luong co ban: ");
				luongCB = Integer.parseInt(sc.nextLine());
				error = false;
				if (luongCB < 1) {
					System.out.println("luong khong hop le");
					error = true;
				}
			} catch (Exception e) {
				System.out.println("luong khong hop le");
				error = true;
			}
		} while (error);
		do {
			try {
				System.out.println("nhap he so luong: ");
				hsLuong = Double.parseDouble(sc.nextLine());
				error = false;
				if(hsLuong <= 0) {
					System.out.println("he so luong khong hop le");
					error = true;
				}
			} catch (Exception e) {
				error = true;
			}
		} while (error);
		System.out.println("Nhap so gio lam them 1 ngay");
		gioLT = sc.nextDouble();
		sc.nextLine();
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return (this.luongCB * this.hsLuong + this.luong1h * this.gioLT * 30);
	}

	
}
