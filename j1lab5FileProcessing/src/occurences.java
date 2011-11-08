
public class occurences 
{
	private int sentenceNumber = 0;
	private int wordNumber = 0;
	private int occurences = 0;
	private String word;
	
	public void incrementWord()
	{
		++occurences;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord(String word)
	{
		this.word=word;
	}
	
	public void setLocation(int sentence,int word)
	{
		sentenceNumber = sentence;
		wordNumber = word;
	}
	
	public String getInfo()
	{
		String out;
		out = "The word "+ this.word +" "+ "occurs "+ occurences + "times in the paragraph." +
				"\nThe word occurs at sentance # "+ sentenceNumber + " word # " + wordNumber;
		return out;
	}
}
