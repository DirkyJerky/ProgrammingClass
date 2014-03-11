package me.yoerger.geoff.edu.progClass.mod8;

import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;
import sun.awt.image.ImageFormatException;

public class Grayscale {

	public static String grayscale(final String file)
			throws ImageFormatException {
		if ((file == null) || !file.matches(".*\\.jpe?g")) {
			throw new IllegalArgumentException("file must be a picture.");
		}
		String[] fileWOext = file.split("\\.jpe?g");
		Picture thisPic = new Picture(file);
		for (Pixel pixel : thisPic.getPixels()) {
			int average = (pixel.getBlue() + pixel.getRed() + pixel.getBlue()) / 3;
			pixel.setBlue(average);
			pixel.setRed(average);
			pixel.setGreen(average);
		}
		thisPic.write(fileWOext[0] + "_grayscale.jpg");
		return fileWOext[0] + "_grayscale.jpg";
	}

}
