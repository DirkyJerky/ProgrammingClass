package me.yoerger.geoff.edu.progClass.mod6;

public class AdultContactInfo extends ContactInfo {

	public long workPhone;
	
	public AdultContactInfo(String name, long homePhone, long cellPhone, long workPhone) {
		super(name, homePhone, cellPhone);
		this.workPhone = workPhone;
	}
	@Override
	public String toString() {
		return super.toString() + "\tWork: " + this.workPhone + "\n";
	}

}
