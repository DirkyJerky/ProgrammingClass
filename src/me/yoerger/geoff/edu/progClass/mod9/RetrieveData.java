package me.yoerger.geoff.edu.progClass.mod9;

/**
 * This program retrieves information from a web site.
 * 
 * �FLVS 2008 Assignment 09.05 - Code Evaluation 1
 * 
 * @author B. Jordan
 * @version 10/20/08
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class RetrieveData
{
	private String city = null;
	private String line = null;
	private String urlStr = null;
	private int[] maxTemp = new int[3];
	private int[] minTemp = new int[3];

	public RetrieveData(String url, String loc)
	{
		this.city = loc;
		this.urlStr = url;
	}

	public String crawlWebSite()
	{

		try
		{
			URL url = new URL(this.urlStr);
			InputStream inStr = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
			        inStr));
			while (((this.line = reader.readLine()) != null)
			        && (this.line.indexOf(this.city) < 0))
			{}
			if (this.line != null)
			{
				// Use this.line, it contains our data
				try {
					this.maxTemp[0] = Integer.parseInt(this.line.substring(17,
					        19));
					this.minTemp[0] = Integer.parseInt(this.line.substring(21,
					        23));
					this.maxTemp[1] = Integer.parseInt(this.line.substring(40,
					        42));
					this.minTemp[1] = Integer.parseInt(this.line.substring(43,
					        45));
					this.maxTemp[2] = Integer.parseInt(this.line.substring(56,
					        58));
					this.minTemp[2] = Integer.parseInt(this.line.substring(59,
					        61));
				} catch (NumberFormatException e) {
					System.err.println("Found: " + this.line.substring(17, 19)
					        + " " + this.line.substring(21,
					                23)
					        + " " + this.line.substring(40,
					                42)
					        + " " + this.line.substring(43,
					                45)
					        + " " + this.line.substring(56,
					                58)
					        + " " + this.line.substring(59,
					                61)
					        + "; all should be integer?");
				}
			}
		} catch (FileNotFoundException ex)
		{
			System.err.println("Could not connect to " + this.urlStr);
		} catch (Exception ex)
		{
			System.err.println("Error during read or write");
			ex.printStackTrace();
		}
		return this.line;
	}

	public int[] getMaxTemp()
	{
		return this.maxTemp;
	}

	public int[] getMinTemp()
	{
		return this.minTemp;
	}
}
