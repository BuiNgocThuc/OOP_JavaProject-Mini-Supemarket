package QUANLI_SIEUTHIMINI;

import java.text.DecimalFormat;

import QUANLI_SIEUTHIMINI.IDUtil.TypePeople;

public class NHANVIEN extends CONNGUOI {
	protected String manv, chucvu;
	protected int luongCB;
	protected double hsLuong, tongLuong;

	public NHANVIEN() {
		manv = null;
		chucvu = null;
		luongCB = 0;
		hsLuong = 0;
		tongLuong = 0;
	}

	public NHANVIEN(String manv, String chucvu, int luongCB, double hsLuong, double tongLuong, String hoten,
			String ngaysinh, String dienthoai, DIACHI diachi) {
		super(hoten, ngaysinh, dienthoai, diachi);
		this.manv = manv;
		this.chucvu = chucvu;
		this.luongCB = luongCB;
		this.hsLuong = hsLuong;
		this.tongLuong = tongLuong;
	}

	public NHANVIEN(String maNV, String hoTen, String ngaySinh, String sdt, String sonha, String tduong, int sophuong,
			String tquan, String chucvu, double tienLuong) {
		super(hoTen, ngaySinh, sdt, new DIACHI(sonha, tduong, sophuong, tquan));
		this.manv = maNV;
		this.chucvu = chucvu;
		this.tongLuong = tienLuong;
	}

	public double getTongLuong() {
		return tongLuong;
	}

	public void setTongLuong(int tongLuong) {
		this.tongLuong = tongLuong;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}

	public int getLuongCB() {
		return luongCB;
	}

	public void setLuongCB(int luongCB) {
		this.luongCB = luongCB;
	}

	public double getHsLuong() {
		return hsLuong;
	}

	public void setHsLuong(int hsLuong) {
		this.hsLuong = hsLuong;
	}

	private void menu() {
		System.out.println("Chuc vu:");
		System.out.println("1.QUAN LY");
		System.out.println("2.NV BAN HANG");
	}

	public void nhap() {
		super.nhapThongTin();
		boolean isValid = false;
		do {
			menu();
			try {
				System.out.println("Nhap chuc vu: (1 or 2)");
				int c = Integer.parseInt(sc.nextLine());
				if (c < 1 || c > 2) {
					System.out.println("lua chon khong hop le");
					isValid = false;
				} else {
					isValid = true;
					if (c == 1) {
						this.manv = IDUtil.randomeID(TypePeople.QUANLY);
						chucvu = "QUAN LY";
						NHANVIEN ql = new QUANLY();
						ql.nhap();
						tongLuong = ql.tinhLuong();
					} else if (c == 2) {
						this.manv = IDUtil.randomeID(TypePeople.NV_BANHANG);
						chucvu = "NV BAN HANG";
						NHANVIEN bh = new NVBANHANG();
						bh.nhap();
						tongLuong = bh.tinhLuong();
					}
				}
			} catch (Exception e) {
				System.out.println("lua chon khong hop le");
				isValid = false;
			}
		} while (!isValid);

	}

	public double tinhLuong() {
		return this.tongLuong = this.luongCB * this.hsLuong;
	}

	public void xuat() {
		System.out.println(
				"|---------------|---------------|---------------|---------------|----------------------------------------|---------------|--------------------|");
		System.out.print(String.format("|%-15s", manv));
		super.xuat();
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		String out1 = String.format("%-15s|%-20s|", chucvu, formatter.format(tongLuong) + " VND");
		System.out.println(out1);
	}

	@Override
	public String toString() {
		return manv + ";" + super.toString() + ";" + chucvu + ";" + tongLuong;
	}

	public static void main(String[] args) {
		NHANVIEN A = new NHANVIEN();
		A.nhap();
		A.xuat();
	}
}
