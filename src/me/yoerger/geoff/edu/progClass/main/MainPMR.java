package me.yoerger.geoff.edu.progClass.main;

import java.lang.reflect.Method;
import java.util.Scanner;

import me.yoerger.geoff.edu.progClass.assignments.Printer;

public class MainPMR {

	public static void main(String[] ourArgs) throws Exception {
		Scanner in = new Scanner(System.in);
		Class<?> mainClazz = AssesmentGetter.getAssignment(in);

		System.out.print("\n\n\n\n\n\n\n\n\n\n"); // Ten new lines
//		if(shouldRun) {
//			Method main = mainClazz.getMethod("main", String[].class);
//			main.invoke(null, new Object[] { ourArgs }); // Invoke me.yoerger.geoff.edu.progClass.main
//			Thread.sleep(10000); // Wait 10 seconds
//		} else {
			try {
				Printer printer = new Printer();
				Method printQuestions = mainClazz.getMethod("printQuestions", Printer.class);
				printQuestions.invoke(mainClazz.newInstance(), new Object[] { printer });
			} catch (NoSuchMethodException nsme) {
				System.out.println("No analysis questions present in class " + mainClazz.getName());
			}
//		}
		System.exit(0); // Terminate and cleanup
	}

}
