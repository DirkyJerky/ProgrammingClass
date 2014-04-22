package me.yoerger.geoff.edu.progClass.assignments.ten;

import java.io.File;

import me.yoerger.geoff.edu.progClass.bookClasses.Sound;
import me.yoerger.geoff.edu.progClass.bookClasses.SoundSample;

/**
 * This class creates audio sound effects.
 * 
 * ©FLVS 2008
 * Lesson 10.04 - Code Evaluation 3
 * @author B. Jordan 
 *         Note: This code has been adapted from examples in 
 *         Introduction to Computing and Programming with Java: 
 *         A Multimedia Approach by Mark Guzdial and Barbara Ericson
 * @version 12/01/08
 */
public class SoundFX
{
    //Default constructor
    private SoundFX()
    {
    }
    
    //The adjustVolume method changes the volume of a source file by the xFactor parameter and writes the new audio to a file.
    public static void adjustVolume(String sourceFile, String targetFileDirectory, double adjustFactor)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A Sound object takes sourceFile as parameter to represent the source sound file.
        SoundSample[] sampleArray = sourceObj.getSamples();                     //The getSamples() method is invoked on the sourceObject to assign all of the audio sample values to the sampleArray which is of type SoundSample.
        SoundSample sampleObj = null;                                           //The SoundSample object called sampleObj is declared and initialized to null.
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        
        for(int index = 0; index < sampleArray.length; index++)                 //A for loop is created to traverse the lenght of the sampleArray.
        {
            sampleObj = sampleArray[index];                                     //An element in the sampleArray at the index variable position is assigned to sampleObj.
            sampleValue = sampleObj.getValue();                                 //The getValue() method is invoked on the sampleObj to get the sample and assign it to the sampleValue variable.
            sampleObj.setValue((int)(sampleValue * adjustFactor));              //The setValue() method is invoked on the sampleObj. The sampleValue is multiplied by the adjustFactor variable to increase the volume.  This value is re-set to this position in the sampleObj.
        }
//        sourceObj.play();       //After the loop terminates, the play() method is invoked on the sourceObj and the audio is played at the higher volume.
        if(targetFileDirectory != null)
        	sourceObj.write(targetFileDirectory + File.separatorChar + "adjustedX" + adjustFactor + ".wav");                                       //The write() method is invoked on the sourceObj and the audio at the higher volume is saved as a .wav file.
    }
    
    //The echo method creates an echo-like effect from the source file based on the delay parameter and writes the new audio to a file.
    public static void echo(String sourceFile, String targetFile, int delay)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A Sound object takes sourceFile as a parameter to represent the sound file.                               
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        
        for(int index = delay; index < sourceObj.getLength(); index++)          //A for loop is created to traverse the length of the sourceObj.
        {
            sampleValue = (int)(sourceObj.getSampleValueAt(index-delay) * 0.6);                 //The getSampleValueAt() method is invoked on the soruceObj. The sample position is represented by the element position (delay-index) *.6 which is assigned to the sampleValue variable.
            sourceObj.setSampleValueAt(index, sourceObj.getSampleValueAt(index)+sampleValue);   //This statement sets a new sample value in sourceObj at the index position.
        }
//        sourceObj.play();                                                       //After the loop terminates, the play() method is invoked on the sourceObj and the audio is played with the echo added.
        if(targetFile != null)
        	sourceObj.write(targetFile  + File.separatorChar + "echo.wav");                                            //The write() method is invoked on the sourceObj and the audio with the echo is saved as a .wav file.
    }
    
    //The helium method creates a rapid, high pitched audio from a source file and writes the new audio to a file.
    public static void helium(String sourceFile, String targetFile)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A sourceObject now represents the sourceFile object.
        Sound target = new Sound(sourceObj);                                   //Construct a new Sound object called target. The target object now represents the targetFile object.
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        int targetIndex = 0;                                                    //The targetIndex variable is declared as an int and is initialized to 0.
        
        for(int index = 0; index < sourceObj.getLength(); index+=2)             //A for loop is created to traverse the length of the sourceObj. Notice that the loop increments by two each time, not 1.
        {
            sampleValue = sourceObj.getSampleValueAt(index);                    //The getSampleValueAt() method gets the sample value at index position of sampleObj.
            target.setSampleValueAt(targetIndex,sampleValue);                   //The setSampleValueAt() method sets the sample value at the targetIndex position in the target file.
            targetIndex++;                                                      //The targetIndex variable is incremented by 1 each time through the loop.
        }
        int targetLength = target.getLength();
        while(targetIndex < targetLength) {
        	target.setSampleValueAt(targetIndex, 0);
        	targetIndex++;
        }
//        target.play();                                                          //The play() method is invoked on the target object to play the audio with the high pitched audio.
        if(targetFile != null)
        	target.write(targetFile + File.separatorChar + "helium.wav");                                            //The write() method is invoked on the target object and the audio with the new higher pitch is saved as a .wav file.
    }

	public static void mirror(String inFile, String outDir) {                               //Construct a new Sound object called sourceObj. A sourceObject now represents the sourceFile object.
        Sound source = new Sound(inFile); 
        Sound target = new Sound(source);
        int len = source.getLength();
        for(int i = 1; i < len; i++) {
        	target.setSampleValueAt(len - i, source.getSampleValueAt(i));
        }
        
		if(outDir != null)
			target.write(outDir + File.separatorChar + "mirror.wav");  
	}

}
/**
 *  Note: This code has been adapted from examples in Introduction to Computing and Programming with Java: A Multimedia Approach by Mark Guzdial and Barbara Ericson
 * 
 */


