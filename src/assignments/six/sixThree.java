package assignments.six;
import java.text.DecimalFormat;

import mod6.UsedCar;

public class sixThree {

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
	};

}
