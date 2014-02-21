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

public class Main {

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
		// TODO Fix this.
		case 61:
			sixOne.main(args);
		case 62:
			sixTwo.main(args);
		case 63:
			sixThree.main(args);
		case 64:
			sixFour.main(args);
		case 65:
			sixFive.main(args);
		case 66:
			sixProject.main(args);
		case 71:
			sevenOne.main(args);
		case 72:
			sevenTwo.main(args);
		case 73:
			sevenThree.main(args);
		case 74:
			sevenFour.main(args);
		case 75:
			sevenFive.main(args);
		case 76:
			sevenProject.main(args);
		case 81:
			eightOne.main(args);
		case 82:
			eightTwo.main(args);
		case 83:
			eightThree.main(args);
		case 84:
			eightFour.main(args);
		case 85:
			eightFive.main(args);
		case 86:
			eightProject.main(args);
		case 91:
			nineOne.main(args);
		case 92:
			nineTwo.main(args);
		case 93:
			nineThree.main(args);
		case 94:
			nineFour.main(args);
		case 95:
			nineFive.main(args);
		case 96:
			nineProject.main(args);
		case 101:
			tenOne.main(args);
		case 102:
			tenTwo.main(args);
		case 103:
			tenThree.main(args);
		case 104:
			tenFour.main(args);
		case 105:
			tenFive.main(args);
		case 106:
			tenProject.main(args);
		default:
			throw new IllegalArgumentException("You inputed the wrong numbers. Please restart.");
		}
	}

}
