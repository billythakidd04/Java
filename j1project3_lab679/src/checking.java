import javax.swing.JOptionPane;


public class checking extends Account
{
	
	public checking()
	{
		double balance = 0.0;
		double interestRate = 0.0;
		while(balance < 20000)
		{
			String temp = JOptionPane.showInputDialog(null, "Please enter starting balance");
			balance = Double.parseDouble(temp);
			if (balance < 20000)
			{
					JOptionPane.showMessageDialog(null, "Minimum balance is $20000");
			}
		}
		
		String temp = JOptionPane.showInputDialog(null, "Please enter annual interest rate");
		interestRate = Double.parseDouble(temp);
		
		Account checking = new Account(1122, balance, interestRate);
	}
	
	public String accountType()
	{
		return "Checking";
	}
	
	public int getId()
	{
		return this.getId();
	}
	
	public double getBalance()
	{
		return this.getBalance();
	}
	
	public double getAnnualInterestRate()
	{
		return this.getAnnualInterestRate();
	}
	
	public void setId(int c_id)
	{
		this.setId(c_id);
	}
	
	public void setBalance(double c_balance)
	{
		this.setBalance(c_balance);
	}
	
	public void setAnnualInterestRate(double c_interestRate)
	{
		this.setAnnualInterestRate (c_interestRate);
	}
	
	public double getMonthlyInterest()
	{
		return this.getMonthlyInterest();
	}
	
	public java.util.Date getDateCreated()
	{
		return this.getDateCreated();
	}
	
	public void withdraw(double amount)
	{
		this.withdraw(amount);
	}
	
	public void deposit(double amount)
	{
		this.deposit(amount);
	}
	
	public String getAlert(double amount)
	{
		return "The amount " + amount + " is greater than the maximum of $10,000";
	}
}
