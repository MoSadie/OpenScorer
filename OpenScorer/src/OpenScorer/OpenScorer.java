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
	public static void main (String[] arguments) {
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
	}
	public OpenScorer() {
		super("OpenScorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,100);
		setVisible(true);
		
	}
}
