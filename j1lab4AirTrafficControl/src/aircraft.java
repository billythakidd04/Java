import javax.swing.JOptionPane;


public class aircraft 
{
	private	double xCoord;
	private double yCoord;		
	private	String name;
	private	String craftType;
	private	double altitude;
	private	double speed;
	private	String departTime;
	private	String arrivalTime;
		
	public void entering()
	{
		String temp;
		setName(JOptionPane.showInputDialog(null, "please enter the Aircraft Name"));
		craftType = JOptionPane.showInputDialog(null, "enter aircraft type");
		temp = JOptionPane.showInputDialog(null, "enter the x coord.");
		setxCoord (Double.parseDouble(temp));
		temp = JOptionPane.showInputDialog(null, "enter the y coord");
		setyCoord( Double.parseDouble(temp));
		temp = JOptionPane.showInputDialog(null,"enter altitude");
		setAltitude( Double.parseDouble(temp));
		temp = JOptionPane.showInputDialog(null,"enter speed");
		speed =  Double.parseDouble(temp);
		departTime = JOptionPane.showInputDialog(null,"enter departure time");
		arrivalTime = JOptionPane.showInputDialog(null, "please enter arrival time");
		JOptionPane.showMessageDialog(null, "aircraft "+ getName() +" will be added to your list");
	}
	
	public void show(String name)
	{
		
		JOptionPane.showMessageDialog(null,"Name: "+name+
								 "\nType: "+craftType+
								 "\nAltitude: "+getAltitude()+
								 "\nLocation: "+getxCoord()+","+getyCoord()+
								 "\nSpeed: "+speed+
								 "\nDeparture Time: "+departTime+
								 "\nArrival Time: "+arrivalTime);
	}

	
	public void setName(String name) 
	{
		this.name = name;
	}

	
	public String getName()
	{
		return name;
	}


	public void setxCoord(double xCoord) 
	{
		this.xCoord = xCoord;
	}


	public double getxCoord()
	{
		return xCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getAltitude() {
		return altitude;
	}

}