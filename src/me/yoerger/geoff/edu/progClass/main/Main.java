package me.yoerger.geoff.edu.progClass.main;

import java.util.Scanner;

/**
 * Prompts the user for which assignment to run / show questions for
 * @author yoerggeo000
 *
 */
public class Main {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if(args.length <= 1) {
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
			} else {
				if (runOrPrint.toLowerCase().matches("q.*|2.*|a.*|\\?.*")) {
					// See if they entered 2, program, run, r, prog, etc.
					MainPMR.main(args);
				}
				else {
					MainRun.main(args);
					MainPMR.main(args);
				}
			}
			in.close();
		} else {
			MainRun.main(args);
		}
		System.exit(0);
	}
}
