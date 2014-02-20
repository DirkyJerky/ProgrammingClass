package mod6;


public class MovieTicket {
	public MovieUser user;
	public String movie;
	public int count;
	
	public MovieTicket(MovieUser user, String movie, int count) {
		this.user = user;
		this.movie = movie;
		this.count = count;
	}
	public String reciept() {
		StringBuilder sb = new StringBuilder();
		sb.append(user.name + "\n");
		sb.append(count + " admissions to " + movie + "\n");
		sb.append("ID: " + this.hashCode() + "\n");
		sb.append("Enjoy your movie!");
		return sb.toString();
	}

}
