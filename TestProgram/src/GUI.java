import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI implements ActionListener
{
	JFrame frame;
	JPanel panelSend, panelGet, panelShow,container;
	GridBagLayout layout;
	GridBagConstraints c;

	public GUI(String title/*TODO set up size, resize, and close parameters*/)
	{
		//instantiate all basic containers
		setupMainWindow(title);
	}

	private void setupMainWindow(String title) 
	{
		layout = new GridBagLayout();
		frame = GUIHelper.createFrame(title, new Dimension(640, 480), JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.getContentPane().setBackground(Color.BLACK);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;

		container = GUIHelper.createPanel(layout);
		container.setBackground(Color.GREEN);
		
		container.setPreferredSize(new Dimension(150, 150));
		container.setMinimumSize(new Dimension(150, 150));
		container.setMaximumSize(new Dimension(150, 150));

		GUIHelper.addPanelToFrame(frame, container, c);			

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}


}
