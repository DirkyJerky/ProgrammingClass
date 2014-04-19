package me.yoerger.geoff.edu.progClass.mod10;

import java.io.File;
import java.io.IOException;

import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;

/**
 * Base for {@link me.yoerger.geoff.edu.progClass.assignments.ten.tenThree}
 * @author yoerggeo000
 * @since Apr 17, 2014
 */
public class JukeBoxTester {
	public static void main(String[] args) throws IOException {
        int choice = 0;
        System.out.println("Please choose your folder with "
        		+ "3 playlist entries and a index (playlist.txt)");
        String playlistDir = FileChooser.pickADirectory();
        FileHandler fileHandler = new FileHandler(playlistDir);
        fileHandler.readFile();
        String [] playList = fileHandler.getPlayList();
        File[] fileList = fileHandler.getFileList();
        
        JukeBox myPod = new JukeBox(playList, fileList);
        choice = myPod.displayMenu();
        myPod.playSong(choice);
        
    }
}
