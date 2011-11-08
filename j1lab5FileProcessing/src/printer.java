import java.io.PrintWriter;
import java.util.Scanner;

public class printer 
{
	final static int MAX_WORD = 60;
	
	public static void main (String [] argv)
	throws Exception
	{	
		java.io.File file = new java.io.File(" mydata.txt ");
		PrintWriter output = new PrintWriter(file);
		output.print(" Pat Hoey Productions is a private company categorized under Advertising, Promotional, \n" +
				"and Trade Show Services and located in Auburn, MA.	 Our records show it was established in \n" +
				"1990 and incorporated in Massachusetts. Current estimates show this company has an annual \n" +
				"revenue of less than $500,000 and employs a staff of approximately 5 to 9.");
		output.close();
		
		
		
		String Sentence = " ";
		String[] indSentence = new String[25];
		Scanner input = new Scanner(file);	
		int counter =0;
		while(input.hasNext())
		{
			String word = input.next();
			if(word.charAt(word.length()-1) != '.')
			{
				Sentence += (" "+word);
			}
			else
			{
				Sentence += (" "+word);
				indSentence[counter++]=Sentence;
				Sentence = " ";
			}
		}
		
		String [] word = new String [MAX_WORD];
		for (int x=0; x<MAX_WORD; ++x )
		{
			word[x]=null;
		}
		for (int y =0; y < counter; ++y)
		{
			Scanner temp = new Scanner(indSentence[y]);
			for (int i = 0; i < MAX_WORD; ++i)
			{
				String tempWord = "";
				tempWord = temp.next();
				word[i] = tempWord;
				System.out.println("word number " + (i+1)+ " " + "sentance # " + (y+1) + " " + word[i]);
				if (tempWord.charAt(tempWord.length()-1) == '.')
				{
					break;
				}
			}
		}		
	}
}	


 
