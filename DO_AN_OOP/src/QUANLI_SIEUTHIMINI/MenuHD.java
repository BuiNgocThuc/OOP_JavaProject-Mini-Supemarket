package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class MenuHD {
	DSHoaDon dshd;
	DSChiTietHD cthd;

	Scanner sc = new Scanner(System.in);

	public MenuHD() {
		dshd = new DSHoaDon();
		cthd = new DSChiTietHD();
	}

	public void Menu() {
		int option;
		boolean exit = false;
		while (!exit) {
			option = 0;
			System.out.println(" _____________________________________________");
			System.out.println("|                  MENU                       |");
			System.out.println("+=============================================+");
			System.out.println("|1.Tao moi hoa don                            |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|2.Xuat danh sach chi tiet hoa don            |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|3.Xuat danh sach hoa don					  |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|4.Tim kiem hoa don                           |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|5.Tim kiem chi tiet hoa don                  |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|6.DOC FILE DANH SACH hoa don                 |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|7.DOC FILE CHI TIET hoa don                  |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|8.GHI FILE DANH SACH hoa don                 |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|9.GHI FILE CHI TIET hoa don                  |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|10.EXIT                                      |");
			System.out.println("-----------------------------------------------");
			try {
				option = Integer.parseInt(sc.next());

				if (option < 1 || option > 10) {
					System.out.println("SAI CU PHAP!!");

				}
			} catch (Exception e) {
				System.out.println("SAI CU PHAP!!");

			}
			if (option >= 1 && option <= 10) {
				sc.nextLine();
				switch (option) {
				case 1:
					int money = 0;
					String maHD = dshd.nhap();
					if (maHD != "-1") {
						money = cthd.nhap(maHD);
					} else {
						System.out.println("ma hoa don chua duoc tao!!");
					}
					for(int i = 0; i < DSHoaDon.dshd.size(); ++i) {
						if(DSHoaDon.dshd.get(i).getMaHD().equals(maHD)) {
							DSHoaDon.dshd.get(i).settongTien(money);
						}
					}
					break;
				case 2:
					cthd.xuat();
					break;
				case 3:
					dshd.xuat();
					break;
				case 4:
					dshd.TimKiemO();
					break;
				case 5:
					cthd.TimKiemO();
					break;
				case 6:
					dshd.docFile();
					;
					break;
				case 7:
					cthd.docFile();
					;
					break;
				case 8:
					dshd.ghiFile();
					;
					break;
				case 9:
					cthd.ghiFile();
					;
					break;
				case 10:
					exit = true;
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		MenuHD A = new MenuHD();
		A.Menu();
	}
}
