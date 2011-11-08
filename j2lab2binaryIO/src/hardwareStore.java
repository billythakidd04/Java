import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;


public class hardwareStore
{
	final static int MAX_RECORDS = 100;		//maximum number of records allowed per file
	final static int MAX_DESC = 50;			//max char for item description
	final static int MAX_REC_DIGITS = 3;	//maximum digits for record number
	final static int MAX_ITEM_QTY = 999;	//max quantity per item
	final static int MAX_QTY_DIGITS = 3;	//see REC_DIGITS above
	final static int RECORD_LENGTH = 60;
	
	RandomAccessFile inventory;
	static hardwareStore store;
	
	//fileAccess method accepts file name as argument 
	private boolean fileAccess(File location) throws InterruptedException
	{
		if (location.exists())//if the file DOES exist
		{
			try 
			{
				inventory = new RandomAccessFile(location, "rw");//open file as read/write
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			String command = JOptionPane.showInputDialog(null,"add record or view existing?");
			
			if(command.equalsIgnoreCase("add"))
			{//here we add a new record with information provided by the user
				String recordNum;
				String itemName;
				String itemQuantity;
				
				boolean correctLength = true;
				do
				{//make sure the record number entered is both a number and less than or equal to the maximum record #
					recordNum = JOptionPane.showInputDialog(null,"Record Number:");
					try
					{
						if (Integer.parseInt(recordNum) > MAX_RECORDS || Integer.parseInt(recordNum) < 0)
						{
							JOptionPane.showMessageDialog(null, "record # must be between 0 and "+MAX_RECORDS);
							correctLength = false;
						}
						else
						{
							correctLength = true;
						}
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "numbers only please!");
						correctLength = false;
					}
				}while(correctLength == false);
				
				do
				{//make sure item description is < MAX_DESC
					itemName = JOptionPane.showInputDialog(null, "Item Name/Description");
					if (itemName.length() > MAX_DESC)
					{
						JOptionPane.showMessageDialog(null, "max of "+MAX_DESC+" characters");
						correctLength = false;
					}
					else
					{
						correctLength = true;
					}
				}while(correctLength == false);

				do
				{
					itemQuantity = JOptionPane.showInputDialog(null, "Quantity");
					try
					{
							Integer.parseInt(itemQuantity);		
						if(itemQuantity.length()>MAX_QTY_DIGITS)
						{
							JOptionPane.showMessageDialog(null,"quantity must be less than 1000");
							correctLength = false;
						}
						else
						{
							correctLength = true;
						}
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "numbers only please!");
						correctLength = false;
					}
				}while(correctLength == false);
				
				store.write2File(recordNum, itemName, itemQuantity);
			}
			else if (command.equalsIgnoreCase("view"))
			{
				int recordNum = Integer.parseInt(JOptionPane.showInputDialog(null,"Record Number:"));
				
				try 
				{
					inventory.seek(0);
					inventory.seek((recordNum-1)*60);
					String recordContents = inventory.readUTF();
					if (recordContents.charAt(0)!='R')
					{
						JOptionPane.showMessageDialog(null, recordContents);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "empty record");
					}
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("quit"))
			{
				try
				{
					inventory.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				return false;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Command! \nuse:\nadd,view,quit");
			}
		}
		else
		{
			try
			{
				location.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			makeFile(location);
			fileAccess(location);
		}
		return true;
	}
	
	
	private void makeFile(File location)
	{
		try
		{
			inventory = new RandomAccessFile(location, "rw");
			for(short i = 0; i < 100; ++i)
			{
				inventory.writeUTF("RRR DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD QQQ");
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
	
	private void write2File(String recordNum, String name, String itemQuantity) throws InterruptedException
	{
		try 
		{	
			inventory.seek(0);
			inventory.seek((Integer.parseInt(recordNum)-1)*60);
			while(recordNum.length() < MAX_REC_DIGITS)
			{
				recordNum=" "+recordNum;
			}
			while(name.length() < MAX_DESC)
			{
				name+=" ";
			}
			while(itemQuantity.length() < MAX_QTY_DIGITS)
			{
				itemQuantity=" "+itemQuantity;
			}
			
			inventory.writeUTF(recordNum+name+itemQuantity);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		Frame frame = new Frame("Hardware Store");
		String fileName;
		FileDialog openFile = new FileDialog(frame);
		openFile.show();
		fileName = openFile.getFile();
		/*String fileName = JOptionPane.showInputDialog(null, "What file do you want to use?");
		if(fileName.equals(JOptionPane.CANCEL_OPTION))
		{
			System.exit(0);
		}*/
		File location = new File(fileName);
		store = new hardwareStore();
		try 
		{
			while(store.fileAccess(location));
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}