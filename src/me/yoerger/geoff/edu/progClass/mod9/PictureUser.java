package me.yoerger.geoff.edu.progClass.mod9;

import java.awt.Color;

import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.bookClasses.ImageFormatException;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;

/**
 * @author yoerggeo000
 * My first attempt at creating an inheiritable class to covers a field.
 */
public class PictureUser {
	/**
	 * As im writing this I realize I made this static,... no wonder it didnt work
	 * (facepalm)
	 * @return A picture gotten from a user.
	 */
	public static Picture getPicture() {
		Picture picture = null;
		try {
			picture = new Picture(FileChooser.pickAFile());
		} catch(ImageFormatException ife) {}//Nope.api
		finally {
			if (picture == null) {
				picture = new Picture(200, 200);
				picture.setAllPixelsToAColor(Color.WHITE);
			}
		}
		return picture;
	}
}
