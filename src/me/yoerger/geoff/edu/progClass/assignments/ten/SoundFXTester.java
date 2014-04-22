package me.yoerger.geoff.edu.progClass.assignments.ten;

import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;

/**
 * The purpose of this program is to test the SoundFX class.
 * 
 * ©FLVS 2008
 * Lesson 10.04 - Code Exploration 3
 * @author B. Jordan 
 * @version 11/30/08
 */
public class SoundFXTester
{
    public static void main(String[] args)
    {
    	System.out.println("Please choose your starting .wav file");
    	String inFile = FileChooser.pickAFile();
    	System.out.println("Please choose a directory where the modified sounds will be saved too");
    	String outDir = FileChooser.pickADirectory();
        
        SoundFX.adjustVolume(inFile, outDir, 1.5);
        SoundFX.echo(inFile, outDir, 2000);
        SoundFX.helium(inFile, outDir);
    	SoundFX.mirror(inFile, outDir);
    	System.out.println("Done!");
    }
    
}
