import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class shoe 
{
	private static final List<Card> cardDeck = new ArrayList<Card>();
	String [] deck = {"Ah","2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh","Ac","2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ad","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","As","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks"}; //hearts,clubs,diamonds,spades
	String [] inPlay = new String[10];
	
	public shoe()
	{
		for(Card.Suit suit : Card.Suit.values())
		{
			for(Card.Rank rank : Card.Rank.values())
			{
				cardDeck.add(new Card(rank, suit));
			}
		}
	}
	
	public String getcard()
	{
		String card = null;
		Random rand = new Random();
		card = deck[(int)rand.nextInt(51)];
		while(cardinplay(card)== true)
		{
			card = deck[(int)rand.nextInt(51)];
		}
		int i = 0;
		while (inPlay[i] != null)
		{
			++i;
		}
		inPlay[i] = card;
		return card;
	}
	
	private boolean cardinplay(String test)
	{
		boolean r = false;
		for(int i = 0; i < inPlay.length; ++i)
		{
			if (test.equalsIgnoreCase(inPlay[i]))
			{
				r = true;
				break;
			}
		}
		return r;
	}
}
