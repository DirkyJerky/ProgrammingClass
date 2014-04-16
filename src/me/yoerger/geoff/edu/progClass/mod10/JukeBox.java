package me.yoerger.geoff.edu.progClass.mod10;

import me.yoerger.geoff.edu.progClass.bookClasses.SimpleInput;

public class JukeBox {
	private String[] playList;
	@SuppressWarnings("unused")
	private String[] fileList;

	public JukeBox(String[] playList, String[] fileList) {
		this.playList = playList;
		this.fileList = fileList;
	}

	public int displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Please select a song by entering a number\n");
		sb.append("Your choices are:");
		sb.append("\n 0: " + playList[0]);
		sb.append("\n 1: " + playList[1]);
		sb.append("\n 2: " + playList[2]);
		return SimpleInput.getIntNumber(sb.toString(), 0, 2);
	}

	public void playSong(int choice) {
		// TODO Auto-generated method stub
		
	}

}
