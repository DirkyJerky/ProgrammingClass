package me.yoerger.geoff.edu.progClass.assignments.nine;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod9.RetrieveData;

public class nineFive implements Analysis {

	public static void main(String[] args) {
		// String urlString =
		// "http://www.weather.gov/view/prodsByState.php?state=FL&prodtype=climate";
		// RetrieveData findData = new RetrieveData(urlString, "JANESVILLE");
		// String urlString =
		// "http://www.weather.gov/view/prodsByState.php?state=GA&prodtype=climate";

		String urlString = "http://www.nws.noaa.gov/xml/tpex/scs.php";
		RetrieveData findData = new RetrieveData(urlString, "MADISON");
		int[] maximumTemp = new int[3];
		int[] minimumTemp = new int[3];

		String temp = findData.crawlWebSite();

		if (temp == null) {
			System.out.println("No data found in " + urlString);
		} else {
			System.out.println("Yippe!  Data found! ");
		}

		maximumTemp = findData.getMaxTemp();
		minimumTemp = findData.getMinTemp();
		for (int day = 0; day < maximumTemp.length; day++)
		{
			System.out.println((day + 1) + "  " + maximumTemp[day] + "  "
			        + minimumTemp[day]);
		}
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
