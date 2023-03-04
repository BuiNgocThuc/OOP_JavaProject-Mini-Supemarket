package QUANLI_SIEUTHIMINI;

public class IDUtil {
	enum TypePeople {
		QUANLY, NV_BANHANG, KH_THANTHIET, KH_THUONG, NHACUNGCAP
	}

	enum TypeObject {
		KHANGIAY, DAOCAORAU, DODONGHOP, DOCHEBIEN, NUOCCOGAS, NUOCCOCON, PHIEUNHAP, HOADON
	}

	public static String randomeID(TypePeople type) {
		if (type == TypePeople.NV_BANHANG) {
			return "NV" + String.valueOf(DSNhanVien.countNV);
		} else if (type == TypePeople.QUANLY) {
			return "QL" + String.valueOf(DSNhanVien.countQL);
		} else if (type == TypePeople.KH_THANTHIET) {
			return "VIP" + String.valueOf(DSKhachHang.countVIP);
		} else if (type == TypePeople.KH_THUONG) {
			return "NOR" + String.valueOf(DSKhachHang.countNOR);
		} else if (type == TypePeople.NHACUNGCAP) {
			return "NCC" + String.valueOf(DSNhaCungCap.countNCC);
		}
		return String.valueOf(System.currentTimeMillis());
	}

	public static String randomeID(TypeObject type) {
//		if (type == TypeObject.DAOCAORAU) {
//			return "DCR" + String.valueOf(DSHangHoa.h.size() + 1);
//		} else if (type == TypeObject.KHANGIAY) {
//			return "KG" + String.valueOf(DSHangHoa.h.size() + 1);
//		} else if (type == TypeObject.DOCHEBIEN) {
//			return "CB" + String.valueOf(DSHangHoa.h.size() + 1);
//		} else if (type == TypeObject.DODONGHOP) {
//			return "DH" + String.valueOf(DSHangHoa.h.size() + 1);
//		} else if (type == TypeObject.NUOCCOGAS) {
//			return "CG" + String.valueOf(DSHangHoa.h.size() + 1);
//		} else if (type == TypeObject.NUOCCOCON) {
//			return "CC" + String.valueOf(DSHangHoa.h.size() + 1);
		if (type == TypeObject.PHIEUNHAP) {
			return "PN" + String.valueOf(DSPhieuNhap.dspn.size() + 1);
		} else if (type == TypeObject.HOADON) {
			return "HD" + String.valueOf(DSHoaDon.dshd.size() + 1);
		}
		return String.valueOf(System.currentTimeMillis());
	}

}
