package me.yoerger.geoff.edu.progClass.mod9;

/**
 * This program retrieves information from a web site.
 * 
 * 2008 Assignment 09.05 - Code Evaluation 1
 * 
 * @author B. Jordan
 * @version 10/20/08
 */
public class RetrieveDataTester
{
	public static void main(String[] args)
	{
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
}
