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
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (true) {
				String line = reader.readLine();
				if (line != null) {
					System.out.println("Line is " + line);
					String[] listOfItems = line.split(";");
					for (String item: listOfItems) {
						String[] type = item.split(",");
						switch (type[0]) {
						case "JLabel":
							OpenScorer.objects.put(type[1], new JLabel(type[1]));
							add((JLabel)OpenScorer.objects.get(type[1]));
						case "JTextField":
							OpenScorer.objects.put(type[1], new JTextField());
							add((JTextField)OpenScorer.objects.get(type[1]));
						case "JPasswordField":
							OpenScorer.objects.put(type[1], new JPasswordField());
							add((JPasswordField)OpenScorer.objects.get(type[1]));
						case "JTextArea":
							OpenScorer.objects.put(type[1], new JTextArea());
							add((JTextArea)OpenScorer.objects.get(type[1]));
						case "JCheckBox":
							OpenScorer.objects.put(type[1], new JCheckBox());
							add((JCheckBox)OpenScorer.objects.get(type[1]));
						default:
							System.out.println("Error: Invalid Swing Compoment, " + type[0] + "Must be either JLabel, JTextField, JPasswordField, JTextArea, or JCheckBox.");
						}
					}
				} else {
					System.out.println("End of File reached!");
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
	}
}
