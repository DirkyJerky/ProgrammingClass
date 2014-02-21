package mod8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bookClasses.Picture;
import bookClasses.Pixel;

public class PictureEncoder {
	/* This encoder uses the red values for each pixel,
	 * and the message is encoded in ascii  wherefor the 
	 * bits are determined by if the red value is even or not.*/
	private Picture picture;
	
	public PictureEncoder(Picture picture) {
		this.picture = picture;
	}
	
	public void normalize() {
		for (Pixel pix : picture.getPixels()) {
			if (pix.getRed() % 2 == 0) {
				continue;
			}
			if (pix.getRed() >= Byte.MAX_VALUE / 2) {
				pix.setRed(pix.getRed() - 1);
			} else {
				pix.setRed(pix.getRed() + 1);
			}
		}
	}
	
	public void encode(String s) {
		this.normalize();
	}
	public String decode() {
		int pixels = this.picture.getPixels().length;
		int loops = (pixels / 8) - pixels % 8;
		char[] chars = new char[loops];
		for (int i = 0; i < loops; i += 8) {
			int[] bits = new int[8];
			for ( int j = 0; j < 8; j++) {
				Pixel pixx = this.picture.getPixels()[i * 8 + j];
				bits[bits.length] = pixx.getRed() % 2;
			}
			chars[chars.length] =  (char) ((char) bits[0] * Math.pow(2, 0) + bits[1] * Math.pow(2, 1) + bits[2] * Math.pow(2, 2) + bits[3] * Math.pow(2, 3) + bits[4] * Math.pow(2, 4) + bits[5] * Math.pow(2, 5) + bits[6] * Math.pow(2, 6) + bits[7] * Math.pow(2, 7));
		}
		return new String(chars);
	}
}
