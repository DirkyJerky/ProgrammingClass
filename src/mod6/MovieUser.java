package mod6;

public class MovieUser {
	public String name;
	
	private long card;
	private int pin;
	
	public MovieUser(String name, int pin, long card) {
		this.name = name;
		this.card = card;
		this.pin = pin;
	}
	public int getCardDigits() {
		String digits = String.valueOf(card).substring(12, 16);
		return Integer.parseInt(digits); 
		// Return the last 4 digits of this card
	}
	public boolean checkPin(int pin) {
		return this.pin == pin;
	}

}
