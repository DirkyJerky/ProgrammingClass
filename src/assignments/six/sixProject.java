package assignments.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class sixProject {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean CL = false;
		int JDKversion = 7; // Change if you want a different JDK
		// Get rid of that nasty default array
		List<String> list = new ArrayList<String>(Arrays.asList(args)); 
		if(list.isEmpty()) {
			System.out.print("Commandline mode. ");
			System.out.println("You can also start this class with command line args.");
			CL = true;
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the name of the class you want to see if it exists.");
			String classname = in.next();
			System.out.println(getURLforClass(classname.toLowerCase(), JDKversion));
			
			in.close();
		} else {
			
			System.out.println(getURLforClass(list.get(0).toLowerCase(), JDKversion));
		}
		System.out.println();
	}
	// This can also be a standalone method in a class, but this is an assignment,
	// Not a library.
	public static boolean getURLforClass(String s, int JDK) {
		HashMap<Integer, String> JDKversions = new HashMap<>();
		JDKversions.put(7, "http://docs.oracle.com/javase/7/docs/api/allclasses-frame.html");
		JDKversions.put(8, "http://download.java.net/jdk8/docs/api/allclasses-frame.html");
		URL u = null; 
        InputStream in = null;
		// Lots of autogen try catches.....
        // Condensed each of the catch statements into one line, 
        // they all print a stacktrace.
		try {
			u = new URL(JDKversions.get(JDK));
		} catch (MalformedURLException e) { e.printStackTrace(); }
        URLConnection uRLConnection = null;
		try {
			uRLConnection = u.openConnection();
		} catch (IOException e) { e.printStackTrace(); }               
        HttpURLConnection connection = (HttpURLConnection) uRLConnection;            
        connection.setDoOutput(true);
        connection.setDoInput(true);
		try {
			in = connection.getInputStream();
		} catch (IOException e) { e.printStackTrace(); }
		
		String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

		try {
			while ((line = br.readLine()) != null) {
				if(line.toLowerCase().contains(">" + s + "<")) { // Just to make sure
					return true; // I was going to make it return the URL for the
					// JD page for it,... but IDK how.
					// So many NPEs when I tried, I wish BeautifulSoup existed for Java :(
				}
			}
		} catch (IOException e) { e.printStackTrace(); }
		
        return false;
        
            
        
		
		

	}
}
