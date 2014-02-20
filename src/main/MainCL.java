package main;

import java.util.Scanner;

import mod7.Range;
import assignments.eight.eightFive;
import assignments.eight.eightFour;
import assignments.eight.eightOne;
import assignments.eight.eightProject;
import assignments.eight.eightThree;
import assignments.eight.eightTwo;
import assignments.nine.nineFive;
import assignments.nine.nineFour;
import assignments.nine.nineOne;
import assignments.nine.nineProject;
import assignments.nine.nineThree;
import assignments.nine.nineTwo;
import assignments.seven.sevenFive;
import assignments.seven.sevenFour;
import assignments.seven.sevenOne;
import assignments.seven.sevenProject;
import assignments.seven.sevenThree;
import assignments.seven.sevenTwo;
import assignments.six.sixFive;
import assignments.six.sixFour;
import assignments.six.sixOne;
import assignments.six.sixProject;
import assignments.six.sixThree;
import assignments.six.sixTwo;
import assignments.ten.tenFive;
import assignments.ten.tenFour;
import assignments.ten.tenOne;
import assignments.ten.tenProject;
import assignments.ten.tenThree;
import assignments.ten.tenTwo;
// Eclipse,.... lol


import com.google.common.base.Preconditions;

public class MainCL {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter 2 integers for the assignment to run:");
		
		System.out.println("The module number (6 - 10):");
		int moduleNum = in.nextInt();
		Preconditions.checkArgument(moduleNum >= 6 && moduleNum <= 10, "Module number must be between 6 and 10");
		
		System.out.println("And the assignment number (1 - 6, 5 is the 'Big Idea' and 6 is the module project)");
		int assignmentNum = in.nextInt();
		Preconditions.checkArgument(assignmentNum >= 1 && assignmentNum <= 6, "Assignment number must be between 1 and 6");

		in.close();
		
		int id = (moduleNum * 10) + assignmentNum;
		
		for(int i : new Range(25).range()) {
			System.out.print("\n");
		}
		
		switch(id) { // I dont want to attempt reflective instantating today.
		// Prepare for lots of repetitive code.
		case 61:
			sixOne.main(args);
			System.exit(0);
		case 62:
			sixTwo.main(args);
			System.exit(0);
		case 63:
			sixThree.main(args);
			System.exit(0);
		case 64:
			sixFour.main(args);
			System.exit(0);
		case 65:
			sixFive.main(args);
			System.exit(0);
		case 66:
			sixProject.main(args);
			System.exit(0);
		case 71:
			sevenOne.main(args);
			System.exit(0);
		case 72:
			sevenTwo.main(args);
			System.exit(0);
		case 73:
			sevenThree.main(args);
			System.exit(0);
		case 74:
			sevenFour.main(args);
			System.exit(0);
		case 75:
			sevenFive.main(args);
			System.exit(0);
		case 76:
			sevenProject.main(args);
			System.exit(0);
		case 81:
			eightOne.main(args);
			System.exit(0);
		case 82:
			eightTwo.main(args);
			System.exit(0);
		case 83:
			eightThree.main(args);
			System.exit(0);
		case 84:
			eightFour.main(args);
			System.exit(0);
		case 85:
			eightFive.main(args);
			System.exit(0);
		case 86:
			eightProject.main(args);
			System.exit(0);
		case 91:
			nineOne.main(args);
			System.exit(0);
		case 92:
			nineTwo.main(args);
			System.exit(0);
		case 93:
			nineThree.main(args);
			System.exit(0);
		case 94:
			nineFour.main(args);
			System.exit(0);
		case 95:
			nineFive.main(args);
			System.exit(0);
		case 96:
			nineProject.main(args);
			System.exit(0);
		case 101:
			tenOne.main(args);
			System.exit(0);
		case 102:
			tenTwo.main(args);
			System.exit(0);
		case 103:
			tenThree.main(args);
			System.exit(0);
		case 104:
			tenFour.main(args);
			System.exit(0);
		case 105:
			tenFive.main(args);
			System.exit(0);
		case 106:
			tenProject.main(args);
			System.exit(0);
		default:
			throw new IllegalArgumentException("You inputed the wrong numbers. Please restart.");
		}
	}

}
