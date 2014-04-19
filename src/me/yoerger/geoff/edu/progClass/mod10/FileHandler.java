package me.yoerger.geoff.edu.progClass.mod10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.google.common.base.Preconditions;

/**
 * Used for handling playlist folders
 * @author yoerggeo000
 * @since Apr 17, 2014
 */
public class FileHandler {
    private String[] playList = new String[3];
    private File[] fileList = new File[3];
    private String file;
    
    /**
     * Make a new playlist browser
     * @param f The absolute filename of the playlist folder
     */
    FileHandler(String f) 
    {
        this.file = f;
    }
    
    /**
     * Read the playlist.txt
     * @throws IOException If the file is not there or readable
     */
    public void readFile() throws IOException 
    {
        int index = 0;
        File fileName = new File(file + "\\playlist.txt");
        Scanner inFile = new Scanner(fileName);
        while (inFile.hasNext())
        {
            playList[index] = inFile.nextLine();
            fileList[index] = new File(this.file + "\\" + inFile.nextLine());
            Preconditions.checkArgument(fileList[index].exists(), "There is no playlist.txt!");
            Preconditions.checkArgument(fileList[index].canRead(), "I can't read your playlist.txt!");
            index++;
        }
        inFile.close();
    }
    
    /**
     * Get this.playlist
     * @return The found playlist
     */
    public String[] getPlayList()
    {
        return playList;
    }
    
    /**
     * Get this.filelist
     * @return The found filelist
     */
    public File[] getFileList()
    {
        return fileList;
    }
}