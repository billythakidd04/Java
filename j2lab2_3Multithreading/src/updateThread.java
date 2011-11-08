import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Queue;

import javax.swing.JOptionPane;


public class updateThread extends Thread
{
	final static int RECORDLENGTH = 62;
	private Queue<String> skedque;
	String pollQueue = null;
	public static RandomAccessFile file = null;
	
	public updateThread(Queue<String> q) 
	{
		skedque = q;
	}
	
	public void run()
	{
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
		pollQueue = skedque.poll();
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