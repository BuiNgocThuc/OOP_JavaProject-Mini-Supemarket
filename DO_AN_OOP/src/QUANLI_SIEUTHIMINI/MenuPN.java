package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class MenuPN {
	DSPhieuNhap dspn;
	DSChiTietPN ctpn;

	Scanner sc = new Scanner(System.in);

	public MenuPN() {
		dspn = new DSPhieuNhap();
		ctpn = new DSChiTietPN();
	}

	public void Menu() {
		int option;
		boolean exit = false;
		while (!exit) {
			option = 0;
			System.out.println(" _____________________________________________");
			System.out.println("|                  MENU                       |");
			System.out.println("+=============================================+");
			System.out.println("|1.Tao moi phieu nhap                         |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|2.Xuat danh sach chi tiet phieu nhap         |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|3.Xuat danh sach phieu nhap                  |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|4.Tim kiem phieu nhap                        |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|5.Tim kiem chi tiet phieu nhap               |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|6.DOC FILE DANH SACH PHIEU NHAP              |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|7.DOC FILE CHI TIET PHIEU NHAP               |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|8.GHI FILE DANH SACH PHIEU NHAP               |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|9.GHI FILE CHI TIET PHIEU NHAP               |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|10.EXIT                                       |");
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
					String maPN = dspn.nhap();
//					System.out.println(maPN);
					if (maPN != "-1") {
						money = ctpn.nhap(maPN);
					} else {
						System.out.println("ma phieu nhap chua duoc tao!!");
					}
					for(int i = 0; i < DSHoaDon.dshd.size(); ++i) {
						if(DSPhieuNhap.dspn.get(i).getMaPN().equals(maPN)) {
							DSPhieuNhap.dspn.get(i).setTongTien(money);
						}
					}
					break;
				case 2:
					ctpn.xuat();
					break;
				case 3:
					dspn.xuat();
					break;
				case 4:
					dspn.TimKiemO();
					break;
				case 5:
					ctpn.TimKiemO();
					break;
				case 6:
					dspn.docFile();
					break;
				case 7:
					ctpn.docFile();
					break;
				case 8:
					dspn.ghiFile();
					break;
				case 9:
					ctpn.ghiFile();
					break;
				case 10:
					exit = true;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		MenuPN A = new MenuPN();
		A.Menu();
	}
}
