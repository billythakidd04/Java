import java.util.Queue;
import javax.swing.JOptionPane;

public class userInterfaceThread extends Thread
{
	final static int RECORDDIGITLEN = 3;
	final static int QUANTITYDIGITLEN = 3;
	final static int DESCLEN = 50;
	private Queue<String> skedque;
	String output = null;
	
	public userInterfaceThread(Queue<String> q) 
	{
		skedque = q;
	}
	
	public void run()
	{
		//Inform User "ready for input"
		JOptionPane.showMessageDialog(null,"Ready for input");
		//Read user input into a string
		getInfo();
		//send string to queue
		skedque.offer(output);
		//tell user update scheduled
		JOptionPane.showMessageDialog(null, "Update scheduled");
		//kill thread
	}
	
	private String getInfo()
	{
		String input = JOptionPane.showInputDialog("enter record number");
		if (dataCheck.inputValidation(input,RECORDDIGITLEN,true))
		{
			input = dataCheck.fixLen(input, RECORDDIGITLEN, true);
			output = input;
		}
		else
		{
			run();
		}
		input = JOptionPane.showInputDialog("Description:");
		if(dataCheck.inputValidation(input,DESCLEN,false))
		{
			input = dataCheck.fixLen(input, DESCLEN, false);
			output += (input+" ");
		}
		else
		{
			run();
		}
		input = JOptionPane.showInputDialog("quantity");
		if(dataCheck.inputValidation(input,QUANTITYDIGITLEN,true))
		{
			input = dataCheck.fixLen(input, QUANTITYDIGITLEN, true);
			output += (input);
		}
		else
		{
			run();
		}
		return output;
	}
}