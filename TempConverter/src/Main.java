import javax.swing.JOptionPane;

public class Main 
{
	public static void main(String[] args) 
	{
		String tempFar = null;
		double temp;
		double celcius;
		do
		{
			tempFar = JOptionPane.showInputDialog(null,"Please enter a temperature in farenheit.");
			if (!tempFar.matches("quit"))
			{
				temp = Double.parseDouble(tempFar);
				celcius = (5.0/9.0)*(temp - 32);
				JOptionPane.showMessageDialog(null, "The converted temperature is: " + celcius);
			}
		}
		while (!tempFar.matches("quit"));
	}
}
