package me.yoerger.geoff.edu.progClass.main;

import java.util.Scanner;

/**
 * Prompts the user for which assignment to run / show questions for
 * @author yoerggeo000
 *
 */
public class Main {
	// See if they entered 2, program, run, r, prog, etc.
	public final static String PMRRegex = "r.*|p.*|1.*|\\!.*";
	// See if they entered 1, ques, ?, analysis, etc.
	public final static String RunRegex = "q.*|2.*|a.*|\\?.*";
	// See if they entered both, 3, ".", etc
	public final static String BothRegex = "b.*|3.*|\\..*";
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if(args.length <= 2) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out
		        .println("Do you want to:\n"
		                + "1: Run an assignment or \n"
		                + "2: Show the required analysis questions for an assignment or \n"
		                + "3: Do both?");
			String runOrPrint = in.next();
			runOrPrint = runOrPrint.toLowerCase();
			if (runOrPrint.matches(PMRRegex)) {
				MainRun.main(args);
			} else {
				if (runOrPrint.matches(RunRegex)) {
					MainPMR.main(args);
				} else if(runOrPrint.matches(BothRegex)) {
					MainRun.main(args);
					System.out.println("\n"
							+ "----- Analysis Questions -----"
							+ "\n");
					MainPMR.main(args);
				} else {
					throw new IllegalArgumentException("Invalid paramaters for "
							+ "assignment running");
				}
			}
		} else {
			String[] newArgs = new String[] { args[1], args[2] };
			if (args[0].matches(RunRegex)) {
				MainRun.main(newArgs);
			} else if (args[0].matches(PMRRegex)) {
				MainPMR.main(newArgs);
			} else if(args[0].matches(BothRegex)) {
				MainRun.main(newArgs);
				System.out.println("\n\n"
						+ "----- Analysis Questions -----" + "\n");
				MainPMR.main(newArgs);
			} else {
				throw new IllegalArgumentException("Invalid paramaters for "
						+ "assignment running");
			}
		}
		if((args.length >= 4) && ((args[3].charAt(0) == 'e') || (args[3].charAt(0) == 'E'))) {
			System.exit(0);
		}
	}
}
