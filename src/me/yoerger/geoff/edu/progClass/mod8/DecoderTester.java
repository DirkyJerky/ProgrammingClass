package me.yoerger.geoff.edu.progClass.mod8;

/**
 * @author yoerggeo000
 * @deprecated Dont know why I made this
 */
@Deprecated
public class DecoderTester {

	public static void main(String[] args) {
		String bits = Integer.toBinaryString((int) '2');
		int intt = Integer.valueOf(bits, 2);
		System.out.print((char) intt);
		
	}

}
