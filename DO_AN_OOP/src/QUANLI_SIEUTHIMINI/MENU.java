package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

public class MENU {
	Scanner sc = new Scanner(System.in);

	public void menuChinh() {
		while (true) {
			System.out.println("|====================*CONVENIENCE STORE MANAGEMENT*===================|");
			System.out.println("|=====================================================================|");
			System.out.println("|\t\t1.DANH SACH HANG HOA                     	      |");
			System.out.println("|\t\t2.DANH SACH KHACH HANG                  	      |");
			System.out.println("|\t\t3.DANH SACH NHAN VIEN                                 |");
			System.out.println("|\t\t4.DANH SACH NHA CUNG CAP                              |");
			System.out.println("|\t\t5.DANH SACH PHIEU NHAP                                |");
			System.out.println("|\t\t6.DANH SACH HOA DON                                   |");
			System.out.println("|\t\t7.THONG KE SAN PHAM TRONG KHOANG THOI GIAN            |");
			System.out.println("|\t\t8.EXIT									  |");
			System.out.println("|\t\tNHAP LUA CHON CUA BAN?(input a number)                |");
			System.out.println("|=====================================================================|");
			boolean IsValid;
			int choice = 0;
			try {
				System.out.println("nhap lua chon: ");
				choice = Integer.parseInt(sc.next());
				if (choice < 1 || choice > 8) {
					System.out.println("Error!! Please select again!!");
				}
			} catch (Exception e) {
				System.out.println("Error!! Please select again!!");
			}
			sc.nextLine();
			if (choice >= 1 && choice <= 8) {
				switch (choice) {
				case 1: {
					DSHangHoa dshh = new DSHangHoa();
					boolean check = true;
					while (check) {
						dshh.menu();
						IsValid = false;
						while (!IsValid) {
							try {
								System.out.println("Do you want to return the main menu?? ( y or n )");
								String s = sc.nextLine();
								IsValid = true;
								if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
									check = false;
								}
								if (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("yes")
										&& !s.equalsIgnoreCase("no")) {
									System.out.println("Lua chon ko hop le!!!");
									IsValid = false;
								}
							} catch (Exception e) {
								System.out.println("Lua chon ko hop le!!!");
								IsValid = false;
							}
						}
					}
				}
					;
					break;
				case 2: {
					DSKhachHang dskh = new DSKhachHang();
					boolean check = true;
					;
					while (check) {
						dskh.Menu();
						IsValid = false;
						while (!IsValid) {
							try {
								System.out.println("Do you want to return the main menu?? ( y or n )");
								String s = sc.nextLine();
								IsValid = true;
								if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
									check = false;
								}
								if (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("yes")
										&& !s.equalsIgnoreCase("no")) {
									System.out.println("Lua chon ko hop le!!!");
									IsValid = false;
								}
							} catch (Exception e) {
								System.out.println("Lua chon ko hop le!!!");
								IsValid = false;
							}
						}
					}
				}
					;
					break;
				case 3: {
					DSNhanVien dsnv = new DSNhanVien();
					boolean check = true;
					;
					while (check) {
						dsnv.Menu();
						IsValid = false;
						while (!IsValid) {
							try {
								System.out.println("Do you want to return the main menu?? ( y or n )");
								String s = sc.nextLine();
								IsValid = true;
								if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
									check = false;
								}
								if (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("yes")
										&& !s.equalsIgnoreCase("no")) {
									System.out.println("Lua chon ko hop le!!!");
									IsValid = false;
								}
							} catch (Exception e) {
								System.out.println("Lua chon ko hop le!!!");
								IsValid = false;
							}
						}
					}
				}
					;
					break;
				case 4: {
					DSNhaCungCap dsncc = new DSNhaCungCap();
					boolean check = true;
					while (check) {
						dsncc.Menu();
						IsValid = false;
						while (!IsValid) {
							try {
								System.out.println("Do you want to return the main menu?? ( y or n )");
								String s = sc.nextLine();
								IsValid = true;
								if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
									check = false;
								}
								if (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("yes")
										&& !s.equalsIgnoreCase("no")) {
									System.out.println("Lua chon ko hop le!!!");
									IsValid = false;
								}
							} catch (Exception e) {
								System.out.println("Lua chon ko hop le!!!");
								IsValid = false;
							}
						}
					}
				}
					;
					break;
				case 5: {
					MenuPN dspn = new MenuPN();
					boolean check = true;
					while (check) {
						dspn.Menu();
						IsValid = false;
						while (!IsValid) {
							try {
								System.out.println("Do you want to return the main menu?? ( y or n )");
								String s = sc.nextLine();
								IsValid = true;
								if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
									check = false;
								}
								if (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("yes")
										&& !s.equalsIgnoreCase("no")) {
									System.out.println("Lua chon ko hop le!!!");
									IsValid = false;
								}
							} catch (Exception e) {
								System.out.println("Lua chon ko hop le!!!");
								IsValid = false;
							}
						}
					}
				}
					;
					break;
				case 6: {
					MenuHD dshd = new MenuHD();
					boolean check = true;
					while (check) {
						dshd.Menu();
						IsValid = false;
						while (!IsValid) {
							try {
								System.out.println("Do you want to return the main menu?? ( y or n )");
								String s = sc.nextLine();
								IsValid = true;
								if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
									check = false;
								}
								if (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n") && !s.equalsIgnoreCase("yes")
										&& !s.equalsIgnoreCase("no")) {
									System.out.println("Lua chon ko hop le!!!");
									IsValid = false;
								}
							} catch (Exception e) {
								System.out.println("Lua chon ko hop le!!!");
								IsValid = false;
							}
						}
					}
				}
					;
					break;

				case 7:
					TKSPDaBan d = new TKSPDaBan();
					d.menu();
					break;
				case 8: {
					System.out.println("|====================! THANK YOU !==================|");
					System.exit(0);
				}
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		MENU A = new MENU();
		A.menuChinh();
	}
}
