package OpenScorer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class OpenFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7157456001029041228L;
	BufferedReader reader;
	OpenFrame(File file) {
		super("OpenScorer: " + file.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,100);
		setVisible(true);
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (reader.readLine() != null) {
				System.out.println(reader.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
