package me.yoerger.geoff.edu.progClass.mod9;

import java.util.Scanner;

/**
 * @author yoerggeo000
 * Safely close stuff
 */
public class SafeCloser {
	/**
	 * @param scanner CLOSE ME
	 */
	public static void safelyClose(Scanner scanner) {
		if (scanner != null) {
			scanner.close();
		}
	}
}
