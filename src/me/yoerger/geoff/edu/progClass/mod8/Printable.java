package me.yoerger.geoff.edu.progClass.mod8;

/**
 * Used to mark that if this object is used in an assignment, you can
 * execute print() to show all the nesecary information.
 * 
 * By implementing this you uphold that no other method executing will have to 
 * take place besides the print() method to print nessecary information for the 
 * object.
 * @author Geoff Yoerger
 * @since Module 8
 */
public interface Printable {
	/**
	 * @throws Exception if bad stuff happens
	 */
	public void print() throws Exception;
}
