package me.yoerger.geoff.edu.progClass.mod6;

import java.util.ArrayList;
import java.util.List;

public class BigIdea {
	public String brief;
	public int module;
	private List<String> descriptions;
	
	
	public BigIdea(int module, String brief) throws IllegalArgumentException {
		if (module > 10 || module < 6) {
			throw new IllegalArgumentException("Module must be from 6 to 10");
		}
		this.module = module;
		this.brief = brief;
		this.descriptions = new ArrayList<>();
	}
	public void setNewDesc(String s) {
		this.descriptions.add(s);
	}
	public String getDescription() {
		if(!this.descriptions.isEmpty()) {
			return this.descriptions.get(this.descriptions.size() - 1);
		} else {
			return "";
		}
	}
	public void printOldDescriptions() {
		for(String s : this.descriptions) {
			System.out.println(s);
		}
		
	}
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
