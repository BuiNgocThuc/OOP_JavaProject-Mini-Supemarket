package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSHangHoa {
	Scanner sc = new Scanner(System.in);
	public static ArrayList<HANGHOA> h = new ArrayList<>();

	public DSHangHoa() {

	}

	public void Xuat() {
		System.out.println(
				" _________________________________________________________________________________________________________________________________________");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", "Ma Hang Hoa", "Ten Hang Hoa",
				"Loai Hang Hoa", "Muc Dich Su Dung", "Don Gia", "So Luong");
		System.out.println(out1);
		for (HANGHOA objhh : h) {
			objhh.Xuat();
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------");

	}

	public void DocFile() {
		try {
			FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\HANGHOA.txt");
			try (BufferedReader br = new BufferedReader(fr)) {
				String line = "";
				while (true) {
					try {
						line = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (line == null) {
						break;
					}
					String s[] = line.split(";");
					String maHH = s[0].trim();
					String tenHH = s[1].trim();

					String loai = s[2].trim();
					String purpose = s[3].trim();
					int Gia = Integer.parseInt(s[4]);
					int soLuong = Integer.parseInt(s[5].trim());

					HANGHOA hh = null;
					if (maHH.contains("DH") || maHH.contains("CB")) {
						hh = new THUCPHAM(maHH, tenHH, loai, purpose, Gia, soLuong);
					} else if (maHH.contains("CG") || maHH.contains("CC")) {
						hh = new NUOCUONG(maHH, tenHH, loai, purpose, Gia, soLuong);
					} else if (maHH.contains("KG") || maHH.contains("DC")) {
						hh = new DOCANHAN(maHH, tenHH, loai, purpose, Gia, soLuong);
					}
					h.add(hh);
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Done!!");
	}

	public void ghiFile() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\HANGHOA.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (HANGHOA e : h) {
				bw.write(e.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {

		}
		System.out.println("Done!!");
	}

	protected void timkiemma() {
		boolean IsValid = false;
		System.out.println("Nhap ma san pham can tim");
		String mahh = sc.nextLine();
		for (HANGHOA objhh : h) {
			if (objhh.getMaHH().equals(mahh)) {
				objhh.Xuat();
				IsValid = true;
				break;
			} 
		}
		if (IsValid == false) {
			System.out.println("Khong co san pham trong danh sach");
		}
	}

	public void menu() {
		boolean isValid = false;
		int option;
		while (!isValid) {
			option = 0;
			System.out.println("\n---------------------Nhap lua chon------------------|");
			System.out.println("|-----------------------------------------------------|");
			System.out.println("|1.Xuat danh sach hang hoa                            |");
			System.out.println("|-----------------------------------------------------|");
			System.out.println("|2.Tim kiem hang hoa                         	      |");
			System.out.println("|-----------------------------------------------------|");
			System.out.println("|3.Doc file danh sach hang hoa                        |");
			System.out.println("|-----------------------------------------------------|");
			System.out.println("|4.Ghi file danh sach hang hoa                        |");
			System.out.println("|-----------------------------------------------------|");
			System.out.println("|5.Thoat                                              |");
			System.out.println("-------------------------------------------------------");
			try {
				System.out.println("Nhao lua chon");
				option = Integer.parseInt(sc.next());
				if (option < 1 || option > 5) {
					System.out.println("Sai Cu Phap");
				}
			} catch (Exception e) {
				System.out.println("Sai Cu Phap");
			}
			sc.nextLine();
			if (option >= 1 && option <= 5) {
				switch (option) {
				case 1:
					Xuat();
					break;
				case 2:
					timkiemma();
					break;
				case 3:
					DocFile();
					break;
				case 4:
					ghiFile();
					break;
				case 5:
					isValid = true;
					System.out.println("END");
					break;
				}
			}
		}
	}

	public static int getHangHoaPosition(String maHH) {
		int pos = -1;
		for (int i = 0; i < DSHangHoa.h.size(); i++) {
			if (DSHangHoa.h.get(i).getMaHH().equals(maHH)) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		DSHangHoa A = new DSHangHoa();
		A.menu();
		// A.finalout();
	}
}
