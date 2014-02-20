package mod6;

import mod8.Printable;

public class ContactInfo implements Printable {
	public String name;
	public long homePhone;
	public long cellPhone;
	
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
