package assignments.six;
import java.text.DecimalFormat;

import assignments.Analysis;
import assignments.Printer;
import mod6.UsedCar;

public class sixThree implements Analysis{

	public static void main(String[] args) {
		
		float gasPrice = 3.99F;
		DecimalFormat df = new DecimalFormat("###.##");
		UsedCar dadCar = new UsedCar("2011 Toyota Prius-V", 200, 1000);
		UsedCar momCar = new UsedCar("2011 Toyota Corola", 50, 1000);
		print("Name\t\t\t MPG\t Monthly Miles\tMonthly Gallons\t\tMonthly Cost"); //Format chart
		print("");
		printCarInfo(dadCar, gasPrice);
		printCarInfo(momCar, gasPrice);
		print("");
		print("Monthly Cost Difference: " + df.format(momCar.costDif(dadCar, gasPrice)));
		print("(The " + (momCar.milesPerMonth / momCar.milesPerGallon < dadCar.milesPerMonth / dadCar.milesPerGallon ? momCar.name : dadCar.name) + " is cheaper)");
	}
	private static void print(Object s) { // Yay lazy methods
		System.out.println(s);
	};
	private static void printCarInfo(UsedCar car, float Gas) {
		StringBuilder sb = new StringBuilder();
		appendTab(car.fullName(), sb);
		appendTab(car.milesPerGallon, sb);
		appendTab(car.milesPerMonth, sb);
		sb.append("\t"); //Format chart
		float monthlyGallons = car.milesPerMonth / car.milesPerGallon;
		appendTab(monthlyGallons, sb);
		sb.append("\t\t"); //Format chart
		appendTab(monthlyGallons * Gas, sb);
		print(sb.toString());
		
		
		
	};
	private static void appendTab(Object s, StringBuilder sb) {
		sb.append(s);
		sb.append("\t ");
	}
	@Override
	public void printQuestions(Printer p) {
		p.print("Describe the main point of this assignment. (Required)");
		p.printTab("Find differences in 2 cars MPG and cost per month");
		
		p.print("Discuss how this assignment relates to a real-life situation. (Required)");
		p.printTab("This could be used in marketing to show how a different brand of car is better thajn another");
		
		p.print("Reflect on your growth as a programmer. (Required)");
		p.printTab("I practiced how to make an abstract type and make a non-abstract model out of it.");
		
		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printTab("My lazzieness and typeing, hence the 'private static void appendTab(Object s, StringBuilder sb)' ");
		
		p.print("Describe at least one thing that will be done differently in the future.");
		p.printTab("Find ouy how to easily format a chart in the console.");
		
		p.print("Suggest how this assignment could be extended.");
		p.printTab("Show the results in a JFrame");
		
		p.print("How could the formatting of the output be improved?");
		p.printTab("Show the results in a JFrame");
		
		p.print("What question(s) of your own did you answer while writing this program?");
		p.printTab("Whats the best was to use abstract classes");
		
		p.print("What unanswered question(s) do you have after writing this program?");
		p.printTab("Ive seen that abstract classes can be instantaded, how?");
		
		
	};

}
