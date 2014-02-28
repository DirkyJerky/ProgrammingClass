package me.yoerger.geoff.edu.progClass.assignments;

public class Printer {
	public void print(Object o) {
		System.out.println(o);
	}
	public void printNoLine(Object o) {
		System.out.print(o);
	}
	public void printTab(Object o) {
		this.printNoLine("\t");
		this.print(o);
	}
	public void printAnswer(Object o) {
		this.printTab("-- " + o);
		this.print("\n");
	}
}
