package me.yoerger.geoff.edu.progClass.bookClasses;

public class ImageFormatException extends Exception {

	private static final long serialVersionUID = 5350372729124538025L;
	
	public ImageFormatException(String eMessage) {
		super(eMessage);
	}
	public ImageFormatException(String eMessage, Throwable cause) {
		super(eMessage, cause);
	}
	

}
