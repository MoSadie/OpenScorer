package OpenScorer;

import java.io.File;
import java.util.HashMap;

import javax.swing.*;

public class OpenScorer extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2495577178876160812L;
	
	File folder = new File("sheets");
	for (int i = 0; i < folder.listFiles().size(); i++)
	{
		
		System.out.println("Name of folder: " + folder.listFiles()[i].toString());
	}
	public HashMap<String, Object> Items = new HashMap<String, Object>();
}
