package me.yoerger.geoff.edu.progClass.mod10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    private String[] playList = new String[3];
    private String[] fileList = new String[3];
    private String file;
    
    FileHandler(String f) 
    {
        this.file = f;
    }
    
    public void readFile() throws IOException
    {
        int index = 0;
        File fileName = new File(file);
        Scanner inFile = new Scanner(fileName);
        while (inFile.hasNext())
        {
            playList[index] = inFile.nextLine();
            fileList[index] = inFile.nextLine();
            index++;
        }
        inFile.close();
    }
    
    public String[] getPlayList()
    {
        return playList;
    }
    
    public String[] getFileList()
    {
        return fileList;
    }
}