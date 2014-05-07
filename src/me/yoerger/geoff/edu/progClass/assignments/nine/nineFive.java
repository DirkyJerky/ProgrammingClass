package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;
import java.awt.GradientPaint;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod9.RetrieveData;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.joda.time.DateTime;

/**
 * Assignment 9.5
 * Prompt a weather website for information and graph that data.
 */
public class nineFive implements Analysis {
	private static String city = "MADISON";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Get Weather data");
		// String urlString =
		// "http://www.weather.gov/view/prodsByState.php?state=FL&prodtype=climate";
		// RetrieveData findData = new RetrieveData(urlString, "JANESVILLE");
		// String urlString =
		// "http://www.weather.gov/view/prodsByState.php?state=GA&prodtype=climate";

		String urlString = "http://www.nws.noaa.gov/xml/tpex/scs.php";
		RetrieveData findData = new RetrieveData(urlString, city);
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
		TimeTableXYDataset data = new TimeTableXYDataset();

		DateTime today = new DateTime();
		DateTime tomorrow = today.plusDays(1);
		DateTime day2 = today.plusDays(2);

		data.add(new Day(today.toDate()), maximumTemp[0], "Min");
		data.add(new Day(tomorrow.toDate()), maximumTemp[1], "Min");
		data.add(new Day(day2.toDate()), maximumTemp[2], "Min");
		data.add(new Day(today.toDate()), minimumTemp[0], "Max");
		data.add(new Day(tomorrow.toDate()), minimumTemp[1], "Max");
		data.add(new Day(day2.toDate()), minimumTemp[2], "Max");
		JFreeChart chart = createChart(data);

		ChartPanel showMe = new ChartPanel(chart);
		JFrame frame = new JFrame("Temperatures");
		frame.getContentPane().add(showMe);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// showMe.setVisible(true);

	}

	private static JFreeChart createChart(TableXYDataset paramTableXYDataset)
	{
		DateAxis localDateAxis = new DateAxis(
		        "Today; Tomorrow; and the Day after that.");
		localDateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
		localDateAxis.setLowerMargin(0.01D);
		localDateAxis.setUpperMargin(0.01D);
		NumberAxis localNumberAxis = new NumberAxis("Temperature");
		localNumberAxis.setNumberFormatOverride(new DecimalFormat("#"));
		StackedXYBarRenderer localStackedXYBarRenderer = new StackedXYBarRenderer(
		        0.3D);
		localStackedXYBarRenderer.setDrawBarOutline(false);
		// localStackedXYBarRenderer
		// .setBaseToolTipGenerator(new StandardXYToolTipGenerator(
		// "{0} : {1} = {2} tonnes", new SimpleDateFormat("yyyy"),
		// new DecimalFormat("#,##0")));
		XYPlot localXYPlot = new XYPlot(paramTableXYDataset, localDateAxis,
		        localNumberAxis, localStackedXYBarRenderer);
		localXYPlot.setBackgroundPaint(Color.lightGray);
		localXYPlot.setDomainGridlinePaint(Color.white);
		localXYPlot.setRangeGridlinePaint(Color.white);
		JFreeChart localJFreeChart = new JFreeChart("Temperatures",
		        localXYPlot);
		localJFreeChart.setBackgroundPaint(Color.white);
		localJFreeChart.addSubtitle(new TextTitle(
		        city.charAt(0) + city.toLowerCase().substring(1)));
		ChartUtilities.applyCurrentTheme(localJFreeChart);
		GradientPaint localGradientPaint1 = new GradientPaint(0.0F, 0.0F,
		        new Color(64, 0, 0), 0.0F, 0.0F, Color.red);
		GradientPaint localGradientPaint2 = new GradientPaint(0.0F, 0.0F,
		        new Color(0, 64, 0), 0.0F, 0.0F, Color.green);
		localStackedXYBarRenderer.setSeriesPaint(0, localGradientPaint1);
		localStackedXYBarRenderer.setSeriesPaint(1, localGradientPaint2);
		localStackedXYBarRenderer
		        .setGradientPaintTransformer(new StandardGradientPaintTransformer(
		                GradientPaintTransformType.HORIZONTAL));
		return localJFreeChart;
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
