package me.yoerger.geoff.edu.progClass.mod10;

import java.io.File;

import me.yoerger.geoff.edu.progClass.bookClasses.SimpleInput;
import me.yoerger.geoff.edu.progClass.bookClasses.Sound;

/**
 * Used for {@link me.yoerger.geoff.edu.progClass.assignments.ten.tenThree}
 * @author yoerggeo000
 * @since Apr 17, 2014
 *
 */
public class JukeBox {
	private String[] playList;
	private File[] fileList;

	/**
	 * @param playList Info about the songs
	 * @param fileList Location in the file system of the songs
	 */
	public JukeBox(String[] playList, File[] fileList) {
		this.playList = playList;
		this.fileList = fileList;
	}

	/**
	 * @return The choice
	 */
	public int displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Please select a song by entering a number\n");
		sb.append("Your choices are:");
		sb.append("\n 0: " + playList[0]);
		sb.append("\n 1: " + playList[1]);
		sb.append("\n 2: " + playList[2]);
		return SimpleInput.getIntNumber(sb.toString(), 0, 2);
	}

	/**
	 * @param choice The song to play
	 */
	public void playSong(int choice) {
		Sound song = new Sound(fileList[choice].getAbsolutePath());
		song.play();
		
	}

}
