package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSNhaCungCap implements InterfaceC {
	public static int SoLuong = 0;
	private static NhaCC[] dsncc = new NhaCC[SoLuong];
	
	static int countNCC = 0;

	Scanner sc = new Scanner(System.in);

	public DSNhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	public void nhap() {
		boolean error;
		do {
			try {
				System.out.println("nhap so luong nha cung cap: ");
				SoLuong = Integer.parseInt(sc.next());
				error = false;
				if (SoLuong < 0) {
					System.out.println("so luong them khong hop le, nhap lai!!");
					error = true;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("so luong them khong hop le, nhap lai!!");
				error = true;
			}
		} while (error);
		dsncc = new NhaCC[SoLuong];
		for (int i = 0; i < SoLuong; i++) {
			System.out.println("Nhap thong tin nha cung cap thu " + (i + 1));
			dsncc[i] = new NhaCC();
			dsncc[i].nhap();
		}
		System.out.println("DONE!!!");
	}

	public void xuat() {
		System.out.println(
				" ______________________________________________________________________________________________________________________________");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-40s|", "ID Nha Cung Cap", "Ten Nha Cung Cap", "So dien thoai", "Email",
				"DiaChi");
		System.out.println(out1);
		for (int i = 0; i < SoLuong; ++i) {
			dsncc[i].xuat();
			System.out.println("");
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------");
	}

	public void themncc(int k) {
		dsncc = Arrays.copyOf(dsncc, SoLuong + k);
		for (int i = SoLuong; i < SoLuong + k; i++) {
			dsncc[i] = new NhaCC();
			dsncc[i].nhap();
		}
		SoLuong = SoLuong + k;
	}

	@Override
	public void ThemO() {
		if(SoLuong == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			countNCC = 0;
			nhap();
			return;
		}else {
			countNCC = SoLuong;
		}
		System.out.println("Nhap vao so luong muon them");
		int num = -1;
		while (true) {
			try {
				num = Integer.parseInt(sc.next());
				if (num >= 1)
					break;
			} catch (Exception e) {

			}
			if (num <= 0)
				System.out.println("So luong can them khong hop le vui long nhap lai");
		}
		if (num >= 1) {
			themncc(num);
			System.out.println("Them Thanh Cong");
		}

	}

	public void xoa(int vt) {
		for (int i = vt; i < SoLuong - 1; i++) {
			dsncc[i] = dsncc[i + 1];
		}
		dsncc = Arrays.copyOf(dsncc, SoLuong - 1);
		SoLuong--;

	}

	public void xoatheomancc(String x) {
		int kt = -1;
		for (int i = 0; i < SoLuong; ++i) {
			if (dsncc[i].getMaNCC().equals(x)) {
				kt = i;
				break;
			}
		}
		if (kt == -1) {
			System.out.println("Ma ncc nay ko ton tai!!");
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
			System.out.println("|1.Xoa theo ma nha cung cap   |");
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
					System.out.println("Nhap ma nha cung cap can xoa");
					xoama = sc.next();
					xoatheomancc(xoama);
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
				System.out.println("__Nhap ma nha cung cap can sua__");
				ma = sc.next();
				for (int i = 0; i < SoLuong; i++) {
					if (dsncc[i].getMaNCC().equals(ma)) {
						check = false;
						break;
					}
				}
				if (check == true) {
					System.out.println("Ma nha cung khong ton tai, nhap lai!!");
				}
			} catch (Exception e) {
				System.out.println("Ma nha cung cap khong ton tai, nhap lai!!");
			}
		}
		check = true;
		for (int i = 0; i < SoLuong; i++) {
			if (dsncc[i].getMaNCC().equals(ma)) {
				while (check) {
					int option = -1;
					System.out.println("_________________________________");
					System.out.println("|   Chon thuoc tinh can sua     |");
					System.out.println("+===============================+");
					System.out.println("|1.Sua ten nha cung cap         |");
					System.out.println("---------------------------------");
					System.out.println("|2.Sua sdt nha cung cao         |");
					System.out.println("---------------------------------");
					System.out.println("|3.Sua dia chi nha cung cap     |");
					System.out.println("---------------------------------");
					System.out.println("|4.Quay lai                     |");
					System.out.println("---------------------------------");
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
							System.out.println("Nhap ten nha cung cap moi");
							tenkh = sc.nextLine();
							while (!tenkh.matches("[a-zA-Z\s]+")) {
								System.out.println("Ten khong hop le, nhap lai:");
								tenkh = sc.nextLine();
							}
							dsncc[i].setTenNCC(tenkh);
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
							System.out.println(dienthoai);
							dsncc[i].setSdtNCC(dienthoai);
							break;
						case 3:
							System.out.println("Nhap so dia chi moi");
							DIACHI A = new DIACHI();
							A.nhapDiaChi();
							dsncc[i].setDiachiNCC(A);
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

	public void timtheomancc(String x) {
		boolean check = false;
		for (int i = 0; i < SoLuong; i++) {
			if (dsncc[i].getMaNCC().equals(x)) {
				dsncc[i].xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ma nha cung cap khong ton tai!!");
	}

	public void timtheoten(String x) {
		boolean check = false;
		for (int i = 0; i < SoLuong; i++) {
			if (dsncc[i].getTenNCC().contains(x)) {
				dsncc[i].xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ten nha cung cap khong ton tai!!");
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
			System.out.println("____________________________________");
			System.out.println("|            Tim Kiem              |");
			System.out.println("|==================================|");
			System.out.println("|1.Tim kiem theo ma nha cung cap   |");
			System.out.println("------------------------------------");
			System.out.println("|2.Tim kiem theo ten nha cung cap  |");
			System.out.println("------------------------------------");
			System.out.println("|3.Quay lai                        |");
			System.out.println("------------------------------------");
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
					System.out.println("Nhap ma nha cung cap can tim");
					mnv = sc.nextLine();
					timtheomancc(mnv);
					break;

				case 2:
					String tennv;
					System.out.println("Nhap ten nha cung cap can tim");
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

	public void docFile() {
		try {
			FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\NHACUNGCAP.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String s[] = line.split(";");
				String maNCC = s[0];
				String hoTen = s[1];
				String sdt = s[2];
				String maSoThue = s[3];
				String sonha = s[4];
				String tduong = s[5];
				int sophuong = Integer.parseInt(s[6]);
				String tquan = s[7].trim();

//				System.out.println(hoTen);

				dsncc = Arrays.copyOf(dsncc, SoLuong + 1);
				dsncc[SoLuong] = new NhaCC(maNCC, hoTen, sdt, maSoThue, sonha, tduong, sophuong, tquan);
				SoLuong++;
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.print("Error " + e.toString());
		}
	}

	public void ghiFile() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\NHACUNGCAP.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (NhaCC e : dsncc) {
				bw.write(e.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {

		}
	}
	
	
	public void Menu() {
		boolean exit = false;
		while (!exit) {
			int x = 0;
			System.out.println(" _____________________________________________");
			System.out.println("|                  MENU                       |");
			System.out.println("+=============================================+");
			System.out.println("|1.Nhap danh sach nha cung cap                |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|2.Xuat danh sach nha cung cap                |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|3.Them nha cung cap                          |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|4.Xoa nha cung cap                           |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|5.Sua thong tin nha cung cap                 |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|6.Tim kiem nha cung cap                      |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|7.DOC FILE                                   |");
			System.out.println("----------------------------------------------|");
			System.out.println("|8.GHI FILE                                   |");
			System.out.println("----------------------------------------------|");
			System.out.println("|9.EXIT                                       |");
			System.out.println("+=============================================+");
			try {
				x = Integer.parseInt(sc.next());

				if (x < 1 || x > 9) {
					System.out.println("SAI CU PHAP!!");

				}
			} catch (Exception e) {
				System.out.println("SAI CU PHAP!!");

			}
			sc.nextLine();
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
					exit = true;
					System.out.println("END");
					break;
				}
			}
		}
	}
	
	public static boolean checkMaNCCexist(String x) {
		if(SoLuong == 0) {
			System.out.println("Chua co nha cung cap!!");
			return false;
		}
		for(int i = 0; i < dsncc.length; i++) {
			if(dsncc[i].getMaNCC().equals(x))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		DSNhaCungCap A = new DSNhaCungCap();
		A.Menu();
	}
}
