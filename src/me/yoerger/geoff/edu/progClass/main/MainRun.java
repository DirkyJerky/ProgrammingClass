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
		Class<?> mainClazz = AssesmentGetter.getAssignmentFromCLArgs(ourArgs);
		Method main = mainClazz.getMethod("main", String[].class);
		main.invoke(null, new Object[] { ourArgs }); // Invoke main
	}

}
