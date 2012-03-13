import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;


public class euler 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int sum = 0;
		int a = 1;  
		int b = 2;  
		Set<Integer> fib = new HashSet<Integer>();
		fib.add(a);
		fib.add(b);
		
		for(sum = 0; sum<4000000;)
		{
			sum = a + b;
			fib.add(sum);
			a = b;
			b = sum;
		}
		int total = 0;
		for(Integer i : fib)
		{
			if(i%2 == 0)
			{
				total += i;
			}
		}
		System.out.print(total);
	}
}
