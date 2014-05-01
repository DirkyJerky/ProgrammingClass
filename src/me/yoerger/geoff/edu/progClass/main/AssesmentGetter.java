package me.yoerger.geoff.edu.progClass.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Preconditions;

/**
 * Prompt for an assignment number and check that its a valid one
 * @author yoerggeo000
 *
 */
public class AssesmentGetter {

	private static Map<Integer, String> moduleNums = new HashMap<>();
	private static Map<Integer, String> assignmentNums = new HashMap<>();
	static {
		moduleNums.put(6, "six");
		moduleNums.put(7, "seven");
		moduleNums.put(8, "eight");
		moduleNums.put(9, "nine");
		moduleNums.put(10, "ten");
		assignmentNums.put(1, "One");
		assignmentNums.put(2, "Two");
		assignmentNums.put(3, "Three");
		assignmentNums.put(4, "Four");
		assignmentNums.put(5, "Five");
		assignmentNums.put(6, "Six");
		assignmentNums.put(7, "Project");
	}
	/**
	 * @param in a Scanner
	 * @return THe class for the assignment number prompted for
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("resource")
	public static Class<?> getAssignment() throws ClassNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter 2 integers for the assignment:");
		
		System.out.println("The module number (6 - 10):");
		int moduleNum = in.nextInt();
		Preconditions.checkArgument(moduleNum >= 6 && moduleNum <= 10, "Module number must be between 6 and 10");
		
		System.out.println("And the assignment number (1 - 7, 6 is the 'Big Idea' and 7 is the module project)");
		int assignmentNum = in.nextInt();
		Preconditions.checkArgument(assignmentNum >= 1 && assignmentNum <= 7, "Assignment number must be between 1 and 7");


		System.out.print("\n\n\n\n\n\n\n\n\n\n"); // Ten new lines
		
		String mainId = 
					"me.yoerger.geoff.edu.progClass.assignments."
					+ moduleNums.get(moduleNum)
					+ "." 
					+ moduleNums.get(moduleNum) 
					+ assignmentNums.get(assignmentNum);
		return Class.forName(mainId);
	}
	public static Class<?> getAssignment(int module, int assignment) throws ClassNotFoundException {
		Preconditions.checkArgument(module >= 6 && module <= 10, "Module number must be between 6 and 10");
		Preconditions.checkArgument(assignment >= 1 && assignment <= 7, "Assignment number must be between 1 and 7");

		
		String mainId = 
					"me.yoerger.geoff.edu.progClass.assignments."
					+ moduleNums.get(module)
					+ "." 
					+ moduleNums.get(module) 
					+ assignmentNums.get(assignment);
		return Class.forName(mainId);
	}
}
