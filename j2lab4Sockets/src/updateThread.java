import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class updateThread extends Thread
{
	final static int RECORDLENGTH = 62;
	private ServerSocket q;
	private Socket recieve;
	String pollQueue = null;
	public static RandomAccessFile file = null;
	private DataInputStream input = null;
	final int PORTNUM = 6999;
	
	public updateThread() throws IOException
	{
		q = new ServerSocket(PORTNUM);
		this.start();
	}
	
	public void run()
	{
		//wait for connection
		try 
		{
			JOptionPane.showMessageDialog(null, "server not connected");
			recieve = q.accept();
			JOptionPane.showMessageDialog(null, "server connected");
			input = new DataInputStream(recieve.getInputStream());
		} 
		catch (IOException e2)
		{
			e2.printStackTrace();
		}
		//create/find file
		File location = new File("j2Threads.txt");
		if(location.exists())
		{
			try 
			{
				file = new RandomAccessFile(location, "rw");
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				location.createNewFile();
				RandomAccessFile file = new RandomAccessFile(location, "rw");
				for(short i = 0; i < 100; ++i)
				{
					file.writeUTF("RRR DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD QQQ");
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		try 
		{
			pollQueue = input.readUTF();
		} 
		catch (IOException e1)
		{
			JOptionPane.showMessageDialog(null, e1);
		}
		//access top string from queue
		try
		{
			//*calculate available record location in file
			if(!(pollQueue == null))                    // negative offset error   fixed
			{
				try
				{
					file.seek(0);
					String temp = null;
					int i;
					for(i = 0;i<file.length();file.seek(i+=RECORDLENGTH))
					{
						temp = file.readUTF();
						if(temp.charAt(2)=='R')   //checks 2 times and catches exception  
						{
							break;
						}
					}
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, e);     
				}
			}
			else
			{
				while(pollQueue==null)
				{
					sleep(1000);
				}
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		//write string to file at calculated location
		try
		{
		file.seek((file.getFilePointer()- RECORDLENGTH));
		file.writeUTF(pollQueue);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}