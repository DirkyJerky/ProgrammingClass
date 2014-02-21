package mod8;

public class DecoderTester {

	public static void main(String[] args) {
		String bits = Integer.toBinaryString((int) '2');
		int intt = Integer.valueOf(bits, 2);
		System.out.print((char) intt);
		
	}

}
