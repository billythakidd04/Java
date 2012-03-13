
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui 
{
	protected JLabel makeLabel(String name,JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row)
	{//create label method
		JLabel label = new JLabel(name);		
		gridbag.setConstraints(label, c);
		c.gridy = row;
		c.gridx = column;
		panel.add(label,c);
		return label;
	}
	
	protected JTextField makeTextfield (String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column,int row)
	{// TextField method
		JTextField textfield = new JTextField(name);		
		gridbag.setConstraints(textfield, c);
		c.gridy = row;
		c.gridx= column;
		panel.add(textfield,c);
		return textfield;
	}
	protected JButton makeButton(String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int row, int column) 
	{   // create button method
		JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        c.gridx = column;
        c.gridy = row;
        panel.add(button,c);
        return button;
	}
	
	public void addPanel2Frame(JPanel panel,JFrame frame, String orientation)//BorderLayout constant
	{
		frame.add(panel,orientation);
	}
	
	public void init(JFrame frame, int width, int height)  
	{
		// setting up frame
		//frame = new JFrame (winName);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
		
	

}
