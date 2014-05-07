package me.yoerger.geoff.edu.progClass.main;

import java.util.Scanner;

public class RunAll {

	public static void main(String[] args) throws Exception {
		boolean run = false, pmr = false;
		int timeout = 1000;
		if(args.length >= 2) {
			timeout = Integer.valueOf(args[1]);
		}
		String runOrPrint = null;
		if(args.length == 0) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out
				.println("Do you want to:\n"
						+ "1: Run an assignment or \n"
						+ "2: Show the required analysis questions for an assignment or \n"
						+ "3: Do both?");
			runOrPrint = in.next();
			runOrPrint = runOrPrint.toLowerCase();
		}
		if(runOrPrint == null) {
			runOrPrint = args[0];
		}
		
		if(runOrPrint.matches(Main.RunRegex)) {
			run = true;
		} else if(runOrPrint.matches(Main.PMRRegex)){
			pmr = true;
		} else if(!(runOrPrint.matches(Main.BothRegex))){
			throw new IllegalArgumentException("Invalid option");
		}
		for(int module = 6; module <= 10; module++) {
			for(int assignment = 1; assignment <= 7; assignment++) {
				String modN = String.valueOf(module);
				String assignN = String.valueOf(assignment);
				System.out.printf("\n----- Assignment %d.%d:\n", module, assignment);
				try {
					if(run) {
						Main.main(new String[] {"1", modN, assignN});
					} else if(pmr) {
						Main.main(new String[] {"2", modN, assignN});
					} else {
						Main.main(new String[] {"3", modN, assignN});
					}
				} catch(Exception e) {
					System.err.printf("----- ERROR: Assignment %d.%d:\n", module, assignment);
					e.printStackTrace();
					System.err.println("-----");
				}
				if(timeout != 0)
					Thread.sleep(timeout);
			}
		}
	}

}
