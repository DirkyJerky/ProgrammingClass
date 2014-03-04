package me.yoerger.geoff.edu.progClass.mod9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.base.Preconditions;

import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;


public class FileCopier {

	public static void main(String[] args) throws IOException {
		String orig = FileChooser.pickAFile();
		String dest = FileChooser.pickADirectory();
		Preconditions.checkNotNull(orig);
		Preconditions.checkNotNull(dest);
		Preconditions.checkArgument(new File(orig).canExecute(), "Cant execute");
		Preconditions.checkArgument(new File(orig).canRead(), "Cant read");
		Preconditions.checkArgument(new File(orig).canWrite(), "Cant write");
		InputStream in = new FileInputStream(orig);
		OutputStream out = new FileOutputStream(dest);
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
		   out.write(buf, 0, len);
		}
		in.close();
		out.close(); 

	}

}
