

public class gameCraps 
{
	int dice = roll();
	
	private static int roll()
	{
		int die1 = (int) (java.lang.Math.random()*6);
		int die2 = (int) (java.lang.Math.random()*6);
		
		int total = die1+die2;
		return total;
	}
	
	private static boolean yesWinner(int x)//x is the total of both dice... 7 or 11 wins...
	{
		switch (x)
		{
			case 7:
			{
				return true;
			}
			case 11:
			{
				return true;
			}
			default:
			{
				return false;
			}
		}
	}
}
