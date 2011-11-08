
public class Card 
{
	//TODO create enums to handle cards suits values decks etc
	public enum Rank {TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE}
	public enum Suit {SPADES,HEARTS,DIAMONDS,CLUBS}

	private final Rank rank;
	private final Suit suit;

	public Card(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank(){return rank;}
	public Suit getSuit(){return suit;}
}
