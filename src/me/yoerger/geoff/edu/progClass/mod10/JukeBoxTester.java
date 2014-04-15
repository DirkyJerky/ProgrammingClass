package me.yoerger.geoff.edu.progClass.mod10;

import java.io.IOException;

import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;

public class JukeBoxTester {
	public static void main(String[] args) throws IOException {
        int choice = 0;
        System.out.println("Please choose your test file with 3 playlist entries");
        FileHandler fileHandler = new FileHandler(FileChooser.pickAFile());
        fileHandler.readFile();
        String [] playList = fileHandler.getPlayList();
        String [] fileList = fileHandler.getFileList();
        
        JukeBox myPod = new JukeBox(playList, fileList);
        choice = myPod.displayMenu();
        myPod.playSong(choice);
        
    }
}
