package QUANLI_SIEUTHIMINI;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TKSPDaBan {
	private String id;
	private String name;
	private int quantity;

	Scanner sc = new Scanner(System.in);

	public TKSPDaBan() {

	}

	public TKSPDaBan(String id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void statistic(String start, String from) {
		HashMap<String, Integer> cthd = getCTHD(start, from);
		ArrayList<TKSPDaBan> tkdb = new ArrayList<>();
		for (HANGHOA product : DSHangHoa.h) {
			String id = product.getMaHH();
			String name = product.getTenHH();
			if (cthd.containsKey(product.getMaHH())) {
				tkdb.add(new TKSPDaBan(id, name, cthd.get(product.getMaHH())));
			}
		}
		System.out.println(" _______________________________________________ ");
		String out1 = String.format("|%-15s|%-15s|%-15s", "MA HANG HOA", "TEN HANG HOA", "SO LUONG");
		System.out.println(out1);
		for (TKSPDaBan tk : tkdb) {
			tk.output();
		}

	}

	private boolean isDateValid(String start, String end) {
		boolean isValid = false;
		if (start.matches(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
				&& end.matches(
						"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
			Date startDate = convertStringToDate(start);
			Date endDate = convertStringToDate(end);
			if (startDate.before(endDate)) {
				isValid = true;
			}
		}
		return isValid;
	}

	public void statisticProfit(String start, String end) {

		try {
			int sum = 0;
			Date startDate = convertStringToDate(start);
			Date endDate = convertStringToDate(end);
			for (HOADON h : DSHoaDon.dshd) {
				Date startHd = convertStringToDate(h.getNgaynhap());
				if ((startDate != null && endDate != null) && (startHd.after(startDate) && startHd.before(endDate))) {
					sum += h.gettongTien();
				}
			}
			DecimalFormat formatter = new DecimalFormat("###,###,###.##");
			System.out.println(
					"Tong Doanh thu tu ngay " + start + " den ngay " + end + " : " + formatter.format(sum) + " VND");
		} catch (Exception e) {
			System.out.println("Error!!");
		}

	}

	public void menu() {
		Boolean isValid = false;
		int option;
		while (!isValid) {
			option = 0;
			System.out.println("\n|--------------------------Nhap lua chon--------------------------|");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("|1.THONG KE SO LUONG SAN PHAM DA BAN TRONG KHOANG THOI GIAN         |");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("|2.THONG KE DOANH THU TRONG KHOANG THOI GIAN                        |");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("|3.Thoat                                                            |");
			System.out.println("--------------------------------------------------------------------|");
			try {
				System.out.println("Nhao lua chon");
				option = Integer.parseInt(sc.next());
				if (option < 1 || option > 3) {
					System.out.println("Sai Cu Phap");
				}
			} catch (Exception e) {
				System.out.println("Sai Cu Phap");
			}
			sc.nextLine();
			if (option >= 1 && option <= 3) {
				String startDate, endDate;
				switch (option) {
				case 1:
					System.out.println("Nhap ngay bat dau: ");
					startDate = sc.nextLine();
					System.out.println("Nhap ngay ket thuc: ");
					endDate = sc.nextLine();
					while (!isDateValid(startDate, endDate)) {
						System.out.println("Khoang thoi gian khong hop le vui long nhap lai");
						System.out.println("Nhap ngay bat dau: ");
						startDate = sc.nextLine();
						System.out.println("Nhap ngay ket thuc: ");
						endDate = sc.nextLine();
					}
					statistic(startDate, endDate);
					break;
				case 2:
					System.out.println("Nhap ngay bat dau: ");
					startDate = sc.nextLine();
					System.out.println("Nhap ngay ket thuc: ");
					endDate = sc.nextLine();
					while (!isDateValid(startDate, endDate)) {
						System.out.println("Khoang thoi gian khong hop le vui long nhap lai");
						System.out.println("Nhap ngay bat dau: ");
						startDate = sc.nextLine();
						System.out.println("Nhap ngay ket thuc: ");
						endDate = sc.nextLine();
					}
					statisticProfit(startDate, endDate);
					break;
				case 3:
					isValid = true;
					break;
				}
			}
		}
	}

	public HashMap<String, Integer> getCTHD(String start, String end) {
		HashSet<String> id = new HashSet<>();
		HashMap<String, Integer> cthdId = new HashMap<>();

		try {
			Date startDate = convertStringToDate(start);
			Date endDate = convertStringToDate(end);
			for (HOADON h : DSHoaDon.dshd) {
				Date startHd = convertStringToDate(h.getNgaynhap());
				if ((startDate != null && endDate != null) && (startHd.after(startDate) && startHd.before(endDate))) {
					id.add(h.getMaHD());
				}
			}
			for (String itemId : id) {
				for (int i = 0; i < DSChiTietHD.cthd.size(); i++) {
					if (itemId.equals(DSChiTietHD.cthd.get(i).getMaHD())) {
						int newQuantity = DSChiTietHD.cthd.get(i).getSoluong();
						if (cthdId.containsKey(DSChiTietHD.cthd.get(i).getMaHH())) {
							int oldQuantity = cthdId.get(DSChiTietHD.cthd.get(i).getMaHH());
							cthdId.put(DSChiTietHD.cthd.get(i).getMaHH(), newQuantity + oldQuantity);
						} else {
							cthdId.put(DSChiTietHD.cthd.get(i).getMaHH(), newQuantity);
						}
					}
				}
			}

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return cthdId;
	}

	private Date convertStringToDate(String date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (Exception ex) {
			return null;
		}
	}

	public void output() {
		System.out.println(
				"|---------------|---------------|---------------|");
		String out2 = String.format("|%-15s|%-15s|%-15d|", id, name, quantity);
		System.out.println(out2);

	}

	@Override
	public String toString() {
		return "TKSPDaBan [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}

	public static void main(String[] args) {

	}
}
