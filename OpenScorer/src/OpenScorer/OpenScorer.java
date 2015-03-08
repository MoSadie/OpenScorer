package OpenScorer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

public class OpenScorer  extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5631011118025460373L;
	OpenFrame frame;
	public static HashMap<String, Object> objects = new HashMap<String, Object>();
	public static void main (String[] arguments) {
		/*
		File folder = new File("OpenScorerData");
		if (folder.mkdir()) {
			System.out.println("sheets folder created");
		} else {
			System.out.println("sheets folder not created");
		}
		File[] sheets = folder.listFiles();
		HashMap<String, File> Items = new HashMap<String, File>();
		for (File item : sheets) {
			System.out.println("Name of file: " + item.toString());
			Items.put(item.toString(), item);
		}
		*/
		
		File sheet = new File("OpenScorerData" + File.separator + "default.txt");
		if (sheet.exists()) {
			System.out.println("Default Found!");
			
		} else {
			System.out.println("Default not found. Creating...");
			try {
				sheet.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Opening Default...");
		JFrame jFrame = new JFrame();
		OpenFrame frame = new OpenFrame(sheet, jFrame);
	}
}
