package me.yoerger.geoff.edu.progClass.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out
		        .println("Do you want to:\n"
		                + "1: Run an assignment or \n"
		                + "2: Show the required analysis questions for an assignment or \n"
		                + "3: Do both?");
		String runOrPrint = in.next();
		if (runOrPrint.toLowerCase().matches("r.*|p.*|1.*")) {
			// See if they entered 1, ques, ?, analysis, etc.
			MainRun.main(args);
		} else
			if (runOrPrint.toLowerCase().matches("q.*|2.*|a.*|\\?.*")) {
				// See if they entered 2, program, run, r, prog, etc.
				MainPMR.main(args);
			}
			else {
				MainRun.main(args);
				MainPMR.main(args);
			}
		System.exit(0);
	}
}
