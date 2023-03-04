package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DSChiTietPN {
	public static ArrayList<CTPhieuNhap> ctpn = new ArrayList<CTPhieuNhap>();

	Scanner sc = new Scanner(System.in);

	public DSChiTietPN() {
	}

	public int nhap(String maPN) {
		int sum = 0;
		boolean IsValid = false;
		int temp = 0;
		while (!IsValid) {
			try {
				System.out.println("Nhap so luong mat hang nhap: ");
				temp = Integer.parseInt(sc.next());
				IsValid = true;
				if (temp < 1) {
					System.out.println("So Luong them khong hop le");
					IsValid = false;
				}
			} catch (Exception e) {
				System.out.println("So Luong them khong hop le");
				IsValid = false;
			}
		}
		for (int i = 0; i < temp; i++) {
			System.out.println("Nhap thong tin phieu nhap thu " + (i + 1));
			ctpn.add(new CTPhieuNhap());
			ctpn.get(DSChiTietPN.ctpn.size()-1).taoCTPN(maPN);
			sum += ctpn.get(DSChiTietPN.ctpn.size()-1).getThanhTien();
		}
		System.out.println("DONE!!!");
		return sum;
	}

	public void xuat() {
		System.out.println(
				"  _________________________________________________________________________________________________________");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", "Ma Phieu Nhap", "Ma Hang Hoa", "Don Gia",
				"So Luong", "Thanh Tien");
		System.out.println(out1);
		for (int i = 0; i < ctpn.size(); ++i) {
			ctpn.get(i).xuat();
			System.out.println("");
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------\r\n"
						+ "");
	}

	public void timtheomapn(String x) {
		boolean check = false;
		for (int i = 0; i < ctpn.size(); i++) {
			if (ctpn.get(i).getMaPN().equals(x)) {
				ctpn.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ma phieu nhap khong ton tai!!");
	}

	public void timtheomahh(String x) {
		boolean check = false;
		for (int i = 0; i < ctpn.size(); i++) {
			if (ctpn.get(i).getMaHH().equals(x)) {
				ctpn.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("ma hang hoa khong ton tai!!");
	}

	// TÌM THEO MA NHA CUNG CAP, THEO MA NHAN VIEN NHAP

	// @Override
	public void TimKiemO() {
		// TODO Auto-generated method stub
		int tk = -1;
		boolean check = true;
		while (check) {
			System.out.println("_________________________________");
			System.out.println("|            Tim Kiem           |");
			System.out.println("|===============================|");
			System.out.println("|1.Tim kiem theo ma phieu nhap  |");
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
					String mpn;
					System.out.println("Nhap ma phieu nhap can tim");
					mpn = sc.nextLine();
					timtheomapn(mpn);
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
			FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\CTPhieuNhap.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String s[] = line.split(";");
				String maPN = s[0];
				String maHH = s[1];
				int donGia = Integer.parseInt(s[2]);
				int SL = Integer.parseInt(s[3]);
				int thanhTien = Integer.parseInt(s[4]);

				// System.out.println(maPN);

				ctpn.add(new CTPhieuNhap(maPN, maHH, donGia, SL, thanhTien));
			}
			// System.out.println(count);
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		System.out.println("Done!!");
	}

	public void ghiFile() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\CTPhieuNhap.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (CTPhieuNhap e : ctpn) {
				bw.write(e.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {

		}
		System.out.println("Done!!");
	}
}
