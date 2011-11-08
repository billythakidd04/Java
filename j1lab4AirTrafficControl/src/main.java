import javax.swing.JOptionPane;
import java.lang.Math;

public class main 
{

	public static void main(String[] args) 
	{
		String command = "Entering";
		aircraft [] controlList = new aircraft [18];
		while (!command.equalsIgnoreCase("quit"))
		{
			command = JOptionPane.showInputDialog("enter your command\nentering\nleaving\nshow\nlist\nnearest\nquit");
			if (command.equalsIgnoreCase("entering"))
			{
				
				String go = "yes";
				for (int i = 0; i < 18; ++i)
					{
						controlList[i] = null;
					}
				int x = 0;
				while (go.equalsIgnoreCase("yes"))
				{
					// find an unused element of controlList
					if (controlList[x] != null)
					{
						++x;
					}
					else
					{
						controlList[x] = new aircraft();
						controlList[x].entering();
						String choice = JOptionPane.showInputDialog("would you like to enter another?");
						if (choice.equalsIgnoreCase("no"))
						{
							go = "no";
						}
					}
				}
			}
			else if (command.equalsIgnoreCase("leaving"))
			{
				String thisName = JOptionPane.showInputDialog("enter air craft name");
				int x = 0;
				while (!thisName.equalsIgnoreCase(controlList[x].getName()))
				{
					x++;
				}
				if (thisName.equalsIgnoreCase(controlList[x].getName()))
				{
					controlList[x] = null;
				}
			}
			else if (command.equalsIgnoreCase("show"))
			{
				String craftName = JOptionPane.showInputDialog("enter craft name");
				for (int i = 0; i < controlList.length; i++)
				{
					if (controlList[i]==null)
					{
						continue;
					}
					else if (controlList[i].getName().equalsIgnoreCase(craftName))
					{
						controlList[i].show(craftName);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"please check your planes' name and try again");
						break;
					}
				}
			}
			else if (command.equalsIgnoreCase("list"))
			{
				String [] tempList = new String [18];
				for (int q=0;q<18;q++)
				{
					tempList[q]=null;
				}
				int count=0;
				for (int i = 0; i < controlList.length; i++)
				{
					if (controlList[i]==null)
					{
						continue;
					}
					else
					{
						tempList[count]=controlList[i].getName();
						++count;
					}	
				}
				String out="";
				for(int x = 0; x < tempList.length; ++x)
				{
					if (tempList[x]!=null)
					{
						out += (tempList[x]+"\n");
					}
				}
				JOptionPane.showMessageDialog(null, out);
			}
			else if (command.equalsIgnoreCase("nearest"))
			{
				double distanceTemp = (999999999);
				String craftName = JOptionPane.showInputDialog("enter craft name");
				for (int i =0; i < controlList.length; i++)
				{
					if (controlList[i]!=null)
					{
						if (controlList[i].getName().equalsIgnoreCase (craftName))
						{	
							for (int j = 0; j < controlList.length; j++)
							{
								if (controlList[j]!=null)
								{
									double distance = ((Math.pow(controlList[i].getxCoord() - controlList[j].getxCoord(),2)) + Math.pow(controlList[i].getyCoord() - controlList[j].getyCoord(),2) + Math.pow(controlList[i].getAltitude() - controlList[j].getAltitude(),2));
									Math.sqrt(distance);
									if (distance < distanceTemp && distance > 0)
									{
										distanceTemp = distance;
									}
								}
							}
						}
						JOptionPane.showMessageDialog(null,distanceTemp);
					}
				}
			}
		}
	}
}
