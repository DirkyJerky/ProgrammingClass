package me.yoerger.geoff.edu.progClass.mod6;

import me.yoerger.geoff.edu.progClass.mod8.Printable;

public class ContactInfo implements Printable {
	/**
	 * The person represented by this ContactInfo's full name
	 */
	public String name;
	/**
	 * Their home phone number
	 */
	public long homePhone;
	/**
	 * Their cell phone number
	 */
	public long cellPhone;
	
	/**
	 * @param name The name for the persont this ContactInfo represents
	 * @param homePhone Their home phone number
	 * @param cellPhone Their cell phone number
	 */
	public ContactInfo(String name, long homePhone, long cellPhone) {
		this.name = name;
		this.cellPhone = cellPhone;
		this.homePhone = homePhone;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + this.name + "\n");
		sb.append("Phones:\n");
		sb.append("\tHome: " + this.homePhone + "\n");
		sb.append("\tCell: " + this.cellPhone + "\n");
		return sb.toString();
	}
	public void print() {
		System.out.println(this.toString());
	}
}
