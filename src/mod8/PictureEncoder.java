package mod8;

import bookClasses.Picture;
import bookClasses.Pixel;

import com.google.common.base.Preconditions;

public class PictureEncoder {
	/* This encoder uses the red values for each pixel,
	 * and the message is encoded in ascii  wherefor the 
	 * bits are determined by if the red value is even or not.*/
	private Picture picture;
	private String filename;
	
	public PictureEncoder(Picture picture, String filename) {
		this.picture = picture;
		this.filename = filename;
	}
	
	public void normalize() {
		for (Pixel pix : picture.getPixels()) {
			if (pix.getRed() % 2 == 0) {
				continue;
			} else if (pix.getRed() >= 128) {
				pix.setRed(pix.getRed() - 1);
			} else {
				pix.setRed(pix.getRed() + 1);
			}
		}
	}
	
	public void encode(String s) {
		this.normalize();
		String binary = "";
		char[] chars = s.toCharArray();
		for( char charrr : chars) {
			binary += Integer.toBinaryString((int) charrr);
		}
		char[] binaryChars = binary.toCharArray();
		Pixel[] pixels = this.picture.getPixels();
		Preconditions.checkArgument(binaryChars.length < pixels.length, "String to long");
		for(int i = 0; i < binaryChars.length; i++) {
			pixels[i].setRed(pixels[i].getRed() + Integer.valueOf(binaryChars[i]));
		}
		this.picture.write(this.filename);
	}
	public String decode() {
		String binary = "";
		Pixel[] pixels = this.picture.getPixels();
		for(Pixel pix : pixels) {
			binary += String.valueOf(pix.getRed() % 2);
		}
//		for (int i : new Range(8 - (binary.length() % 8)).range()) {
//			binary += "0";
//		}
		String[] bytes = binary.split("(?<=\\G.{8})"); // Split it into equal sections 8 chars long
		String string = "";
		for (String s : bytes) {
			if(s.contains("00000000")) { continue; } // skip if blank
			int k = Integer.valueOf(s, 2); // binary -> code point
			if(Character.isISOControl(k)) { continue; } // Ignore control chars
			char l = (char) k;
			string += String.valueOf(l); // code point -> char +-> string
			
		}
		return string;
	}
}
