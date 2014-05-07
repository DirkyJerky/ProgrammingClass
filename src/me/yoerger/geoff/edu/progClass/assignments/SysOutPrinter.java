package me.yoerger.geoff.edu.progClass.assignments;

/**
 * Used to simplify printing the questions and answers,
 * And if necessary change where it prints to.
 * Currently uses System.out
 * @author yoerggeo000
 * @since Module 8
 */
public class SysOutPrinter implements Printer{
	/**
	 * prints o and a newline
	 * @param o What to print
	 */
	public void print(Object o) {
		System.out.println(o);
	}
	/**
	 * Prints just o
	 * @param o What to print
	 */
	public void printNoLine(Object o) {
		System.out.print(o);
	}
	/**
	 * Print o with a tab before it
	 * @param o what to print
	 */
	public void printTab(Object o) {
		this.printNoLine("\t");
		this.print(o);
	}
	/**
	 * Prints a tab and "-- "
	 * @param o what to print
	 */
	public void printAnswer(Object o) {
		this.printTab("-- " + o);
		this.print("\n");
	}
}
