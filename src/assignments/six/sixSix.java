package assignments.six;

import mod6.BigIdea;

public class sixSix {

	public static void main(String[] args) {
		BigIdea idea = new BigIdea(6, "Check to see if a class exists" );
		idea.setNewDesc("This will poll the specified versions JDK docs webpage, "
			+ "analyze it, and see if a certain class name exists, "
			+ "if it does return its URL");
		idea.print();
	}

}
