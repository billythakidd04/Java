import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.ObjectInputStream.GetField;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SpringLayout.Constraints;

/*
 * when adding components using this class' methods, gridbagconstraints must be used
 */

public class GUIHelper 
{
	public static JPanel createPanel()
	{
		JPanel panel = new JPanel();
		return panel;
	}

	public static JPanel createPanel(LayoutManager layout)
	{
		JPanel panel = new JPanel(layout);
		return panel;
	}

	public static JFrame createFrame()
	{
		JFrame frame = new JFrame();
		return frame;
	}

	public static JFrame createFrame(String title)
	{
		JFrame frame = new JFrame(title);
		return frame;
	}

	public static JFrame createFrame(String title, Dimension d, int exitOption)
	{
		JFrame frame = new JFrame(title);
		frame.setSize(d);
		frame.setDefaultCloseOperation(exitOption);
		return frame;
	}

	public static void addPanelToFrame(JFrame frame, JPanel panel, Object c)
	{
		frame.getContentPane().add(panel,c);
	}

	/*public static void addPanelToContainer(TODO frame, JPanel panel, GridBagConstraints c)
	{
		frame.getContentPane().add(panel,c);
	}*/

	public static void addComponentToPanel(JPanel panel, JComponent component, GridBagConstraints c)
	{
		panel.add(component, c);
	}
	
	public static GridBagConstraints GridBagConstraintReset(GridBagConstraints c)
	{
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.NONE;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 0);
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 0;
		c.weighty = 0;
		
		return c;
	}
}