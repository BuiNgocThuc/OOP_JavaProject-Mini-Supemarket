package QUANLI_SIEUTHIMINI;

public class TEST {
	private static int n;
	public TEST() {
		n = 3;
	}
	public void inc() {
		n++;
	}
	public static int getN() {
		return n;
	}
	public static void main(String[] args) {
		TEST t1 = new TEST();
		t1.inc();
		t1.inc();
		System.out.println(TEST.getN());
		TEST t2 = new TEST();
		t2.inc();
		System.out.println(TEST.getN());
	}
}
