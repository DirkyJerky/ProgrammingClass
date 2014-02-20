package assignments.six;

import java.util.Scanner;

import mod6.MovieTicket;
import mod6.MovieUser;
import mod6.MovieUserManager;

public class sixFive {


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

}
