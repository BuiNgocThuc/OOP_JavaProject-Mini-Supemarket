package QUANLI_SIEUTHIMINI;

import java.util.Scanner;

abstract class HANGHOA {
	protected String MaHH, TenHH, LoaiHH, purpose;
	protected int Gia;
    protected int SL;
	Scanner sc = new Scanner(System.in);

	public HANGHOA() {
		MaHH = null;
		TenHH = null;
		Gia = 0;
		LoaiHH = null;
		SL = 0;
	}
	
	
	public HANGHOA(String maHH, String tenHH, String loaiHH, String purpose, int gia, int SL) {
		MaHH = maHH;
		TenHH = tenHH;
		LoaiHH = loaiHH;
		this.purpose = purpose;
		Gia = gia;
		this.SL = SL;
	}


	public String getMaHH() {
		return MaHH;
	}

	public void setMaHH(String maHH) {
		MaHH = maHH;
	}

	public String getTenHH() {
		return TenHH;
	}

	public void setTenHH(String tenHH) {
		TenHH = tenHH;
	}

	public int getGia() {
		return Gia;
	}

	public void setGia(int gia) {
		Gia = gia;
	}

	public String getLoaiHH() {
		return LoaiHH;
	}

	public void setLoaiHH(String loaiHH) {
		LoaiHH = loaiHH;
	}

	
	public int getSL() {
		return SL;
	}


	public void setSL(int sL) {
		SL = sL;
	}

	public void Xuat() {
		System.out.println(
				"|--------------------|--------------------|--------------------|--------------------|--------------------|--------------------|");
		
		String out1 = String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|", MaHH, TenHH, LoaiHH, purpose, Gia, SL);
		System.out.println(out1);
	}

	abstract void mucDichTieuThu();
	
	

	@Override
	public String toString() {
		return  MaHH + ";" + TenHH + ";" + LoaiHH + ";" + purpose + ";"
				+ Gia + ";" + SL;
	}


	public static void main(String[] args) {
		
	}
}
