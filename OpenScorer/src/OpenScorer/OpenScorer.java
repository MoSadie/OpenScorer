package OpenScorer;

import java.io.File;
import java.util.HashMap;
import javax.swing.*;

public class OpenScorer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5631011118025460373L;
	File folder = new File("sheets");
	File[] sheets = folder.listFiles();
	public HashMap<String, Object> Items = new HashMap<String, Object>();
	for (int i = 0; i < folder.listFiles().size(); i++)
	{
		
		System.out.println("Name of file: " + sheets[i].toString());
	}
}
