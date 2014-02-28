package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to:\n"
				+ "1: Run an assignment or \n"
				+ "2: Show the required analysis questions for an assignment?");
		String runOrPrint = in.next();
		Thread.sleep(1000); // Timeout a little
		if (runOrPrint.toLowerCase().matches("r.*|p.*|1.*") || runOrPrint.trim().length() == 0) { // See if they entered 1, ques, ?, analysis, etc.
			MainRun.main(args);
		} else if (runOrPrint.toLowerCase().matches("q.*|2.*|a.*|\\?.*")) { // See if they entered 2, program, run, r, prog, etc.
			MainPMR.main(args);
		}
		in.close();
	}
}
