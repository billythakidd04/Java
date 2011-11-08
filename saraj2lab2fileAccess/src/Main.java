import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;


public class Main 
{
	static RandomAccessFile inventoryFile = null;
	static File filename = null;
	final static int RECORDLENGTH = 62;
	
	public static void fileAccess(String location)
	{
		
		filename = new File(location);

		if (filename.exists())
		{
			try 
			{
				inventoryFile = new RandomAccessFile(filename, "rw");//open file as read/write
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
				filename.createNewFile();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			fillNewFile(filename);
			fileAccess(location);
		}
	}
	
	private static void fillNewFile(File location)
	{
		try
		{
			inventoryFile = new RandomAccessFile(filename, "rw");
			for(short i = 0; i < 100; ++i)
			{
				inventoryFile.writeUTF("EMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTYEMPTY");
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "File Not Found! Try Again");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) 
	{
		String location = JOptionPane.showInputDialog(null, "Enter a file name");
		fileAccess(location);
		String command = JOptionPane.showInputDialog(null, "Please enter a command. NEW VIEW or QUIT");
		
		if (command.equalsIgnoreCase("new"))
		{
			String temp = null;
			String output = "";
			temp = JOptionPane.showInputDialog(null, "enter record number");
			output = temp + " ";
			int recordNumber = Integer.parseInt(temp);

			try 
			{
				inventoryFile.seek(0);
				inventoryFile.seek((recordNumber-1) * RECORDLENGTH);
				temp = inventoryFile.readUTF();
				boolean recordFull = false;
				do
				{
					if (temp.charAt(0)!= 'E')
					{
						JOptionPane.showMessageDialog(null, "record full try again");
						recordFull = true;
					}
					else
					{
						recordFull = false;
					}
				}while (recordFull == true);
				
				temp = JOptionPane.showInputDialog(null, "please enter item description");
				output += temp + " ";
				temp = JOptionPane.showInputDialog(null, "please enter quantity");
				output += temp;
				for (int i = output.length(); i < 60; i++)
				{
					output += " ";
				}
				
				inventoryFile.seek(0);
				inventoryFile.seek((recordNumber - 1) * RECORDLENGTH);
				inventoryFile.writeUTF(output);
			}
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else if (command.equalsIgnoreCase("view"))
		{
			String temp = JOptionPane.showInputDialog(null, "please enter the record number you want to view");
			int recordNumber = Integer.parseInt(temp);
			String recordInfo = null;
			try 
			{
				inventoryFile.seek(0);
				inventoryFile.seek((recordNumber-1) * RECORDLENGTH);
				recordInfo = inventoryFile.readUTF();
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null, e);
			}
			
			JOptionPane.showMessageDialog(null, recordInfo);
		}
		else if (command.equalsIgnoreCase("quit"))
		{
			JOptionPane.showMessageDialog(null, "Goodbye");
			System.exit(0);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid command; use new view or quit!!");
		}
	}

}
