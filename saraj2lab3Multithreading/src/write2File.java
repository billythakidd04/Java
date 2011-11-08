import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Queue;

import javax.swing.JOptionPane;


public class write2File extends Thread
{
	final static int RECORDLENGTH = 62;
	
	Queue<String> schedualQ;
	RandomAccessFile file = null;
	
	public write2File(Queue<String> q) throws InterruptedException
	{
		schedualQ = q;
		File outputFile = new File("inventory.txt");
		if (outputFile.exists())
		{
			try 
			{
				file = new RandomAccessFile(outputFile,"rw");
			} 
			catch (FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else
		{
			try 
			{
				outputFile.createNewFile();
				file = new RandomAccessFile(outputFile,"rw");
			} 
			catch (FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, e);
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null, e);
			}
			
			for(short i = 0; i < 100; ++i)
			{
				try 
				{
					file.writeUTF("EMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTY");
				} 
				catch (IOException e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
	}
	
	public void run()
	{
		String itemInfo = null;
		itemInfo = schedualQ.poll();
		while (itemInfo == null)
		{
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			run();
		}
		long recordPos;
		try 
		{
			recordPos = calcLoc();
			file.seek(0);
			file.seek((recordPos-1)*RECORDLENGTH);
			file.writeUTF(itemInfo);
		}
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	
	private long calcLoc() throws IOException
	{
		try
		{
			file.seek(0);
			String temp = file.readUTF();
			while(temp.charAt(0)!='E')
			{
				file.seek(RECORDLENGTH);
				temp = file.readUTF();
			}
		}
		catch(EOFException e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return (file.getFilePointer()-RECORDLENGTH);
	}
}
