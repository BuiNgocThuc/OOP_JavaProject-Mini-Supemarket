package QUANLI_SIEUTHIMINI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DSHoaDon {
	public static ArrayList<HOADON> dshd= new ArrayList<HOADON>();

	Scanner sc = new Scanner(System.in);

	public DSHoaDon() {
	}

	public String nhap() {
		HOADON hd = new HOADON();
		String maHD = hd.taoHD();
		dshd.add(hd);
		System.out.println("DONE!!");
		return maHD;
	}
	
	public void xuat() {
		System.out.println(
				" ________________________________________________________________________________________________________________________________________________________________________");
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|", "Ma Hoa Don",
				"Ma Nhan Vien", "Ma Khach Hang", "Ngay Nhap", "Tong Tien");
		System.out.println(out1);
		for (int i = 0; i < dshd.size(); ++i) {
			dshd.get(i).xuat();
			System.out.println("");
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n"
						+ "");
	}
	
	public void timtheomahd(String x) {
		boolean check = false;
		for (int i = 0; i < dshd.size(); i++) {
			if (dshd.get(i).getMaHD().equals(x)) {
				dshd.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("Ma hoa don khong ton tai!!");
	}

	public void timtheomakh(String x) {
		boolean check = false;
		for (int i = 0; i < dshd.size(); i++) {
			if (dshd.get(i).getMaKH().equals(x)) {
				dshd.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("ma khach hang khong ton tai!!");
	}
	
	public void timtheomanv(String x) {
		boolean check = false;
		for (int i = 0; i < dshd.size(); i++) {
			if (dshd.get(i).getmaNV().equals(x)) {
				dshd.get(i).xuat();
				check = true;
			}
		}
		if (check == false)
			System.out.println("ma nhan vien khong ton tai!!");
	}
	
	//@Override
	public void TimKiemO() {
		if(dshd.size() == 0) {
			System.out.println("Danh sach rong!! Tao danh sach moi");
			return;
		}
		int tk = -1;
		boolean check = true;
		while (check) {
			System.out.println("_________________________________");
			System.out.println("|            Tim Kiem           |");
			System.out.println("|===============================|");
			System.out.println("|1.Tim kiem theo ma hoa don     |");
			System.out.println("---------------------------------");
			System.out.println("|2.Tim kiem theo ma khach hang  |");
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
					System.out.println("Nhap ma hoa don can tim");
					mpn = sc.nextLine();
					timtheomahd(mpn);
					break;
				case 2:
					String mncc;
					System.out.println("Nhap ma khach hang can tim");
					mncc = sc.nextLine();
					timtheomakh(mncc);
					break;
				case 3:
					String manv;
					System.out.println("Nhap ma nhan vien can tim");
					manv = sc.nextLine();
					timtheomanv(manv);
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
            FileReader fr = new FileReader("C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\data\\HOADON.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String s[] = line.split(";");
                String maHD = s[0];
                String maNV = s[1];
                String maKH = s[2];
                String ngayNhap = s[3];
                int tongTien = Integer.parseInt(s[4].trim());
                
                dshd.add(new HOADON(maHD, maNV, maKH, ngayNhap, tongTien));
            }
          
            br.close();
            fr.close();
        } catch (Exception e) {
        	System.err.print("Error " + e.toString());
        }
        System.out.println("Done!!!");
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter(
            		"C:\\Users\\NGOC THUC\\eclipse-workspace\\DO_AN_OOP\\WriteFile\\HOADON.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (HOADON e : dshd) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {

        }
        System.out.println("Done!!!");
    }
}
