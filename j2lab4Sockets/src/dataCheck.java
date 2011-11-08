import javax.swing.JOptionPane;



public class dataCheck
{
	public static boolean inputValidation(String check,int length,boolean numbersOnly)
	{
		boolean valid = true;
		if(numbersOnly==true)
		{
			try
			{
				Integer.parseInt(check);
				fixLen(check, length, true);
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, e);
				valid = false;
			}
		}
		return valid;
	}
	
	public static String fixLen(String check,int length,boolean isNumeric)
	{
		if(check.length()<length)
		{
			if(isNumeric)
			{
				while(check.length()<length)
				{
					check = " " + check;
				}
			}
			else
			{
				while(check.length()<length)
				{
					check += " ";
				}
			}
			check += " ";
		}

		else//check.length() > length
		{
			String strTemp = null;
			int i=0;
			while(i<length)
			{
				strTemp = check.substring(0, 3);//charAt(i) + strTemp;
				++i;
				check = strTemp;
			}
			if(isNumeric==true)
			{
				try
				{
					Integer.parseInt(check);
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
		return check;
	}
}
