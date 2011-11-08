import java.util.Date;


public class Account 
{
	//global variables
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private java.util.Date dateCreated;
	
	//Constructors
	public Account()
	{
		id = 0;
		balance = 0.0;
		annualInterestRate = 0.0;
		dateCreated = new Date();
	}
	
	public Account(int a_id, double a_balance, double a_interestRate)
	{
		id = a_id;
		balance = a_balance;
		annualInterestRate = a_interestRate;
		dateCreated = new Date();
	}
	
	//Accessor methods
	public int getId()
	{
		return id;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	public java.util.Date getDateCreated()
	{
		return dateCreated;
	}
	
	//Mutator Methods
	public void setId(int a_id)
	{
		id = a_id;
	}
	
	public void setBalance(double a_balance)
	{
		balance = a_balance;
	}
	
	public void setAnnualInterestRate(double a_interestRate)
	{
		annualInterestRate = a_interestRate;
	}
	
	//account management methods
	public double getMonthlyInterest()
	{
		return (annualInterestRate / 12.0);
	}
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	public void deposit(double amount)
	{
		balance += amount;
	}
}