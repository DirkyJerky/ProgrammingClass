package me.yoerger.geoff.edu.progClass.mod8;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Utility class used for encoding Pictures with hidden messages
 * @author yoerggeo000
 * @since Module 8
 */
public class PictureEncoder {
	/* This encoder uses the red values for each pixel,
	 * and the message is encoded in ascii, wherefore the value of the 
	 * red pixel in the top row is the message.*/
	private BufferedImage picture;
	private File filename;
	private int width;
	
	/**
	 * @param filename The location of the picture in question
	 * @throws IOException If the file is not an image
	 */
	public PictureEncoder(String filename) throws IOException {
		this.filename = new File(filename);
		if(this.filename.canWrite()) {
			this.picture = ImageIO.read(this.filename);
		} else {
			throw new IllegalArgumentException("Picture must be writeable.");
		}
		this.width = this.picture.getWidth();
	}
	
	/**
	 * @param message The message to encode into the picture
	 * @throws IOException If bad stuff happens when writing to file.
	 */
	public void encode(String message) throws IOException {
		char[] msgChars = message.toCharArray();
		for(int i = 0; i < this.width; i++) { 
			if(i < message.length()) {
				this.picture.setRGB(i, 0, (int) msgChars[i]);
			} else {
				this.picture.setRGB(i, 0, 0); // Set to nothing
			}
		}
		if(this.filename.getAbsolutePath().endsWith(".png")) {
			ImageIO.write(this.picture, "png", this.filename);
		} else {
			ImageIO.write(this.picture, "png", new File(this.filename.getAbsolutePath() + ".png"));
		}
	}
	/**
	 * @return The message that has been encoded into the picture
	 */
	public String decode() {
		StringBuilder message = new StringBuilder();
		long RBG;
		for(int i = 0; i < this.width; i++) {
			RBG = this.picture.getRGB(i, 0);
			//System.err.printf("You are at pixel %d, 0; RBG is %d\n", i, RBG);
			if (RBG >= 32 && RBG < 127) {
				message.append((char) RBG);
			} else {
				RBG = Math.abs(-16777216 - RBG);
				if (RBG >= 32 && RBG < 127) {
					message.append((char) RBG);
				}
			}
		}
		return message.toString();
		
	}
}
