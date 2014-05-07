package me.yoerger.geoff.edu.progClass.main;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.assignments.SysOutPrinter;

/**
 * Used to show PMR questions of an assignment
 * @author yoerggeo000
 *
 */
public class MainPMR {

	public static void main(String[] ourArgs) throws Exception {
		Class<?> mainClazz = AssesmentGetter.getAssignmentFromCLArgs(ourArgs);
		
		try {
			Printer printer = new SysOutPrinter();
			Method printQuestions = mainClazz.getMethod("printQuestions", Printer.class);
			printQuestions.invoke(mainClazz.newInstance(), new Object[] { printer });
		} catch (NoSuchMethodException nsme) {
			throw new IllegalClassFormatException("No analysis questions present in class " + mainClazz.getName());
		}
	}

}
