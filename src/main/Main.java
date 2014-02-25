package main;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import mod7.Range;

import com.google.common.base.Preconditions;
// Eclipse,.... lol

public class Main {

	public static void main(String[] ourArgs) throws Exception {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter 2 integers for the assignment to run:");
		
		System.out.println("The module number (6 - 10):");
		int moduleNum = in.nextInt();
		Preconditions.checkArgument(moduleNum >= 6 && moduleNum <= 10, "Module number must be between 6 and 10");
		
		System.out.println("And the assignment number (1 - 6, 5 is the 'Big Idea' and 6 is the module project)");
		int assignmentNum = in.nextInt();
		Preconditions.checkArgument(assignmentNum >= 1 && assignmentNum <= 6, "Assignment number must be between 1 and 6");

		in.close();
		
		Map<Integer, String> moduleNums = new HashMap<>();
		Map<Integer, String> assignmentNums = new HashMap<>();
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
		String mainId = "assignments."+ moduleNums.get(moduleNum) + "." + moduleNums.get(moduleNum) + assignmentNums.get(assignmentNum);
		
		
		Class<?> mainClazz = Class.forName(mainId);
		Method main = mainClazz.getMethod("main", String[].class);
		
		
		for(@SuppressWarnings("unused") int unused : new Range(25).range()) {
			System.out.print("\n");
		}
		main.invoke(null, new Object[] { ourArgs });
		Thread.sleep(10000);
		System.exit(0);
		
	}

}
