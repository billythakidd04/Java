
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui 
{
	public JLabel makeLabel(String name,JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int x, int y)
	{//create label method
		JLabel label = new JLabel(name);		
		gridbag.setConstraints(label, c);
		c.gridy = y;
		c.gridx = x;
		panel.add(label,c);
		return label;
	}
	
	public JTextField makeTextfield (String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int x,int y)
	{// TextField method
		JTextField textfield = new JTextField(name);		
		gridbag.setConstraints(textfield, c);
		c.gridy = y;
		c.gridx = x;
		c.fill = GridBagConstraints.BOTH;
		panel.add(textfield,c);
		textfield.setEditable(false);
		return textfield;
	}
	public JButton makeButton(String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int y, int x) 
	{   // create button method
		JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        c.gridx = x;
        c.gridy = y;
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
