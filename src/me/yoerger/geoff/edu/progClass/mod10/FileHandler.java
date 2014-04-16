package me.yoerger.geoff.edu.progClass.mod10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.google.common.base.Preconditions;

public class FileHandler {
    private String[] playList = new String[3];
    private File[] fileList = new File[3];
    private String file;
    
    FileHandler(String f) 
    {
        this.file = f;
    }
    
    public void readFile() throws IOException
    {
        int index = 0;
        File fileName = new File(file + "\\playlist.txt");
        Scanner inFile = new Scanner(fileName);
        while (inFile.hasNext())
        {
            playList[index] = inFile.nextLine();
            fileList[index] = new File(this.file + "\\" + inFile.nextLine());
            Preconditions.checkArgument(fileList[index].exists());
            Preconditions.checkArgument(fileList[index].canRead());
            index++;
        }
        inFile.close();
    }
    
    public String[] getPlayList()
    {
        return playList;
    }
    
    public File[] getFileList()
    {
        return fileList;
    }
}