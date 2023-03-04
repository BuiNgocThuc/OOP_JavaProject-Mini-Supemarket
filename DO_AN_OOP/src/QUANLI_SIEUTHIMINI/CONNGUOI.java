package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class CONNGUOI {
	protected String hoten;
	protected String ngaysinh;
	protected String dienthoai;
	protected DIACHI diachi;

	Scanner sc = new Scanner(System.in);

	public CONNGUOI() {
		hoten = null;
		ngaysinh = null;
		dienthoai = null;
		diachi = new DIACHI();
	}

	/**
	 * @param hoten
	 * @param ngaysinh
	 * @param dienthoai
	 * @param diachi
	 */
	public CONNGUOI(String hoten, String ngaysinh, String dienthoai, DIACHI diachi) {
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.dienthoai = dienthoai;
		this.diachi = diachi;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public DIACHI getDiachi() {
		return diachi;
	}

	public void setDiachi(DIACHI diachi) {
		this.diachi = diachi;
	}

	public void nhapThongTin() {
		System.out.println("Nhap ho ten: ");
		hoten = sc.nextLine();
		while (!hoten.matches("[a-zA-Z\s]+")) {
			System.out.println("Ten khong hop le, nhap lai:");
			hoten = sc.nextLine();
		}

		System.out.println("Nhap ngay/thang/nam sinh:");
		ngaysinh = sc.nextLine();
		while (!ngaysinh.matches(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
			System.out.println("Ngay/thang/nam sinh khong hop le, vui long nhap lai:  ");
			ngaysinh = sc.nextLine();
		}

		System.out.println("Nhap dien thoai: ");
		dienthoai = sc.nextLine();
		while (!dienthoai.matches("^\\d{10}$")) {
			System.out.println("So dien thoai khong hop le, nhap lai: ");
			dienthoai = sc.nextLine();
		}

		diachi.nhapDiaChi();
	}

	public void xuat() {
		String out1 = String.format("|%-15s|%-15s|%-15s|", hoten, ngaysinh, dienthoai);
		System.out.print(out1);
		diachi.xuat();
	}

	@Override
	public String toString() {
		return hoten + ";" + ngaysinh + ";" + dienthoai + ";" + diachi.toString();
	}

	public static void main(String[] args) {
		CONNGUOI A = new CONNGUOI();
		A.nhapThongTin();
		A.xuat();
	}
}
