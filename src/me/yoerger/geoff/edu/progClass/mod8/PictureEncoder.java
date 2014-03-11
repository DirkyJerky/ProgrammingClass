package me.yoerger.geoff.edu.progClass.mod8;

import java.io.File;

import sun.awt.image.ImageFormatException;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;

public class PictureEncoder {
	/* This encoder uses the red values for each pixel,
	 * and the message is encoded in ascii, wherefore the value of the 
	 * red pixel in the top row is the message.*/
	private Picture picture;
	private String filename;
	private Pixel[] topRow;
	
	public PictureEncoder(String filename) throws ImageFormatException {
		this.filename = filename;
		if(new File(filename).canWrite()) {
			this.picture = new Picture(filename);
		} else {
			throw new IllegalArgumentException("Picture must be writeable.");
		}
		this.topRow = new Pixel[this.picture.getWidth()];
		for(int i = 0; i < this.picture.getWidth(); i++) {
			this.topRow[i] = this.picture.getPixel(i, 0);
		}
	}
	
	public void encode(String message) {
		char[] msgChars = message.toCharArray();
		for(int i = 0; i < this.topRow.length; i++) { 
			if(i < message.length()) {
				this.topRow[i].setRed(Character.codePointAt(msgChars, i)); // Cast to int char values, etc " " => 32
			} else {
				this.topRow[i].setRed(0); // Otherwise clear the rest of the row.
			}
		}
		this.picture.write(this.filename);
	}
	public String decode() {
		StringBuilder message = new StringBuilder("");
		for(int i = 0; i < this.topRow.length; i++) { 
			if (this.topRow[i].getRed() >= 32) {
				message.append(Character.toChars(this.topRow[i].getRed()));
			}
		}
		return message.toString();
		
	}
}
