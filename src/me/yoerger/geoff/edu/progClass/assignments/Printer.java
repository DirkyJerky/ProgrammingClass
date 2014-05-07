package me.yoerger.geoff.edu.progClass.assignments;

public interface Printer {
	/**
	 * prints o and a newline
	 * @param o What to print
	 */
	public void print(Object o);
	/**
	 * Prints just o
	 * @param o What to print
	 */
	public void printNoLine(Object o);
	/**
	 * Print o with a tab before it
	 * @param o what to print
	 */
	public void printTab(Object o);
	/**
	 * Prints a tab and "-- "
	 * @param o what to print
	 */
	public void printAnswer(Object o);
}
