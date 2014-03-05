package me.yoerger.geoff.edu.progClass.mod9;

import java.util.Scanner;

public class SafeCloser {
	public static void safelyClose(Scanner scanner) {
		if (scanner != null) {
			scanner.close();
		}
	}
}
