package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSNhanVien implements InterfaceC {
	public static int SoLuong = 0;
	private static NHANVIEN[] dsnv = new NHANVIEN[SoLuong];
	
	static int countQL = 0;
	static int countNV = 0;

	Scanner sc = new Scanner(System.in);

	public DSNhanVien() {
	}

	public void nhap() {
		boolean error;
		do {
			try {
				System.out.println("nhap so luong nhan vien: ");
				SoLuong = Integer.parseInt(sc.next());
				error = false;
				if (SoLuong < 1) {
					System.out.println("Nhap lai!");
					error = true;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Nhap lai!");
				error = true;
			}
		} while (error);
		dsnv = new NHANVIEN[SoLuong];
		for (int i = 0; i < SoLuong; i++) {
			System.out.println("Thong tin nhan vien thu " + (i + 1));
			dsnv[i] = new NHANVIEN();
			dsnv[i].nhap();
		}
	}

	public void xuat() {
//		System.out.println(SoLuong);
		System.out.println(
				" _____________________________________________________________________________________________________________________________________________");
		String out1 = String.format("|%-15s|%-15s|%-15s|%-15s|%-40s|%-15s|%-20s|", "Ma Nhan Vien", "Ten Nhan Vien",
				"Ngay Sinh", "So dien thoai", "DiaChi", "Chuc Vu", "Muc Luong");
		System.out.println(out1);
		for (int i = 0; i < SoLuong; ++i) {
			dsnv[i].xuat();
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void themnv(int k) {
		dsnv = Arrays.copyOf(dsnv, SoLuong + k);
		System.out.println("So luong nhan vien " + dsnv.length);
		for (int i = SoLuong; i < SoLuong + k; i++) {
			System.out.println("nhap thong tin nhan vien thu " + (i + 1));
			dsnv[i] = new NHANVIEN();
			dsnv[i].nhap();
			System.out.println("Them nhan vien thu " + (i + 1) + " thanh cong!!");
		}
		SoLuong = SoLuong + k;
	}

	@Override
	public void ThemO() {
		if(SoLuong == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			countQL = 0;
			countNV = 0;
			nhap();
			return;
		}else {
			for(int i = 0; i < SoLuong; ++i) {
				if(dsnv[i].getManv().contains("QL")) {
					countQL++;
				}else {
					countNV++;
				}
			}
		}
		int k = 0;
		while (true) {
			try {
				System.out.println("Nhap vao so luong muon them");
				k = Integer.parseInt(sc.next());
				if (k < 1) {
					System.out.println("Nhap khong hop le!!");
				} else {
					themnv(k);
					break;
				}
			} catch (Exception e) {
				System.out.println("Nhap khong hop le!!");

			}
		}

	}

	public void xoa(int vt) {
		for (int i = vt; i < SoLuong - 1; i++) {
			dsnv[i] = dsnv[i + 1];
		}
		dsnv = Arrays.copyOf(dsnv, SoLuong - 1);
		SoLuong--;

	}

	public void xoatheomanv(String x) {
		int kt = -1;
		for (int i = 0; i < SoLuong; ++i) {
			if (dsnv[i].getManv().equals(x)) {
				kt = i;
				break;
			}
		}
		if (kt == -1) {
			System.out.println("Ma nv nay ko ton tai!!");
		} else {
			xoa(kt);
			System.out.println("Da Xoa thanh cong!!");
		}

	}

	@Override
	public void XoaO() {
		if(SoLuong == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			return;
		}
		int xoa = -1;
		boolean exit = false;
		while (!exit) {
			sc.nextLine();
			System.out.println("_______________________________");
			System.out.println("|   Chon thuoc tinh can xoa   |");
			System.out.println("|-----------------------------|");
			System.out.println("|1.Xoa theo ma nhan vien      |");
			System.out.println("|-----------------------------|");
			System.out.println("|2.Quay lai                   |");
			System.out.println("-------------------------------");
			try {
				xoa = Integer.parseInt(sc.next());
				if (xoa < 1 || xoa > 2) {
					System.out.println("cu phap khong hop le !!");
				}
			} catch (Exception e) {
				System.out.println("cu phap khong hop le !!");
				xoa = -1;
			}
			if (xoa == 1 || xoa == 2) {
				switch (xoa) {
				case 1:
					String xoama;
					System.out.println("Nhap ma nhan vien can xoa");
					xoama = sc.next();
					xoatheomanv(xoama);
					break;

				case 2:
					exit = true;
					break;
				}
			}
		}
	}

	@Override
	public void SuaO() {
		if(SoLuong == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			return;
		}
		String ma = null;
		boolean check = true;

		while (check) {
			try {
				System.out.println("__Nhap ma nhan vien can sua__");
				ma = sc.next();
				for (int i = 0; i < SoLuong; i++) {
					if (dsnv[i].getManv().equals(ma)) {
						check = false;
						break;
					}
				}
				if (check == true) {
					System.out.println("Ma nhan vien khong ton tai, nhap lai!!");
				}
			} catch (Exception e) {
				System.out.println("Ma nhan vien khong ton tai, nhap lai!!");
			}
		}
		check = true;
		for (int i = 0; i < SoLuong; i++) {
			if (dsnv[i].getManv().equals(ma)) {
				while (check) {
					int option = -1;
					System.out.println("_______________________________");
					System.out.println("|   Chon thuoc tinh can sua   |");
					System.out.println("+=============================+");
					System.out.println("|1.Sua ten khach hang         |");
					System.out.println("-------------------------------");
					System.out.println("|2.Sua sdt khach hang         |");
					System.out.println("-------------------------------");
					System.out.println("|3.Sua dia chi khach hang     |");
					System.out.println("-------------------------------");
					System.out.println("|4.Quay lai                   |");
					System.out.println("-------------------------------");
					try {
						option = Integer.parseInt(sc.next());
						if (option < 1 || option > 4) {
							System.out.println("cu phap khong hop le !!");
						}
					} catch (Exception e) {
						System.out.println("cu phap khong hop le !!");
						option = -1;
					}
					sc.nextLine();
					if (option >= 1 && option <= 4) {
						switch (option) {
						case 1:
							String tenkh = null;
							System.out.println("Nhap ten khach hang moi");
							tenkh = sc.nextLine();
							while (!tenkh.matches("[a-zA-Z\s]+")) {
								System.out.println("Ten khong hop le, nhap lai:");
								tenkh = sc.nextLine();
							}
							dsnv[i].setHoten(tenkh);
							System.out.println("DONE!!");
							break;
						case 2:
							String dienthoai;
							System.out.println("Nhap so dien thoai moi");
							dienthoai = sc.nextLine();
							while (!dienthoai.matches("^\\d{10}$") || dienthoai.isEmpty()) {
								System.out.println("So dien thoai khong hop le, nhap lai: ");
								dienthoai = sc.nextLine();
							}
							dsnv[i].setDienthoai(dienthoai);
							System.out.println("DONE!!");
							break;
						case 3:
							System.out.println("Nhap so dia chi moi");
							DIACHI A = new DIACHI();
							A.nhapDiaChi();
							dsnv[i].setDiachi(A);
							System.out.println("DONE!!");
							break;
						case 4:
							check = false;
							break;
						}
					}
				}
				break;
			}
		}

	}

	public void timtheomanv(String x) {
		boolean check = false;
		for (int i = 0; i < SoLuong; i++) {
			if (dsnv[i].getManv().equals(x)) {
				dsnv[i].xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ma nhan vien khong ton tai!!");
	}

	public void timtheoten(String x) {
		boolean check = false;
		for (int i = 0; i < SoLuong; i++) {
			if (dsnv[i].getHoten().contains(x)) {
				dsnv[i].xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ten nhan vien khong ton tai!!");
	}

	@Override
	public void TimKiemO() {
		if(SoLuong == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			return;
		}
		int tk = -1;
		boolean check = true;
		while (check) {
			System.out.println("_________________________________");
			System.out.println("|            Tim Kiem           |");
			System.out.println("|===============================|");
			System.out.println("|1.Tim kiem theo ma nhan vien   |");
			System.out.println("---------------------------------");
			System.out.println("|2.Tim kiem theo ten nhan vien  |");
			System.out.println("---------------------------------");
			System.out.println("|3.Quay lai                     |");
			System.out.println("---------------------------------");
			try {
				tk = Integer.parseInt(sc.next());
				if (tk < 1 || tk > 3) {
					System.out.println("cu phap khong hop le !!");
				}
			} catch (Exception e) {
				System.out.println("cu phap khong hop le !!");
				tk = -1;
			}
			sc.nextLine();
			if (tk >= 1 && tk <= 3) {
				switch (tk) {
				case 1:
					String mnv;
					System.out.println("Nhap ma nhan vien can tim");
					mnv = sc.nextLine();
					timtheomanv(mnv);
					break;

				case 2:
					String tennv;
					System.out.println("Nhap ten nhan vien can tim");
					tennv = sc.nextLine();
					while (!tennv.matches("[a-zA-Z\s]+")) {
						System.out.println("Ten khong hop le, nhap lai:");
						tennv = sc.nextLine();
					}
					timtheoten(tennv);
					break;
				case 3:
					check = false;
					break;
				}
			}
		}
	}

	// phương thức static đêms số Nhân viên bán hàng trong siêu thị
	public static int demNV() {
		int count = 0;
		;
		for (int i = 0; i < dsnv.length; i++) {
			if ("NV BAN HANG".equalsIgnoreCase(dsnv[i].chucvu)) {
				count++;
			}
		}
		return count;
	}

	public void docFile() {
		try {
			FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\NHANVIEN.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				
				line = br.readLine();
				if (line == null) {
					break;
				}
				String s[] = line.split(";");
				String maNV = s[0];
				String hoTen = s[1];
				String ngaySinh = s[2];
				String sdt = s[3];
				String sonha = s[4];
				String tduong = s[5];
				int sophuong = Integer.parseInt(s[6]);
				String tquan = s[7];
				String chucvu = s[8];
				double tienluong = Double.parseDouble(s[9].trim());

				dsnv = Arrays.copyOf(dsnv, SoLuong + 1);
				dsnv[SoLuong] = new NHANVIEN(maNV, hoTen, ngaySinh, sdt, sonha, tduong, sophuong, tquan, chucvu,
						tienluong);
				SoLuong++;
			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
	}

	public void ghiFile() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\NHANVIEN.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (NHANVIEN e : dsnv) {
				bw.write(e.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {

		}
	}

	public void Menu() {
		boolean thoat = true;
		int x = 0;
		while (thoat) {
			x = 0;
			System.out.println(" _____________________________________________");
			System.out.println("|                  MENU                       |");
			System.out.println("+=============================================+");
			System.out.println("|1.Nhap danh sach nhan vien                   |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|2.Xuat danh sach nhan vien                   |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|3.Them nhan vien                             |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|4.Xoa nhan vien                              |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|5.Sua thong tin nhan vien                    |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|6.Tim kiem nhan vien                         |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|7.DOC FILE                                   |");
			System.out.println("-----------------------------------------------");
			System.out.println("|8.GHI FILE                                   |");
			System.out.println("-----------------------------------------------");
			System.out.println("|9.EXIT                                       |");
			System.out.println("-----------------------------------------------");
			try {
				x = Integer.parseInt(sc.next());

				if (x < 1 || x > 9) {
					System.out.println("SAI CU PHAP!!");

				}
			} catch (Exception e) {
				System.out.println("SAI CU PHAP!!");

			}
			if (x >= 1 && x <= 9) {
				switch (x) {
				case 1:
					nhap();
					break;
				case 2:
					xuat();
					break;
				case 3:
					ThemO();
					break;
				case 4:
					XoaO();
					break;
				case 5:
					SuaO();
					break;
				case 6:
					TimKiemO();
					break;
				case 7:
					docFile();
					System.out.println("done!");
					break;
				case 8:
					ghiFile();
					System.out.println("done!");
					break;
				case 9:
					thoat = false;
					System.out.println("END");
					break;
				}
			}
		}
	}
	
	public static boolean checkMaNVexist(String x) {
		if(SoLuong == 0) {
			System.out.println("Chua tuyen nhan vien");
			return false;
		}
		for(int i = 0; i < dsnv.length; i++) {
//			System.out.println(dsnv[i].getManv());
			if(dsnv[i].getManv().equals(x.trim()))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DSNhanVien A = new DSNhanVien();
		A.Menu();
	}
}
