package me.yoerger.geoff.edu.progClass.mod6;

public class UsedCar extends Car {

	public int milesPerMonth;
	public UsedCar(String name, String man, int year, float mpg, int milesPerMonth) {
		super(name, man, year, mpg);
		this.milesPerMonth = milesPerMonth;
		
	}

	public UsedCar(String name, float mpg, int milesPerMonth) {
		super(name, mpg);
		this.milesPerMonth = milesPerMonth;
	}
	@Override
	public String toString() {
		return this.toString(true, true);
	};
	public String toString(boolean withMPG, boolean milesPMonth) {
		return super.toString(withMPG) + (milesPMonth ? " which is driven " + this.milesPerMonth + " miles per month." : "");
	};
	public float costDif(UsedCar a, float gasPrice) {
		float aGallons = a.milesPerMonth / a.milesPerGallon;
		float bGallons = this.milesPerMonth / this.milesPerGallon;
		float aPrice = aGallons * gasPrice;
		float bPrice = bGallons * gasPrice;
		return (float) Math.abs(aPrice - bPrice);
	}
}
