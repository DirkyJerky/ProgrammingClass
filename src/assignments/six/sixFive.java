package assignments.six;

import java.util.Scanner;

import assignments.Analysis;
import assignments.Printer;
import mod6.MovieTicket;
import mod6.MovieUser;
import mod6.MovieUserManager;

public class sixFive implements Analysis {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		print("Hello and welcome to the movies", true);
		print("What is your name? ", false);
		String name = in.nextLine().trim();
		print("What movie would you like to see today? ", false);
		String movie = in.nextLine().trim();
		print("You have not made an account yet, please do so.", true);
		print("Please enter your credit card number: ", false);
		long card = in.nextLong();
		print("Please make a 5 digit PIN for your account: ", false);
		int pin = in.nextInt();
		MovieUser user = new MovieUser(name, pin, card);
		MovieUserManager users = new MovieUserManager(); // Just practicing java conventions
		users.newUser(name, user);
		print("You have successfully made a new account, " + name, true);
		print("How many tickets to " + movie + " yould you like today? ", false);
		int count = in.nextInt();
		MovieTicket ticket = new MovieTicket(user, movie, count);
		print("", true);
		print("Please Print the following reciept, it is your ticket.", true);
		print("", true);
		print(ticket.reciept(), true);
		
		in.close();
	}
	private static void print(Object s, boolean line) {
		if (line) { 
			System.out.println(s); 
		} else { 
			System.out.print(s);
		}
	}
	
	public void printQuestions(Printer p) {
		p.print("Describe the main point of this assignment. (Required)");
		p.printTab("Make a console program to track movie ticket sellings");
		
		p.print("Discuss how this assignment relates to a real-life situation. (Required)");
		p.printTab("That program could be used (with a cashier of course) to sell movie tickets at a theatre");
		
		p.print("Reflect on your growth as a programmer. (Required)");
		p.printTab("Here I practiced making objects contain reference fields, e.a. the MovieTicket object takes a MovieUser object");
		
		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printTab("How to handle where the MovieTicket s are used");
		
		p.print("Describe at least one thing that will be done differently in the future.");
		p.printTab("Make a central static java.lang.List to keep track of the tickets");
		
		p.print("Suggest how this assignment could be extended.");
		p.printTab("Make it able to sell more than one ticket at a time in one execution");
		
		p.print("How could the interactivity of this program be improved?");
		p.printTab("By having a user make an account and be able to access their account details");
		
		p.print("How could the output of this program be improved?");
		p.printTab("By using something other than a console, like a JFrame");
		
		p.print("What user security issues could be improved in this program?");
		p.printTab("The credit card being stored in plain text");
		
		p.print("What question(s) of your own did you answer while writing this program?");
		p.printTab("Not much.");
		
		p.print("What additional questions can you answer by further experimentation with this code?");
		p.printTab("How to use a static list in a <InsertClassName>Manager named class.");
		
		
	}

}
