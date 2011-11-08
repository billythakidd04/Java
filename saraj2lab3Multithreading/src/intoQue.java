import java.util.Queue;

import javax.swing.JOptionPane;


public class intoQue extends Thread
{
	Queue<String> userInfo = null;
	public intoQue(Queue<String> q)
	{
		userInfo = q;
		this.start();
	}
	
	public void run()
	{
		JOptionPane.showMessageDialog(null, "Ready for input");
		userInfo.offer(getInput());
	}
	
	private String getInput()
	{
		String temp = null;
		temp = JOptionPane.showInputDialog(null, "enter record number");
		temp = temp + " " + JOptionPane.showInputDialog(null, "enter item description");
		temp = temp + " " + JOptionPane.showInputDialog(null, "enter item quantity");
		
		return temp;
	}
	
	/*private String datacheck(String input, boolean numeric)
	{
		if (numeric == true)
		{
			try
			{
				Integer.parseInt(input);
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Numbers Only!!!!");
			}
		}
		
	}*/
}
