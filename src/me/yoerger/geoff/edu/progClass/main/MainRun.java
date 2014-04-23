package me.yoerger.geoff.edu.progClass.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Used to run assignments
 * @author yoerggeo000
 */
public class MainRun {

	/**
	 * @param ourArgs
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 * 
	 */
	public static void main(String[] ourArgs) throws Exception {
		if(ourArgs.length == 0) {
		Scanner in = new Scanner(System.in);
		Class<?> mainClazz = AssesmentGetter.getAssignment(in);

		 System.out.print("\n\n\n\n\n\n\n\n\n\n"); // Ten new lines
		// if(shouldRun) {
		Method main = mainClazz.getMethod("main", String[].class);
		main.invoke(null, new Object[] { ourArgs }); // Invoke main
		Thread.sleep(5000); // Wait 5 seconds TODO Fix this so the assignment control the waiting
		}
		// } else {
		// try {
		// Printer printer = new Printer();
		// Method printQuestions = mainClazz.getMethod("printQuestions",
		// Printer.class);
		// printQuestions.invoke(mainClazz.newInstance(), new Object[] { printer
		// });
		// } catch (NoSuchMethodException nsme) {
		// System.out.println("No analysis questions present in class " +
		// mainClazz.getName());
		// }
		// }
	}

}
