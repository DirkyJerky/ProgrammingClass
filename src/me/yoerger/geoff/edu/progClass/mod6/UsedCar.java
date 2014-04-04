package me.yoerger.geoff.edu.progClass.mod6;

/**
 * A representation of a car owned by an individual
 * @author yoerggeo000
 * @since Assignment  6.3
 * 
 */
public class UsedCar extends Car {

	public int milesPerMonth;
	/**
	 * @param name The manufactorers name for the car
	 * @param man The producer of this car brand
	 * @param year The initial year of production of this car brand
	 * @param mpg The miles per gallon of the car
	 * @param milesPerMonth The approximate miles this car goes each month 
	 * @see Car#Car(String, String, int, float)
	 */
	public UsedCar(String name, String man, int year, float mpg, int milesPerMonth) {
		super(name, man, year, mpg);
		this.milesPerMonth = milesPerMonth;
		
	}

	/**
	 * @param name The full name of this Car
	 * @param mpg The miles per gallon of the car
	 * @param milesPerMonth The approximate miles this car goes each month
	 * @see Car#Car(String, float)
	 */
	public UsedCar(String name, float mpg, int milesPerMonth) {
		super(name, mpg);
		this.milesPerMonth = milesPerMonth;
	}
	@Override
	public String toString() {
		return this.toString(true, true);
	};
	/**
	 * @param withMPG If to include the MPG in the String
	 * @param milesPMonth If to include the Miles per month in the String
	 * @return A string representation of this car
	 */
	public String toString(boolean withMPG, boolean milesPMonth) {
		return super.toString(withMPG) + (milesPMonth ? " which is driven " + this.milesPerMonth + " miles per month." : "");
	};
	/**
	 * @param compareCar The car to compare this car to
	 * @param gasPrice The local gas price
	 * @return The cost difference per month of this car compared to compareCar.
	 */
	public float costDif(UsedCar compareCar, float gasPrice) {
		float aGallons = compareCar.milesPerMonth / compareCar.milesPerGallon;
		float bGallons = this.milesPerMonth / this.milesPerGallon;
		float aPrice = aGallons * gasPrice;
		float bPrice = bGallons * gasPrice;
		return (float) Math.abs(aPrice - bPrice);
	}
}
