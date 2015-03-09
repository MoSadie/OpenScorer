package OpenScorer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class OpenFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7157456001029041228L;
	BufferedReader reader;
	FlowLayout flo = new FlowLayout();
	File File;
	String[] listOfItems;
	BufferedWriter output;
	JFrame Frame;
	String[] fileLines;
	ArrayList<String> ALlistOfItems = new ArrayList<String>();
	OpenFrame(File file, JFrame frame) {
		super("OpenScorer: " + file.getName());
		File = file;
		Frame = frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(flo);
		setSize(500,500);
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel loadedPanel = new JPanel(flo);
		JPanel SaveQuit = new JPanel(flo);
		try {
			while (true) {
				String line = reader.readLine();
				if (line != null) {
					System.out.println("Line is " + line);
					listOfItems = line.split(";");
					for (String item: listOfItems) {
						ALlistOfItems.add(item);
						String[] type = item.split(",");
						switch (type[0]) {
						case "JLabel":
							OpenScorer.objects.put(type[1], new JLabel(type[1]));
							loadedPanel.add((JLabel)OpenScorer.objects.get(type[1]));
							System.out.println("Added " + type[0] + " to the frame!");
							break;
						case "JTextField":
							OpenScorer.objects.put(type[1], new JTextField(Integer.parseInt(type[2])));
							loadedPanel.add((JTextField)OpenScorer.objects.get(type[1]));
							System.out.println("Added " + type[0] + " to the frame!");
							break;
						case "JPasswordField":
							OpenScorer.objects.put(type[1], new JPasswordField((Integer.parseInt(type[2]))));
							loadedPanel.add((JPasswordField)OpenScorer.objects.get(type[1]));
							System.out.println("Added " + type[0] + " to the frame!");
							break;
						case "JTextArea":
							OpenScorer.objects.put(type[1], new JTextArea(Integer.parseInt(type[2]),Integer.parseInt(type[3])));
							((JTextArea) OpenScorer.objects.get(type[1])).setLineWrap(Boolean.parseBoolean(type[4]));
							loadedPanel.add((JTextArea)OpenScorer.objects.get(type[1]));
							System.out.println("Added " + type[0] + " to the frame!");
							break;
						case "JCheckBox":
							OpenScorer.objects.put(type[1], new JCheckBox());
							loadedPanel.add((JCheckBox)OpenScorer.objects.get(type[1]));
							System.out.println("Added " + type[0] + " to the frame!");
							break;
						default:
							System.out.println("Error: Invalid Swing Compoment, " + type[0] + " Must be either JLabel, JTextField, JPasswordField, JTextArea, or JCheckBox.");
							break;
						}
					}
				} else {
					System.out.println("End of File reached!");
					reader.close();
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(loadedPanel);
		JButton Save = new JButton("Save");
		JButton Quit = new JButton("Quit");
		Save.setActionCommand("save");
		Quit.setActionCommand("quit");
		Save.addActionListener(this);
		Quit.addActionListener(this);
		SaveQuit.add(Save);
		SaveQuit.add(Quit);
		add(SaveQuit);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if ("save".equalsIgnoreCase(e.getActionCommand())) {
			System.out.println("Saving...");
			File outFolder = new File("OpenScorerOutput");
			if (outFolder.mkdir()) {
				System.out.println("Created OpenScorerOutput");
			} else {
				System.out.println("OpenScorerOutput not created!");
			}
			try {
				output = new BufferedWriter(new FileWriter("OpenScorerOutput" + java.io.File.separator + File.getName()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Output Created!");
			String[] stringArray = ConvertToStringArray(ALlistOfItems);
			for (String item: stringArray) {
				String[] type = item.split(",");
				switch (type[0]) {
				case "JLabel":
					JLabel label = (JLabel) OpenScorer.objects.get(type[1]);
					try {
						output.write(type[0] + " " + type[1] + ":" + label.getText());
						System.out.println("Outputted " + type[0] + " with a label of " + type[1]);
						output.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "JTextField":
					JTextField TextField = (JTextField) OpenScorer.objects.get(type[1]);
					try {
						output.write(type[0] + " " + type[1] + ":" + TextField.getText());
						System.out.println("Outputted " + type[0] + " with a label of " + type[1]);
						output.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "JPasswordField":
					JPasswordField PasswordField = (JPasswordField) OpenScorer.objects.get(type[1]);
					try {
						output.write(type[0] + " " + type[1] + ":" + String.valueOf(PasswordField.getPassword()));
						System.out.println("Outputted " + type[0] + " with a label of " + type[1]);
						output.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "JTextArea":
					JTextArea TextArea = (JTextArea) OpenScorer.objects.get(type[1]);
					try {
						output.write(type[0] + " " + type[1] + ":" + TextArea.getText());
						System.out.println("Outputted " + type[0] + " with a label of " + type[1]);
						output.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "JCheckBox":
					JCheckBox CheckBox = (JCheckBox) OpenScorer.objects.get(type[1]);
					try {
						output.write(type[0] + " " + type[1] + ":" + CheckBox.isSelected());
						System.out.println("Outputted " + type[0] + " with a label of " + type[1]);
						output.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				default:
					System.out.println("Invalid Type, check output");
					try {
						output.write("Error Invalid type: " + type[0] + " Check the spelling or caps");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if ("quit".equalsIgnoreCase(e.getActionCommand())) {
			System.out.println("Do They Want to quit?");
			int output = JOptionPane.showConfirmDialog(Frame, "Are you sure you want to quit?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (output == JOptionPane.YES_OPTION) {
				System.out.println("Quitting...");
				System.exit(0);
			} else {
				System.out.println("Nevermind! :)");
			}
		} else {
			System.out.println("Invalid Action Command: " + e.getActionCommand());
		}
	}
	
	public static String[] ConvertToStringArray(ArrayList<String> list)
	{
	    return (String[])list.toArray(new String[0]);
	}
}
