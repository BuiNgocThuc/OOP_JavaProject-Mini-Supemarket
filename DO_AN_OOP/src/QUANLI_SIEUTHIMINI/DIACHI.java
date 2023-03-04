package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class DIACHI {
	private String tenDuong;
	private String soNha;
	private int soPhuong;
	private String quan;

	Scanner sc = new Scanner(System.in);

	public DIACHI() {
		tenDuong = null;
		soNha = null;
		soPhuong = 0;
		quan = null;
	}

	/**
	 * @param tenDuong
	 * @param soNha
	 * @param soPhuong
	 * @param quan
	 */
	public DIACHI(String soNha, String tenDuong, int soPhuong, String quan) {
		this.tenDuong = tenDuong;
		this.soNha = soNha;
		this.soPhuong = soPhuong;
		this.quan = quan;
	}

	public String getTenDuong() {
		return tenDuong;
	}

	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public int getSoPhuong() {
		return soPhuong;
	}

	public void setSoPhuong(int soPhuong) {
		this.soPhuong = soPhuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public void nhapDiaChi() {
		System.out.println("Nhap so nha: ");
		soNha = sc.nextLine();
		while (soNha.isEmpty()) {
			System.out.println("so nha khong hop le: ");
			soNha = sc.nextLine();
		}

		System.out.println("Nhap ten duong: ");
		tenDuong = sc.nextLine();
		while (tenDuong.isEmpty()) {
			System.out.println("ten duong khong hop le: ");
			tenDuong = sc.nextLine();
		}

		boolean isValid = false;
		while (!isValid) {
			try {
				System.out.println("Nhap so phuong: ");
				soPhuong = Integer.parseInt(sc.nextLine());
				if (soPhuong > 0)
					isValid = true;
				else {
					System.out.println("So phuong khong hop le!!");
					isValid = false;
				}
			} catch (Exception e) {
				System.out.println("So phuong khong hop le!!");
				isValid = false;
			}
		}
		
		System.out.println("Nhap ten quan: ");
		quan = sc.nextLine();
		while (quan.isEmpty()) {
			System.out.println("ten quan khong hop le: ");
			quan = sc.nextLine();
		}
	}

	public void xuat() {
		String out1 = String.format("%-10s%-15s%-5s%-10s|", soNha, tenDuong, soPhuong, quan);
		System.out.print(out1);
	}
	
	

	@Override
	public String toString() {
		return tenDuong + ";" + soNha + ";" + soPhuong + ";" + quan;
	}

	public static void main(String[] args) {
		DIACHI A = new DIACHI();
		A.nhapDiaChi();
		A.xuat();
	}

}
