
public class main {

	public static void main(String[] args)
	{
		int [] primeTest = new int[1000];//creating an array to store integers 1-1000
		
		for (int x=0;x<1000;x++)
		{
			primeTest[x] = x+2;	//fill array starting at element 0 with a value of 2
		}
		
		for (int x=0; x<primeTest.length; ++x)	//for loop using element x of primeTest[]
		{
			
			int divisor = primeTest[x];
			for (int i = 2; i<primeTest.length; ++i)
			{
				if (i>divisor)
				{
					if (divisor==0)
					{
						break;
					}
					else if ((i%divisor)==0)
					{
						primeTest[i-2]=0;
					}
				}
			}
		}	
		for (int x = 0; x<(primeTest.length-2);++x)
		{
			if (primeTest[x]!=0)
			{
				System.out.print(primeTest[x]+"\n");
			}
		}
	}
}