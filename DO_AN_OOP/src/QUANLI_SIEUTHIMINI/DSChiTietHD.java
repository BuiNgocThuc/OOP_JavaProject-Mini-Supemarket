package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DSChiTietHD {

	public static ArrayList<CTHoaDon> cthd = new ArrayList<CTHoaDon>();

	Scanner sc = new Scanner(System.in);

	public DSChiTietHD() {

	}

	public int nhap(String maHD) {
		int sum = 0;
		int temp = 0;

		boolean error;
		do {
			try {
				System.out.println("nhap so luong mat hang: ");
				temp = Integer.parseInt(sc.next());
				error = false;
				if (temp < 1) {
					System.out.println("so luong them khong hop le, nhap lai!!");
					error = true;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("so luong them khong hop le, nhap lai!!");
				error = true;
			}
		} while (error);
		for (int i = 0; i < temp; i++) {
			System.out.println("Nhap thong tin mat hang thu " + (i + 1));
			cthd.add(new CTHoaDon());
			cthd.get(DSChiTietHD.cthd.size()-1).taoCTHD(maHD);
			sum += cthd.get(DSChiTietHD.cthd.size()-1).getthanhTien();
		}
		System.out.println("DONE!!!");
		return sum;
	}

	public void xuat() {
		System.out.println(
				" ________________________________________________________________________________________________________________________________________________________________________");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", "Ma Hoa Don", "Ma Hang Hoa",
				"Don Gia", "So Luong", "Thanh Tien");
		System.out.println(out1);
		for (int i = 0; i < cthd.size(); ++i) {
			cthd.get(i).xuat();
			System.out.println("");
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n"
						+ "");
	}

	public void timtheomahd(String x) {
		boolean check = false;
		for (int i = 0; i < cthd.size(); i++) {
			if (cthd.get(i).getMaHD().equals(x)) {
				cthd.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ma Hoa don khong ton tai!!");
	}

	public void timtheomahh(String x) {
		boolean check = false;
		for (int i = 0; i < cthd.size(); i++) {
			if (cthd.get(i).getMaHH().equals(x)) {
				cthd.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("ma hang hoa khong ton tai!!");
	}

	// @Override
	public void TimKiemO() {
		// TODO Auto-generated method stub
		int tk = -1;
		boolean check = true;
		while (check) {
			System.out.println("_________________________________");
			System.out.println("|            Tim Kiem           |");
			System.out.println("|===============================|");
			System.out.println("|1.Tim kiem theo ma hoa don     |");
			System.out.println("---------------------------------");
			System.out.println("|2.Tim kiem theo ma hang hoa    |");
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
					String mhd;
					System.out.println("Nhap ma phieu nhap can tim");
					mhd = sc.nextLine();
					timtheomahd(mhd);
					break;

				case 2:
					String mhh;
					System.out.println("Nhap ma hang hoa can tim");
					mhh = sc.nextLine();
					timtheomahh(mhh);
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
			FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\CTHoaDon.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String s[] = line.split(";");
				String maHD = s[0];
				String maHH = s[1];
				int dongia = Integer.parseInt(s[2]);
				int SL = Integer.parseInt(s[3]);
				int thanhTien = Integer.parseInt(s[4]);

				cthd.add(new CTHoaDon(maHD, maHH, dongia, SL, thanhTien));

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		System.out.println("Done!!!");
	}

	public void ghiFile() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\CTHoaDon.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (CTHoaDon e : cthd) {
				bw.write(e.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {

		}
		System.out.println("Done!!!");
	}

	/*
	 * public void Menu() {
	 * 
	 * int x; boolean exit = false; while (!exit) { x = 0;
	 * System.out.println(" _____________________________________________");
	 * System.out.println("|                  MENU                       |");
	 * System.out.println("+=============================================+");
	 * System.out.println("|1.Tao moi hoa don                            |");
	 * System.out.println("|---------------------------------------------|");
	 * System.out.println("|2.Xuat danh sach chi tiet hoa don            |");
	 * System.out.println("|---------------------------------------------|");
	 * System.out.println("|3.Them san pham                              |");
	 * System.out.println("|---------------------------------------------|");
	 * System.out.println("|4.Xoa san pham                               |");
	 * System.out.println("|---------------------------------------------|");
	 * System.out.println("|5.Sua thong tin chi tiet hoa don             |");
	 * System.out.println("|---------------------------------------------|");
	 * System.out.println("|6.Tim kiem chi tiet hoa don                  |");
	 * System.out.println("|---------------------------------------------|");
	 * System.out.println("|7.DOC FILE                                   |");
	 * System.out.println("-----------------------------------------------");
	 * System.out.println("|8.GHI FILE                                   |");
	 * System.out.println("-----------------------------------------------");
	 * System.out.println("|9.TINH TONG TIEN CAC HOA DON                 |");
	 * System.out.println("-----------------------------------------------");
	 * System.out.println("|10.EXIT                                      |");
	 * System.out.println("-----------------------------------------------"); try {
	 * x = Integer.parseInt(sc.next());
	 * 
	 * if (x < 1 || x > 9) { System.out.println("SAI CU PHAP!!");
	 * 
	 * } } catch (Exception e) { System.out.println("SAI CU PHAP!!");
	 * 
	 * } if (x >= 1 && x <= 9) { switch (x) { case 1: nhap(); break; case 2: xuat();
	 * break; case 6: TimKiemO(); break; case 7: docFile();
	 * System.out.println("done!"); break; case 8: ghiFile();
	 * System.out.println("done!"); break; case 9: tinhTongTien();
	 * System.out.println("done!"); break; case 10: exit = true;
	 * System.out.println("END"); break; } } } }
	 */

	public static void main(String[] args) {

		// A.Menu();
	}
}
