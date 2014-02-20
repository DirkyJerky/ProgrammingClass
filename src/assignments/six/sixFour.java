package assignments.six;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;

public class sixFour {

	public static void main(String[] args) {
		HashMap<String, String> s = new HashMap<>(); // My motive is to put all constants in an easy to change array.
        ArrayList<String> map = new ArrayList<>();
        DateFormat dfYMD = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dfMD = new SimpleDateFormat("MM/dd");
        Date date = new Date();
		s.put("FI", "Bank Bank Inc.");
		s.put("RnameFirst", "Bobby");
		s.put("RnameLast", "Grail");
		s.put("Sname", "Banker Banks");
		s.put("$", "453.13");
		s.put("site", "http://bankbank.scam/");
        map.add(s.get("FI")); // Who ever did it as strings called "line1", I hate you
        map.add("To: " + s.get("RnameFirst") + " " + s.get("RnameLast"));
        map.add("From: " + s.get("Sname"));
        map.add("Date: " + dfYMD.format(date));
        map.add("\n");
        map.add("\tDear Mr/Mrs " + s.get("RnameLast") + ",");
        map.add("On " + dfMD.format(date) + " we noticed a suspicious withdrawal of $" + s.get("$") + " \nfrom your checking account.");
        map.add("If this information is not correct, someone \nunknown to you may have access to your account!");
        map.add("For your safety, please visit " + s.get("site") + " to \nverify your personal information.");
        map.add(s.get("RnameFirst") + ", once you have done this, our fraud \ndepartment will work to resolve this discrepancy."); 
        map.add("\n");
        map.add("Thank you,");  
		map.add("\t" + s.get("Sname"));
		
		for(String string : map) {
			System.out.println(string); // Much better, old way gave me a migrane
		}
	}

}
