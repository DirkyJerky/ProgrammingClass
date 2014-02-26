package assignments.seven;

import assignments.Analysis;
import bookClasses.Picture;
import bookClasses.Turtle;
import bookClasses.World;

public class sevenOne implements Analysis{
    public static void main(String[] args) {
        int pixels = 0;
        Picture pictureObj = new Picture("P:\\Programming\\Externals\\Refs\\Maze_Background.jpg");   
        World worldObj = new World();                          
        worldObj.setPicture(pictureObj);                       
            
        Turtle turtle = new Turtle(23, 42, worldObj);         
        turtle.setHeight(12);                                     
        turtle.setWidth(12);                                       
        turtle.setHeading(90);                                      
        turtle.show(); 
        pixels += moveFor(turtle, 93);
        turtle.turnRight();
        pixels += moveFor(turtle, 38);
        turtle.turnLeft();
        pixels += moveFor(turtle, 195);
        turtle.turn(151);
        pixels += moveFor(turtle, 120);
        turtle.turn(-61);
        pixels += moveFor(turtle, 65);
        turtle.turn(60);
        pixels += moveFor(turtle, 25);
        turtle.turn(30);
        pixels += moveFor(turtle, 105);
        
       System.out.println("The turtle moved " + pixels + " Pixels.");
    }
    public static int moveFor(Turtle t, int pixels) {
    	t.forward(pixels);
    	return pixels;
    }
}
