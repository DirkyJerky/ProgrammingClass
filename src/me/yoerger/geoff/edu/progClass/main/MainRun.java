package me.yoerger.geoff.edu.progClass.main;

import java.lang.reflect.Method;

/**
 * Used to run assignments
 * @author yoerggeo000
 */
public class MainRun {

	/**
	 * @param ourArgs
	 * @throws Exception because Theres too much exceptions that can be thrown
	 * 
	 */
	public static void main(String[] ourArgs) throws Exception {
		Class<?> mainClazz;
		if(ourArgs.length <= 1) {
			mainClazz = AssesmentGetter.getAssignment();
		} else {
			mainClazz = AssesmentGetter.getAssignment(
					Integer.valueOf(ourArgs[0]), Integer.valueOf(ourArgs[1]));
		}
		System.out.print("\n\n\n\n\n\n\n\n\n\n"); // Ten new lines
		Method main = mainClazz.getMethod("main", String[].class);
		main.invoke(null, new Object[] { ourArgs }); // Invoke main
	}

}
