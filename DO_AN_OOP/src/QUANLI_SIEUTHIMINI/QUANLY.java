package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class QUANLY extends NHANVIEN {
	private double hsTrachNhiem;
	Scanner sc = new Scanner(System.in);

	public QUANLY() {

	}

	public double getHsTrachNhiem() {
		return hsTrachNhiem;
	}

	public QUANLY(String manv, String chucvu, int luongCB, double hsLuong, double tongLuong, String hoten,
			String ngaysinh, String dienthoai, DIACHI diachi, double hsTrachNhiem) {
		super(manv, chucvu, luongCB, hsLuong, tongLuong, hoten, ngaysinh, dienthoai, diachi);
		this.hsTrachNhiem = hsTrachNhiem;
	}

	public void setHsTrachNhiem(double hsTrachNhiem) {
		this.hsTrachNhiem = hsTrachNhiem;
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
				if (hsLuong <= 0) {
					System.out.println("he so luong khong hop le");
					error = true;
				}
			} catch (Exception e) {
				error = true;
			}
		} while (error);
		do {
			try {
				System.out.println("Nhap he so trach nhiem cua quan ly");
				hsTrachNhiem = Double.parseDouble(sc.nextLine());
				error = false;
			} catch (Exception e) {
				error = true;
			}
		} while (error);
	}

	@Override
	public double tinhLuong() {
		return this.luongCB * this.hsLuong * (this.hsTrachNhiem + 1);
	}
}
