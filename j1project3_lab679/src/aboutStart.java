import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class aboutStart implements ActionListener 
{	
	JFrame aboutWindow;
	public aboutStart()
	{
		aboutWindow = new JFrame("About Dialog");
		aboutWindow.setSize(200,200);
		aboutWindow.setResizable(false);
		
		aboutWindow.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		aboutWindow.add(new JLabel("Program written by:"),c);
		
		c.gridx = 0;
		c.gridy = 1;
		aboutWindow.add(new JLabel("Bill Caffery"), c);
		
		c.gridx = 0;
		c.gridy = 2;
		aboutWindow.add(new JLabel("Labs 6, 7, and 9"), c);
		
		c.gridx = 0;
		c.gridy = 3;
		aboutWindow.add(new JLabel("Java 1 (IT218) Winter 2010"),c);
		
		JButton okBtn = new JButton("Ok");
		c.gridx = 0;
		c.gridy = 4;
		aboutWindow.add(okBtn,c);
		
		okBtn.addActionListener(this);
		
		aboutWindow.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		aboutWindow.setVisible(false);
	}
}
