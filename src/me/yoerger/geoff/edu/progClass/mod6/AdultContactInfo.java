package me.yoerger.geoff.edu.progClass.mod6;


/**
 * @since Assignment 6.2
 *
 */
public class AdultContactInfo extends ContactInfo {

	private long workPhone;
	
	/**
	 * @param name The name of this person
	 * @param homePhone Their home phone number
	 * @param cellPhone Their cell phone number
	 * @param workPhone Their work phone number
	 */
	public AdultContactInfo(String name, long homePhone, long cellPhone, long workPhone) {
		super(name, homePhone, cellPhone);
		this.workPhone = workPhone;
	}
	/**
	 * @return This person's Work Phone
	 */
	public long getWorkPhone() {
		return workPhone;
	}
	@Override
	public String toString() {
		return super.toString() + "\tWork: " + this.workPhone + "\n";
	}

}
