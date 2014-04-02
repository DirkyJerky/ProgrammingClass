package me.yoerger.geoff.edu.progClass.mod6;

/**
 * @author yoerggeo000
 * @since Assignment 6.3
 * A class to hold attributes of a car. 
 * @see UsedCar
 */
public abstract class Car {
	/**
	 * The individual name of this car. e.g. Corola
	 */
	public String name;
	/**
	 * The manufactorer who created this line of cars. e.g. Toyota
	 */
	public String manufacter;
	/**
	 * Year of production
	 */
	public int year;
	/**
	 * Miles per gallon
	 */
	public float milesPerGallon;
	
	/**
	 * @param name The individual name
	 * @param man The manufactorer
	 * @param year The year of production
	 * @param mpg the Miles per Gallon
	 */
	public Car(String name, String man, int year, float mpg) {
		this.manufacter = man;
		this.name = name;
		this.year = year;
		this.milesPerGallon = mpg;
	}
    /**
     * @param name String in the form of "year manufactor name".
     * @param mpg Miles per Gallon
     */
	public Car(String name, float mpg) {
		String[] s = name.split(" ");
		this.manufacter = s[1];
		this.milesPerGallon = mpg;
		this.name = s[2];
		this.year = Integer.parseInt(s[0]);
	};
	
	/**
	 * @return The full brands name of the car
	 */
	public String fullName() {
		return this.toString(false);
	};
	/**
	 * @param withMPG whether to contain the # MPG in the return string
	 * @return A sentence representing the car
	 */
	public String toString(boolean withMPG){
		return (this.year + " " + this.manufacter + " " + this.name + (withMPG ? " with " + this.milesPerGallon + "MPG" : ""));
	};
}
