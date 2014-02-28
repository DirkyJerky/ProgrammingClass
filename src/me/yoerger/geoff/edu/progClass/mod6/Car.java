package me.yoerger.geoff.edu.progClass.mod6;

public abstract class Car {
	public String name;
	public String manufacter;
	public int year;
	public float milesPerGallon;
	
	public Car(String name, String man, int year, float mpg) {
		this.manufacter = man;
		this.name = name;
		this.year = year;
		this.milesPerGallon = mpg;
	}
    /*
     * @param String in the form of "year manufactor name".
     * e.g. 2025 Guay Servana
     */
	public Car(String name, float mpg) {
		String[] s = name.split(" ");
		this.manufacter = s[1];
		this.milesPerGallon = mpg;
		this.name = s[2];
		this.year = Integer.parseInt(s[0]);
	};
	
	public String fullName() {
		return this.year + " " + this.manufacter + " " + this.name;
	};
	public String toString(boolean withMPG){
		return (this.year + " " + this.manufacter + " " + this.name + (withMPG ? " with " + this.milesPerGallon + "MPG" : ""));
	};
}
