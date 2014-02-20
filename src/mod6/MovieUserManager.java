package mod6;

import java.util.HashMap;
import java.util.Map;

public final class MovieUserManager {
	
	private static Map<String, MovieUser> Usermap;
	
	public MovieUserManager() {
		Usermap = new HashMap<>();
	}
	public boolean newUser(String name, MovieUser user) {
		if (Usermap.containsKey(name)) {
			return false;
		}
		Usermap.put(name, user);
		return true;
	}
	public MovieUser getUser(String name) {
		return Usermap.get(name);
	}

}
