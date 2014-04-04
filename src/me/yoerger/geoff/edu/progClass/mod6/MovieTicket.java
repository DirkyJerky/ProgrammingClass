package me.yoerger.geoff.edu.progClass.mod6;


/**
 * Used to represent an authentication to a Movie in a theater
 * @author yoerggeo000
 * @see MovieUser, MovieUserManager
 */
public class MovieTicket {
	/**
	 * Thee {@link MovieUser} that bought this ticket
	 */
	public MovieUser user;
	/**
	 * The name of the movie they are attending
	 */
	public String movie;
	/**
	 * The number of authentications
	 */
	public int count;
	
	/**
	 * @param user The user that bought this ticket
	 * @param movie The name of the movie
	 * @param count The number of tickets purchased
	 */
	public MovieTicket(MovieUser user, String movie, int count) {
		this.user = user;
		this.movie = movie;
		this.count = count;
	}
	/**
	 * @return The receipt for these tickets
	 */
	public String reciept() {
		StringBuilder sb = new StringBuilder();
		sb.append(user.name + "\n");
		sb.append(count + " admissions to " + movie + "\n");
		sb.append("ID: " + this.hashCode() + "\n");
		sb.append("Enjoy your movie!");
		return sb.toString();
	}

}
