package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class CTHoaDon {
	private String maHD;
	private String maHH;
	private int dongia;
	private int soluong;
	private int thanhTien;

	Scanner sc = new Scanner(System.in);

	public CTHoaDon() {
		maHD = null;
		maHH = null;
		dongia = 0;
		soluong = 0;
		thanhTien = 0;
	}

	public CTHoaDon(String maHD, String maHH, int dongia, int soluong,
			int thanhTien) {
		this.maHD = maHD;
		this.maHH = maHH;
		this.dongia = dongia;
		this.soluong = soluong;
		this.thanhTien = thanhTien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaHH() {
		return maHH;
	}

	public void setMaHH(String maHH) {
		this.maHH = maHH;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getthanhTien() {
		return thanhTien;
	}

	public void setthanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}


	public void menuMaHH() {
		System.out.println("-----------MENU------------");
		System.out.println("|1.Dao Cao Rau (DCR); gia(8000)     |");
		System.out.println("|2.Khan Giay   (KG); gia(8000)      |");
		System.out.println("|3.Nuoc Co Gas (CG); gia(9000)       |");
		System.out.println("|4.Nuoc Co Con (CC); gia(9000)       |");
		System.out.println("|5.Do Che Bien (CB); gia(10000)       |");
		System.out.println("|6.Do Dong Hop (DH); gia(10000)       |");
		System.out.println("---------------------------");
	}

	public void taoCTHD(String maHD) {
		this.maHD = maHD;
		boolean isValid = false;
		menuMaHH();
		int option = 0;
		int soluongton = 0;
		int pos = -1;
		System.out.println("CHON LOAI HANG HOA");
		System.out.println("nhap lua chon");
		
		
		while (!isValid) {
			try {
				option = Integer.parseInt(sc.next());
				switch (option) {
				case 1: {
					maHH = "DCR";
					dongia = 8000;
					break;
				}
				case 2: {
					maHH = "KG";
					dongia = 8000;
					break;
				}
				case 3: {
					maHH = "CG";
					dongia = 9000;
					break;
				}
				case 4: {
					maHH = "CC";
					dongia = 9000;
					break;
				}
				case 5: {
					maHH = "CB";
					dongia = 10000;
					break;
				}
				case 6: {
					maHH = "DH";
					dongia = 10000;
					break;
				}
				}
				pos = DSHangHoa.getHangHoaPosition(maHH);
				if (pos != -1) {
					soluongton = DSHangHoa.h.get(pos).getSL();
					if (soluongton <= 0) {
						System.out.println("So luong san pham khong du vui long chon san pham khác");
						isValid = false;
					} else {
						isValid = true;
					}
				}
				isValid = true;
			} catch (Exception e) {
				System.out.println("Lua chon khong hop le!!");
				isValid = false;
			}
		}
		isValid = false;
		System.out.println("Nhap so luong hang hoa");
		while (!isValid) {
			try {
				soluong = Integer.parseInt(sc.next());
				if (soluong < 1 || soluongton - soluong < 0) {
					System.out.println("San pham trong kho khong du vui long nhap so khac");
					isValid = false;
				}
				else {
					isValid = true;
				}
			} catch (Exception e) {
				System.out.println("So luong khong hop le!!");
				isValid = false;
			}
		}
        if (pos != -1) {
        	int soluongtonMoi = soluongton - soluong;
    		DSHangHoa.h.get(pos).setSL(soluongtonMoi);
    		thanhTien = DSHangHoa.h.get(pos).getGia() * soluong;
        }
	}

	public void xuat() {
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|",maHD, maHH, dongia, soluong, thanhTien);
		System.out.print(out1);
	}

	@Override
	public String toString() {
		return maHD + ";" + maHH + ";" + dongia + ";" + soluong + ";" + thanhTien;
	}
}
