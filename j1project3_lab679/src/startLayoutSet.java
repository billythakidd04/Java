import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class startLayoutSet extends JFrame implements ActionListener
{
	static String choice = "Please Make A Choice";

	public startLayoutSet()
	{
		super(choice);
		this.setUp();
	}
	
	JButton bankBtn = new JButton("Click here for the Bank (Lab 6)");
	JButton exitBtn = new JButton("Exit");
	JButton aboutBtn = new JButton("About");
	
	void setUp()
	{
		setLayout(new GridLayout(3,1,0,0));
				
		add(bankBtn);
		add(aboutBtn);
		add(exitBtn);
		
		bankBtn.addActionListener(this);
		aboutBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}


	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == bankBtn)
		{
			this.hide();
			new lab6start();
		}
		else if (e.getSource() == aboutBtn)
		{
			new aboutStart();
		}			
		else if (e.getSource() == exitBtn)
		{
			System.exit(0);
		}
	}
}
