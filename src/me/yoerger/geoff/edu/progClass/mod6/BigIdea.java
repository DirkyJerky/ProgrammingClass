package me.yoerger.geoff.edu.progClass.mod6;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to represent a project proposal as an object
 * 
 * @author yoerggeo000
 * @since Assignment 6.6
 */
public class BigIdea {
	/**
	 * A brief description of the proposal
	 */
	public String brief;
	/**
	 * The module number this proposal belongs to
	 */
	public int module;
	private List<String> descriptions;

	/**
	 * @param module
	 *            The module number
	 * @param brief
	 *            A brief description of the proposal
	 * @throws IllegalArgumentException
	 *             if module is not between 6 and 10
	 */
	public BigIdea(int module, String brief) throws IllegalArgumentException {
		if ((module > 10) || (module < 6)) {
			throw new IllegalArgumentException("Module must be from 6 to 10");
		}
		this.module = module;
		this.brief = brief;
		this.descriptions = new ArrayList<>();
	}

	/**
	 * @param s
	 *            The new long description to add
	 */
	public void setNewDesc(String s) {
		this.descriptions.add(s);
	}

	/**
	 * @return The String representing the last entered long description using
	 * @see #setNewDesc(String)
	 */
	public String getDescription() {
		if (!this.descriptions.isEmpty()) {
			return this.descriptions.get(this.descriptions.size() - 1);
		} else {
			return "";
		}
	}

	/**
	 * Print all the old entered description, including the lastest
	 */
	public void printOldDescriptions() {
		for (String s : this.descriptions) {
			System.out.println(s);
		}

	}

	/**
	 * Used to print this entire object to System.out
	 */
	public void print() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Project Proposal for Module " + this.module + "\n");
		sb.append(this.brief + "\n\n");
		sb.append(this.getDescription());
		return sb.toString();
	}

}
