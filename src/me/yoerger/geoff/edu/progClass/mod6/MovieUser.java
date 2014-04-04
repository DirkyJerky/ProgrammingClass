package me.yoerger.geoff.edu.progClass.mod6;

public class MovieUser {
	/**
	 * The name of this person
	 */
	public String name;
	
	protected long card;
	protected int pin;
	
	/**
	 * @param name The name of this user
	 * @param pin Their Personal Identifier number (kept confidential, use {@link #checkPin(int)})
	 * @param card Their credit card number (kept confidential)
	 */
	public MovieUser(String name, int pin, long card) {
		this.name = name;
		this.card = card;
		this.pin = pin;
	}
	/**
	 * @return The last 4 digits of their card
	 */
	public int getCardDigits() {
		String digits = String.valueOf(card).substring(12, 16);
		return Integer.parseInt(digits); 
		// Return the last 4 digits of this card
	}
	/**
	 * @param pin The pin to check if it is right
	 * @return If the pin was the right pin
	 */
	public boolean checkPin(int pin) {
		return this.pin == pin;
	}

}
