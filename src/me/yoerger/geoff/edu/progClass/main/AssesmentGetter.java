package me.yoerger.geoff.edu.progClass.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Preconditions;

public class AssesmentGetter {
	public static Class<?> getAssignment(Scanner in) throws Exception {
		System.out.println("Please enter 2 integers for the assignment:");
		
		System.out.println("The module number (6 - 10):");
		int moduleNum = in.nextInt();
		Preconditions.checkArgument(moduleNum >= 6 && moduleNum <= 10, "Module number must be between 6 and 10");
		
		System.out.println("And the assignment number (1 - 6, 6 is the 'Big Idea' and 7 is the module project)");
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
		
		String mainId = "me.yoerger.geoff.edu.progClass.assignments."+ moduleNums.get(moduleNum) + "." + moduleNums.get(moduleNum) + assignmentNums.get(assignmentNum);
		return Class.forName(mainId);
	}
}
