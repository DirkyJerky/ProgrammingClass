package assignments.seven;

import assignments.Analysis;
import mod6.BigIdea;

public class sevenSix implements Analysis{

	public static void main(String[] args) {
		BigIdea idea = new BigIdea(6, "Make a turtle dance floor");
		idea.setNewDesc("Make a grid of color changing turtles that turn "
				+ "random directions and make a pretty drawing");
		idea.print();

	}

}
