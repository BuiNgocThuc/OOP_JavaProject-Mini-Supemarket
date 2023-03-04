package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

//import QUANLI_SIEUTHIMINI.IDUtil.TypeObject;

public class CTPhieuNhap {
	private String maPN;
	private String maHH;
	private int donGia;
	private int soLuong;
	private int thanhTien;

	Scanner sc = new Scanner(System.in);

	public CTPhieuNhap() {
		maPN = null;
		maHH = null;
		donGia = 0;
		soLuong = 0;
		thanhTien = 0;

	}

	public CTPhieuNhap(String maPN, String maHH, int donGia, int soLuong, int thanhTien) {
//		System.out.println(maNV);
		this.maPN = maPN;
		this.maHH = maHH;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public String getMaHH() {
		return maHH;
	}

	public void setMaHH(String maHH) {
		this.maHH = maHH;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public void menuMaHH() {
		System.out.println("-----------MENU------------");
		System.out.println("|1.Dao Cao Rau (DCR); gia(8000)      |");
		System.out.println("|2.Khan Giay   (KG); gia(8000)       |");
		System.out.println("|3.Nuoc Co Gas (CG); gia(9000)       |");
		System.out.println("|4.Nuoc Co Con (CC); gia(9000)       |");
		System.out.println("|5.Do Che Bien (CB); gia(10000)       |");
		System.out.println("|6.Do Dong Hop (DH); gia(10000)       |");
		System.out.println("---------------------------");
	}

	public void taoCTPN(String maPN) {
		this.maPN = maPN;
		boolean isValid = false;
		menuMaHH();
		String loaiHH = "";
		String purpose = "";
		int option = 0;
		System.out.println("CHON LOAI HANG HOA");
		while (!isValid) {
			try {
				System.out.println("nhap lua chon");
				option = Integer.parseInt(sc.next());
				isValid = true;
				if (option < 1 || option > 6) {
					System.out.println("Lua chon khong hop le!!");
					isValid = false;
				}
			} catch (Exception e) {
				System.out.println("Lua chon khong hop le!!");
				isValid = false;
			}
		}
		switch (option) {
		case 1: {
			maHH = "DCR";
			loaiHH = "Do ca nhan";
			purpose = "Nhu cau thiet yeu";
			donGia = 8000;
			break;
		}
		case 2: {
			maHH = "KG";
			loaiHH = "Do ca nhan";
			purpose = "Nhu cau thiet yeu";
			donGia = 8000;
			break;
		}
		case 3: {
			maHH = "CG";
			loaiHH = "Nuoc co ga";
			purpose = "Uong";
			donGia = 9000;
			break;
		}
		case 4: {
			maHH = "CC";
			loaiHH = "Nuoc co con";
			purpose = "Uong";
			donGia = 9000;
			break;
		}
		case 5: {
			maHH = "CB";
			loaiHH = "Do Che bien";
			purpose = "An";
			donGia = 10000;
			break;
		}
		case 6: {
			maHH = "DH";
			loaiHH = "Do dong hop";
			purpose = "An";
			donGia = 10000;
			break;
		}
		}
//		isValid = false;
//		while (!isValid) {
//			try {
//				System.out.println("nhap don gia hang hoa");
//				donGia = Integer.parseInt(sc.next());
//				isValid = true;
//				if (donGia < 1) {
//					System.out.println("don gia khong hop le!!");
//					isValid = false;
//				}
//			} catch (Exception e) {
//				System.out.println("donGia khong hop le!!");
//			}
//		}
		isValid = false;
		while (!isValid) {
			try {
				System.out.println("nhap so luong hang hoa");
				soLuong = Integer.parseInt(sc.next());
				isValid = true;
				if (soLuong < 1) {
					System.out.println("So luong khong hop le!!");
					isValid = false;
				}
			} catch (Exception e) {
				System.out.println("So luong khong hop le!!");
			}
		}
		System.out.println("SL luc dau" + DSHangHoa.h.size());
		int size = DSHangHoa.h.size();
		HANGHOA hh = null;
		int pos = DSHangHoa.getHangHoaPosition(maHH);
		System.out.println(pos);
	    if (pos != -1) {
	    	int soluongton = DSHangHoa.h.get(pos).getSL();
	    	int tongSLSanPham = soluongton + soLuong;
	    	DSHangHoa.h.get(pos).setSL(tongSLSanPham);
	    } else {
	    	if (maHH.contains("DH") || maHH.contains("CB")) {
				hh = new THUCPHAM(maHH, "Thuc pham " + size, loaiHH, purpose, donGia, soLuong);
			} else if (maHH.contains("CG") || maHH.contains("CC")) {
				hh = new NUOCUONG(maHH, "Nuoc uong " + size, loaiHH, purpose, donGia, soLuong);
			} else if (maHH.contains("KG") || maHH.contains("DC")) {
				hh = new DOCANHAN(maHH, "Do ca nhan " + size, loaiHH, purpose, donGia, soLuong);
			}
			DSHangHoa.h.add(hh);	
	    }
	    System.out.println("SL luc sau: " + DSHangHoa.h.size());
	
		thanhTien = donGia * soLuong;
	}

	public void xuat() {
		System.out.println(
				"|--------------------|--------------------|--------------------|--------------------|--------------------|");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", maPN, maHH, donGia, soLuong, thanhTien);
		System.out.print(out1);
	}

	@Override
	public String toString() {
		return maPN + ";" + maHH + ";" + donGia + ";" + soLuong
				+ ";" + thanhTien;
	}

	public static void main(String[] args) {
		CTPhieuNhap A = new CTPhieuNhap();
		A.xuat();
	}
}
