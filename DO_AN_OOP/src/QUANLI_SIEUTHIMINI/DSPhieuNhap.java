package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DSPhieuNhap {
	public static ArrayList<PHIEUNHAP> dspn = new ArrayList<PHIEUNHAP>();
	
	Scanner sc = new Scanner(System.in);
	
	public DSPhieuNhap() {
	}

	public String nhap() {
	    PHIEUNHAP pn = new PHIEUNHAP();
		String maPN = pn.taoPN();
	    dspn.add(pn);
		System.out.println("DONE!!");
		return maPN;
	}
	
	public void xuat() {
		System.out.println(
				" _________________________________________________________________________________________________________");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", "Ma Phieu Nhap",
				"Ma Nhan Vien", "Ma Nha Cung Cap", "Ngay Nhap", "Tong Tien");
		System.out.println(out1);
		for (int i = 0; i < dspn.size(); ++i) {
			dspn.get(i).xuat();
			System.out.println("");
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------\r\n");
	}
	
	public void timtheomapn(String x) {
		boolean check = false;
		for (int i = 0; i < dspn.size(); i++) {
			if (dspn.get(i).getMaPN().equals(x)) {
				dspn.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ma phieu nhap khong ton tai!!");
	}

	public void timtheomancc(String x) {
		boolean check = false;
		for (int i = 0; i < dspn.size(); i++) {
			if (dspn.get(i).getMaNCC().equals(x)) {
				dspn.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("ma nha cung cap khong ton tai!!");
	}
	
	public void timtheomanv(String x) {
		boolean check = false;
		for (int i = 0; i < dspn.size(); i++) {
			if (dspn.get(i).getMaNV().equals(x)) {
				dspn.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("ma nhan vien khong ton tai!!");
	}
	
	public void TimKiemO() {
		if(dspn.size() == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			return;
		}
		int tk = -1;
		boolean check = true;
		while (check) {
			System.out.println("_________________________________");
			System.out.println("|            Tim Kiem           |");
			System.out.println("|===============================|");
			System.out.println("|1.Tim kiem theo ma phieu nhap  |");
			System.out.println("---------------------------------");
			System.out.println("|2.Tim kiem theo ma nha cung cap|");
			System.out.println("---------------------------------");
			System.out.println("|3.Tim kiem theo ma nhan vien   |");
			System.out.println("---------------------------------");
			System.out.println("|4.Quay lai                     |");
			System.out.println("---------------------------------");
			try {
				tk = Integer.parseInt(sc.next());
				if (tk < 1 || tk > 4) {
					System.out.println("cu phap khong hop le !!");
				}
			} catch (Exception e) {
				System.out.println("cu phap khong hop le !!");
				tk = -1;
			}
			sc.nextLine();
			if (tk >= 1 && tk <= 4) {
				switch (tk) {
				case 1:
					String mpn;
					System.out.println("Nhap ma phieu nhap can tim");
					mpn = sc.nextLine();
					timtheomapn(mpn);
					break;
				case 2:
					String mncc;
					System.out.println("Nhap ma nha cung cap can tim");
					mncc = sc.nextLine();
					timtheomancc(mncc);
					break;
				case 3:
					String manv;
					System.out.println("Nhap ma nhan vien can tim");
					manv = sc.nextLine();
					timtheomancc(manv);
					break;
				case 4:
					check = false;
					break;
				}
			}
		}
	}
	
	public void docFile() {
		try {
			FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\PHIEUNHAP.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String s[] = line.split(";");
				String maPN = s[0];
				String maNV = s[1];
				String maNCC = s[2];
				String ngayNhap = s[3];
				int tongTien = Integer.parseInt(s[4]);

//				System.out.println(hoTen);

				dspn.add(new PHIEUNHAP(maPN, maNV, maNCC, ngayNhap, tongTien));
//				System.out.println("Ma khach hang" + String.valueOf(dspn[SoLuong].theThanhVien.getMaKH().toString()));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.print("Error " + e.toString());
		}
		System.out.println("Done!!");
	}
	
	public void ghiFile() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\PHIEUNHAP.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (PHIEUNHAP e : dspn) {
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
