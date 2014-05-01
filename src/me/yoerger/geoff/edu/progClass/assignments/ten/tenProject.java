package me.yoerger.geoff.edu.progClass.assignments.ten;

import org.junit.runners.JUnit4;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;

/**
 * Project for module 10
 *
 */
public class tenProject implements Analysis{

	public static void main(String[] args) {
		System.out.println(JUnit4.class.getMethods());
		
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
		
		
	}
}
