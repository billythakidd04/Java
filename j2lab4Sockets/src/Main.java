import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JOptionPane;


public class Main 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		final int PORTNUM = 6999;
		//create update thread
		updateThread Update = new updateThread();
		Thread.sleep(10000);
		//create user thread
		userInterfaceThread User = new userInterfaceThread();
		
	}
}
