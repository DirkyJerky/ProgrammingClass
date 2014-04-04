package me.yoerger.geoff.edu.progClass.mod6;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to keep track of multiple {@link MovieUser}
 * @author yoerggeo000
 * @since Module 6
 */
public final class MovieUserManager {
	
	private static Map<String, MovieUser> Usermap;
	
	/**
	 * Initiate a new Manager
	 */
	public MovieUserManager() {
		Usermap = new HashMap<>();
	}
	/**
	 * @param name The full unique name of the new movie-goer
	 * @param user The {@link MovieUser} that has their stats
	 * @return If the addition succeeded
	 */
	public boolean newUser(String name, MovieUser user) {
		if (Usermap.containsKey(name)) {
			return false;
		}
		Usermap.put(name, user);
		return true;
	}
	/**
	 * @param name The full name of the movie-goer
	 * @return The {@link MovieUser} representing them
	 */
	public MovieUser getUser(String name) {
		return Usermap.get(name);
	}

}
